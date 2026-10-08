# Vue3 + Ajax 学习笔记

> 来源：黑马程序员 day02-Vue3基础.pptx（共43页）

---

## 一、Vue 快速入门

### 1.1 什么是 Vue

- **Vue** 是一套用于构建用户界面的**渐进式 JavaScript 框架**
- 核心思想：**数据驱动视图**（数据变化 → 视图自动更新）

### 1.2 Vue 生态

```
Vue 核心（声明式渲染、组件系统）
  ├── VueRouter    → 客户端路由
  ├── Vuex / Pinia → 状态管理
  └── Webpack/Vite → 构建工具
```

### 1.3 快速入门示例

```html
<div id="app">
  <h1>{{ message }}</h1>
</div>

<script type="module">
  import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

  createApp({
    data() {
      return {
        message: "Hello Vue"
      }
    }
  }).mount("#app");
</script>
```

**要点：**
- `createApp()` 创建 Vue 应用实例
- `data()` 返回响应式数据
- `mount("#app")` 挂载到 DOM 元素
- `{{ message }}` 插值表达式，将数据渲染到页面

---

## 二、Vue 常用指令

### 2.1 v-for — 列表渲染

**语法：**
```html
<tr v-for="(item, index) in items" :key="item.id">
  {{ item }}
</tr>
```

**要点：**
- `:key` 必须绑定唯一标识，**优先使用 id 而非 index**
- `item` 为当前遍历项，`index` 为索引

**案例数据（员工列表）：**
```js
data() {
  return {
    empList: [
      { "id": 1, "name": "谢逊", "image": "4.jpg", "gender": 1, "job": "1", "entrydate": "2023-06-09", "updatetime": "2024-07-30T14:59:38" },
      { "id": 2, "name": "韦一笑", "image": "1.jpg", "gender": 1, "job": "1", "entrydate": "2020-05-09", "updatetime": "2023-07-01T00:00:00" },
      { "id": 3, "name": "黛绮丝", "image": "2.jpg", "gender": 2, "job": "2", "entrydate": "2021-06-01", "updatetime": "2023-07-01T00:00:00" }
    ]
  }
}
```

### 2.2 v-bind — 属性绑定

**语法：**
```html
<!-- 完整写法 -->
<img v-bind:src="item.image">

<!-- 简写（推荐） -->
<img :src="item.image">
```

- `v-bind:属性名="值"` 可简写为 `:属性名="值"`
- 用于动态绑定 HTML 属性（src、href、class、style 等）

### 2.3 v-if / v-else-if / v-else — 条件渲染

**语法：**
```html
<span v-if="gender == 1">男</span>
<span v-else-if="gender == 2">女</span>
<span v-else>未知</span>
```

### 2.4 v-show — 条件显示

**语法：**
```html
<span v-show="条件">内容</span>
```

### v-if 与 v-show 的区别

| 对比项 | v-if | v-show |
|--------|------|--------|
| 实现方式 | 条件不成立时，**直接不渲染**该元素（DOM 中不存在） | 通过 CSS `display` 样式控制显示/隐藏（DOM 中存在） |
| 适用场景 | **不频繁切换**的场景 | **频繁切换**的场景 |

### 2.5 v-model — 双向数据绑定

**作用：** 在表单元素上使用，实现**双向数据绑定**，方便地获取或设置表单项数据。

**语法：**
```html
<input type="text" v-model="searchForm.name">
```

**数据定义：**
```js
data() {
  return {
    searchForm: {
      name: '',
      gender: '',
      job: ''
    }
  }
}
```

> **注意：** `v-model` 中绑定的变量，必须在 `data` 中定义。

### 2.6 v-on — 事件绑定

**作用：** 为 HTML 标签绑定事件（添加事件监听）。

**语法：**
```html
<!-- 完整写法 -->
<button v-on:click="handle">点我</button>

<!-- 简写（推荐） -->
<button @click="handle">再点我</button>
```

**方法定义：**
```js
const app = createApp({
  data() {
    return { /* ... */ }
  },
  methods: {
    handle() {
      console.log('试试就试试');
    }
  }
}).mount("#app");
```

> **注意：** `methods` 函数中的 `this` 指向 Vue 实例，可以通过 `this` 获取到 `data` 中定义的数据。

---

## 三、Ajax

### 3.1 什么是 Ajax

- **全称：** **A**synchronous **J**avaScript **A**nd **X**ML（异步的 JavaScript 和 XML）
- **作用：**
  - **数据交换：** 通过 Ajax 可以给服务器发送请求，并获取服务器响应的数据
  - **异步交互：** 可以在**不重新加载整个页面**的情况下，与服务器交换数据并**更新部分网页**（如搜索联想、用户名可用性校验等）

