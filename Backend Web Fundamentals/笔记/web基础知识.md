# Day04 - Web基础知识

> 来源：黑马程序员《第四章：后端Web基础(基础知识)》PPT

---

## 一、SpringBoot Web入门

### 1.1 Spring生态体系

Spring 生态包含多个子项目，俗称"Spring全家桶"：

| 项目 | 说明 |
|------|------|
| **Spring Framework** | Spring 框架，核心基础 |
| **Spring Boot** | 简化 Spring 应用的初始搭建和开发过程 |
| **Spring Data** | 简化数据访问层操作 |
| **Spring Cloud** | 微服务开发框架 |
| **Spring Security** | 安全框架，提供认证和授权 |

### 1.2 Spring Framework vs Spring Boot

| 对比项 | Spring Framework | Spring Boot |
|--------|-----------------|-------------|
| 配置 | 配置繁琐 | 简化配置 |
| 入门难度 | 入门难度大 | 快速开发 |
| 使用场景 | 传统项目 | 官方推荐，企业主流 |

Spring Boot 是 Spring 生态的核心，基于 Spring Framework，目的是简化 Spring 应用的创建、运行和部署。

### 1.3 SpringBoot Web 入门程序

#### 创建 SpringBoot 工程

1. 使用 **Spring Initializr** 创建工程（`https://start.spring.io`）
2. 勾选 **Spring Web** 依赖
3. 若 `start.spring.io` 连接不上，可改用阿里云镜像：`https://start.aliyun.com`

#### 入门程序代码

```java
@RestController  // 标识当前类是一个请求处理类
public class HelloController {

    @RequestMapping("/hello")  // 标识请求路径
    public String hello(String name) {
        System.out.println("HelloController ... hello : " + name);
        return "Hello " + name + " ~ ";
    }
}
```

#### 入门程序剖析

**依赖分析：**

- `spring-boot-starter-web`：Spring Web 的起步依赖
  - 包含 Spring MVC 相关依赖
  - 包含内嵌的 **Tomcat** 服务器

**运行流程：**

1. 启动 SpringBoot 应用（内嵌 Tomcat 自动启动，默认端口 8080）
2. 浏览器发送请求 `http://localhost:8080/hello?name=Tom`
3. Tomcat 接收请求，转发给 Spring MVC 处理
4. `@RequestMapping("/hello")` 匹配请求路径
5. 执行 `hello()` 方法，返回字符串
6. 响应结果返回给浏览器

**关键注解说明：**

| 注解 | 作用 |
|------|------|
| `@RestController` | 标识当前类为请求处理类（= `@Controller` + `@ResponseBody`） |
| `@RequestMapping` | 标识请求路径映射 |

**静态资源位置：** 放在 `resources/static` 目录下即可直接访问。

---

## 二、HTTP协议

### 2.1 HTTP 概述

- **HTTP**：Hyper Text Transfer Protocol，超文本传输协议
- 基于 **TCP** 协议
- 采用 **请求-响应** 模型
- **无状态**：每次请求之间相互独立

### 2.2 HTTP 请求数据格式

HTTP 请求由三部分组成：

```
请求行
请求头
[请求体]
```

#### 请求行

包含三个部分：

| 组成部分 | 说明 | 示例 |
|---------|------|------|
| 请求方式 | GET、POST、PUT、DELETE 等 | GET |
| 资源路径 | 请求的 URL 路径 | /hello |
| 协议版本 | HTTP 版本 | HTTP/1.1 |

#### 请求头

格式为 `key: value`，常见请求头字段：

| 请求头 | 说明 |
|--------|------|
| `Host` | 请求的主机名和端口号 |
| `User-Agent` | 浏览器/客户端信息 |
| `Accept` | 客户端可接受的内容类型 |
| `Accept-Language` | 客户端可接受的语言 |
| `Accept-Encoding` | 客户端可接受的编码方式 |
| `Connection` | 连接方式（keep-alive / close） |
| `Cookie` | 客户端携带的 Cookie 信息 |

#### 请求体

- 只有 **POST** 请求才有请求体
- 用于携带请求参数数据

#### GET vs POST 对比

| 对比项 | GET | POST |
|--------|-----|------|
| 参数位置 | 请求行（URL 中） | 请求体中 |
| 参数大小 | 有大小限制 | 无大小限制 |
| 安全性 | 较低（参数暴露在 URL 中） | 相对较高 |
| 用途 | 查询数据 | 提交数据 |

### 2.3 请求数据获取 —— HttpServletRequest

Web 服务器（Tomcat）解析 HTTP 请求数据并封装为 `HttpServletRequest` 对象。

```java
@RequestMapping("/request")
public String request(HttpServletRequest request) {
    // 1. 获取请求参数 name, age
    String name = request.getParameter("name");       // Tom
    String age = request.getParameter("age");         // 10

    // 2. 获取请求路径 uri 和 url
    String uri = request.getRequestURI();             // /request
    String url = request.getRequestURL().toString();  // http://localhost:8080/request

    // 3. 获取请求头 User-Agent
    String userAgent = request.getHeader("User-Agent");

    // 4. 获取请求方式
    String method = request.getMethod();              // GET

    // 5. 获取请求的查询字符串
    String queryString = request.getQueryString();    // name=Tomcat&age=10

    return "request success";
}
```

**常用方法总结：**

| 方法 | 说明 |
|------|------|
| `getParameter(name)` | 根据参数名获取参数值 |
| `getRequestURI()` | 获取请求 URI |
| `getRequestURL()` | 获取请求完整 URL |
| `getHeader(name)` | 根据请求头名称获取值 |
| `getMethod()` | 获取请求方式 |
| `getQueryString()` | 获取查询字符串 |

### 2.4 HTTP 响应数据格式

HTTP 响应由三部分组成：

```
响应行
响应头
响应体
```

#### 响应行

包含三个部分：

| 组成部分 | 说明 | 示例 |
|---------|------|------|
| 协议版本 | HTTP 版本 | HTTP/1.1 |
| 状态码 | 响应状态码 | 200 |
| 状态描述 | 状态码的文字描述 | OK |

#### 状态码分类

| 分类 | 说明 |
|------|------|
| **1xx** | 响应中（信息性状态码） |
| **2xx** | 成功 |
| **3xx** | 重定向 |
| **4xx** | 客户端错误 |
| **5xx** | 服务端错误 |

#### 常见状态码

| 状态码 | 说明 |
|--------|------|
| **200** | 请求成功 |
| **404** | 请求的资源不存在 |
| **500** | 服务器内部错误 |

### 2.5 响应数据设置

#### 方式一：基于 HttpServletResponse

```java
@RequestMapping("/response")
public void response(HttpServletResponse response) throws IOException {
    // 1. 设置响应状态码
    response.setStatus(401);
    // 2. 设置响应头
    response.setHeader("itheima", "itheima");
    // 3. 设置响应体
    response.getWriter().write("<h1>Hello Response</h1>");
}
```

#### 方式二：基于 ResponseEntity（推荐）

```java
@RequestMapping("/response")
public ResponseEntity<String> response() {
    return ResponseEntity.status(401)        // 1. 设置响应状态码
            .header("group", "itcast")       // 2. 设置响应头
            .body("<h1>Hello Response</h1>"); // 3. 设置响应体
}
```

#### @ResponseBody 注解

- 将 Controller 方法的返回值**直接写入 HTTP 响应体**
- 如果返回的是对象或集合，会先转为 **JSON** 格式再写入响应体
- `@RestController` = `@Controller` + `@ResponseBody`

---

## 三、SpringBoot Web 案例

### 3.1 案例需求

开发 Web 程序，完成**用户列表的渲染展示**。

### 3.2 准备工作

1. 创建 SpringBoot 工程（勾选 Web 依赖、Lombok）
2. 引入 `user.txt` 数据文件和前端静态页面 `user.html`
3. 定义实体类 `User`

### 3.3 初始实现（未分层）

```java
@RestController
public class UserController {

    @RequestMapping("/list")
    public List<User> list() {
        // 1. 加载并读取文件
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in,
                StandardCharsets.UTF_8, new ArrayList<>());

        // 2. 解析数据，封装成对象 --> 集合
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5],
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        // 3. 响应数据
        return userList;
    }
}
```

**问题：** 所有逻辑（数据访问、业务逻辑、请求响应）都写在 Controller 中，导致：
- **复用性差**
- **难以维护**

---

## 四、分层解耦

### 4.1 三层架构

基于**单一职责原则**，将代码拆分为三层：

```
浏览器 → Controller → Service → Dao → 数据库/文件
```

| 层次 | 名称 | 职责 |
|------|------|------|
| **Controller** | 控制层 | 接收前端发送的请求，对请求进行处理，并响应数据 |
| **Service** | 业务逻辑层 | 处理具体的业务逻辑 |
| **Dao** | 数据访问层（Data Access Object / 持久层） | 负责数据访问操作，包括数据的增、删、改、查 |

#### 拆分后的代码结构

**Controller 层 —— 接收请求，响应数据：**

```java
@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();

    @RequestMapping("/list")
    public List<User> list2() {
        // 1. 调用 service，查询用户信息
        List<User> userList = userService.list();
        // 2. 响应数据
        return userList;
    }
}
```

**Service 层 —— 业务逻辑处理：**

```java
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> list() {
        // 1. 调用 dao 获取数据
        List<String> lines = userDao.list();
        // 2. 解析数据，封装成对象 --> 集合
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5],
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());
        return userList;
    }
}
```

**Dao 层 —— 数据访问操作：**

```java
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> list() {
        // 1. 加载并读取文件
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("user.txt");
        List<String> lines = IoUtil.readLines(in,
                StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
```

**拆分前后对比：**

| 对比项 | 拆分前 | 拆分后 |
|--------|--------|--------|
| 复用性 | 差 | 强 |
| 可维护性 | 难以维护 | 方便维护 |

### 4.2 分层解耦

#### 核心概念

| 概念 | 说明 |
|------|------|
| **耦合** | 衡量软件中各个层/各个模块的依赖关联程度 |
| **内聚** | 软件中各个功能模块内部的功能联系 |
| **设计原则** | **高内聚低耦合** |