**XML：** Extensible Markup Language（可扩展标记语言），本质是一种数据格式，用来存储复杂的数据结构。

### 3.2 同步与异步

| 模式 | 特点 |
|------|------|
| **同步** | 客户端发送请求后**等待**服务器响应，期间不能执行其他操作 |
| **异步** | 客户端发送请求后**不等待**，可以继续执行其他操作，响应到达后再处理 |

### 3.3 Axios

- **介绍：** Axios 对原生 Ajax 进行了封装，简化书写，快速开发
- **官网：** https://www.axios-http.cn/

**使用步骤：**
1. 引入 Axios 的 JS 文件
2. 使用 Axios 发送请求，并获取响应结果

**引入方式：**
```html
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

**基本用法：**
```js
axios({
  method: 'GET',
  url: 'https://web-server.itheima.net/emps/list'
}).then((result) => {
  console.log(result.data);       // 成功回调
}).catch((err) => {
  alert(err);                      // 失败回调
});
```

**配置项说明：**
| 参数 | 说明 |
|------|------|
| `method` | 请求方式：GET / POST |
| `url` | 请求路径 |
| `data` | 请求数据（POST 时使用） |
| `params` | 发送请求时携带的 URL 参数，如 `...?key=val` |

### 3.4 Axios 请求方式别名（推荐）

**格式：** `axios.请求方式(url [, data [, config]])`

```js
// GET 请求
axios.get('https://mock.apifox.cn/m1/3083103-0-default/emps/list')
  .then((result) => {
    console.log(result.data);
  }).catch((err) => {
    console.log(err);
  });

// POST 请求
axios.post('https://mock.apifox.cn/m1/3083103-0-default/emps/update', 'id=1')
  .then((result) => {
    console.log(result.data);
  }).catch((err) => {
    console.log(err);
  });
```

### 3.5 async & await

**作用：** 通过 `async`、`await` 可以让异步变为同步操作。
- `async`：声明一个异步方法
- `await`：等待异步任务执行（取代 `.then()`）

```js
methods: {
  async search() {
    let result = await axios.get('https://web-server.itheima.net/emps/list?name=xxx&gender=xxx&job=xxx');
    this.employees = result.data.data;
  }
}
```

> **注意：** `await` 关键字只在 `async` 函数内有效，`await` 取代 `then` 函数，等待获取到请求成功的结果值。

**优点：** 可读性强、便于维护

### 3.6 Vue 生命周期

**生命周期：** 指一个对象从创建到销毁的整个过程。

Vue 生命周期共 **8 个阶段**，每触发一个生命周期事件，会自动执行一个生命周期方法（钩子）：

| 状态 | 阶段周期 |
|------|----------|
| `beforeCreate` | 创建前 |
| `created` | 创建后 |
| `beforeMount` | 载入前 |
| `mounted` | 挂载完成 |
| `beforeUpdate` | 数据更新前 |
| `updated` | 数据更新后 |
| `beforeUnmount` | 组件销毁前 |
| `unmounted` | 组件销毁后 |

**典型应用场景：** 在页面加载完毕时（`mounted` 钩子），发起异步请求，加载数据，渲染页面。

```js
const app = createApp({
  data() {
    return {
      message: "Hello Vue"
    }
  },
  // 生命周期钩子函数 mounted
  mounted() {
    console.log('Vue挂载完毕，发送请求获取数据 ...');
  }
}).mount("#app");
```

---

## 四、综合案例

### 4.1 员工列表数据渲染展示

使用 `v-for` + `v-bind` + `v-if` 将员工数据渲染为表格，包含序号、姓名、性别、头像、职位、入职日期、最后操作时间、操作（编辑/删除）列。

**职位映射：**
| job 值 | 职位 |
|--------|------|
| 1 | 班主任 |
| 2 | 讲师 |
| 3 | 学工主管 |
| 4 | 教研主管 |
| 5 | 咨询师 |

### 4.2 从服务器端动态获取数据

**服务端 URL：**
```
https://web-server.itheima.net/emps/list?name=xxx&gender=xxx&job=xxx
```

**完整流程：**
1. 页面加载 → `mounted()` 钩子触发 → 调用 `search()` 方法
2. `search()` 使用 `async/await` + `axios.get()` 请求服务端
3. 将返回数据赋值给 `this.employees`，Vue 自动更新视图
4. 用户输入搜索条件（`v-model` 绑定）→ 点击查询（`@click` 绑定）→ 重新请求