#### 问题分析

分层后，Controller 中 `new UserServiceImpl()`、Service 中 `new UserDaoImpl()` 仍然存在**硬编码依赖**，层与层之间耦合度高。如果更换实现类（如 `UserServiceImpl` → `UserServiceImpl2`），需要修改多处代码。

#### 解决思路：IOC + DI

```
Controller（不 new 对象）
    ↓ 依赖注入（DI）
容器（IOC 容器管理对象创建）
    ↓ 控制反转（IOC）
Service / Dao 实现类
```

- **控制反转（IOC，Inversion of Control）**：对象的创建控制权由程序自身转移到外部（容器），这种思想称为控制反转
- **依赖注入（DI，Dependency Injection）**：容器为应用程序提供运行时所依赖的资源，称之为依赖注入
- **Bean 对象**：IOC 容器中创建、管理的对象，称之为 Bean

**实现分层解耦的思路：**
1. 将项目中的类交给 IOC 容器管理（IOC，控制反转）
2. 应用程序运行时需要什么对象，直接依赖容器为其提供（DI，依赖注入）

### 4.3 IOC & DI 入门

#### 实现步骤

1. 将 Dao 及 Service 层的实现类，交给 IOC 容器管理
2. 为 Controller 及 Service 注入运行时所依赖的对象

**改造后的代码：**

```java
// Controller 层
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list() {
        List<User> userList = userService.list();
        return userList;
    }
}

// Service 层
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        List<String> lines = userDao.list();
        // 解析数据...
        return userList;
    }
}

// Dao 层
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> list() {
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("user.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}
```

**关键注解：**
- `@Component`：将类交给 IOC 容器管理（加在**实现类**上，而非接口上）
- `@Autowired`：从 IOC 容器中找到该类型的 Bean，完成依赖注入

### 4.4 IOC 详解

#### 声明 Bean 的注解

| 注解 | 说明 | 使用位置 |
|------|------|---------|
| `@Component` | 声明 Bean 的基础注解 | 不属于以下三类时使用 |
| `@Controller` | 标识**表现层** Bean | Controller 层 |
| `@Service` | 标识**业务层** Bean | Service 层 |
| `@Repository` | 标识**数据访问层** Bean | Dao 层 |

> **注意：** 声明 Bean 的时候，可以通过注解的 `value` 属性指定 Bean 的名字，如果没有指定，默认为**类名首字母小写**。

#### 组件扫描

声明 Bean 的四大注解要想生效，还需要被组件扫描注解 `@ComponentScan` 扫描。

- 该注解已包含在启动类声明注解 `@SpringBootApplication` 中
- **默认扫描范围**：启动类所在包及其子包

```
com.itheima
├── controller    ← 被扫描
├── dao           ← 被扫描
├── pojo          ← 被扫描
├── service       ← 被扫描
└── TliasManagementApplication  ← 启动类（所在包为扫描根路径）
```

> **注意：** 在 SpringBoot 集成 Web 开发中，声明控制器 Bean 只能用 `@Controller`（或 `@RestController`）。

### 4.5 DI 详解

#### 依赖注入的三种方式

**① 属性注入**

```java
@RestController
public class UserController {
    @Autowired
    private UserService userService;
}
```

- 优点：代码简洁、方便快速开发
- 缺点：隐藏了类之间的依赖关系、可能会破坏类的封装性

**② 构造函数注入**

```java
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
```

- 优点：能清晰地看到类的依赖关系、提高了代码的安全性
- 缺点：代码繁琐、如果构造参数过多，可能会导致构造函数臃肿
- **注意：如果只有一个构造函数，`@Autowired` 注解可以省略**

**③ Setter 注入**

```java
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
```

- 优点：保持了类的封装性，依赖关系更清晰
- 缺点：需要额外编写 setter 方法，增加了代码量

#### 依赖注入的匹配规则

- `@Autowired` 默认按照**类型**进行注入
- 如果存在多个相同类型的 Bean，会报错：

```
Field userService in com.itheima.controller.UserController required a single bean, but 2 were found:
  - userServiceImpl: defined in file [...]
  - userServiceImpl2: defined in file [...]
```

#### 多 Bean 解决方案

| 方案 | 注解 | 说明 |
|------|------|------|
| **方案一** | `@Primary` | 加在 Bean 实现类上，标记为首选 Bean |
| **方案二** | `@Autowired` + `@Qualifier` | 指定 Bean 的名称进行注入 |
| **方案三** | `@Resource` | 直接按名称注入（JavaEE 规范） |

**方案一：@Primary**

```java
@Primary
@Service
public class UserServiceImpl implements UserService {
    // ...
}
```

**方案二：@Qualifier**

```java
@RestController
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
}
```

**方案三：@Resource**

```java
@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
}
```

#### @Resource 与 @Autowired 的区别

| 对比项 | `@Autowired` | `@Resource` |
|--------|-------------|-------------|
| 来源 | Spring 框架提供的注解 | JavaEE 规范提供的注解 |
| 默认注入方式 | 按**类型**注入 | 按**名称**注入 |
