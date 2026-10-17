# MySQL 数据库

> 来源：Day05-数据库.pptx（黑马程序员）

---

## 一、MySQL 概述

### 1.1 数据库相关概念

| 概念 | 说明 |
|------|------|
| **DB（Database）** | 数据库，存储和管理数据的仓库 |
| **DBMS（Database Management System）** | 数据库管理系统，操纵和管理数据库的大型软件 |
| **SQL（Structured Query Language）** | 结构化查询语言，用于操作关系型数据库的编程语言 |

### 1.2 常见数据库产品

| 数据库 | 特点 |
|--------|------|
| **Oracle** | 收费，大型数据库 |
| **MySQL** | 开源免费，中小型数据库 |
| **SQL Server** | Microsoft 收费，中型数据库 |
| **PostgreSQL** | 开源免费，中小型数据库 |
| **DB2** | IBM 大型收费数据库 |
| **SQLite** | 嵌入式微型数据库 |
| **MariaDB** | 开源免费，中小型数据库 |

### 1.3 MySQL 安装

MySQL 分为两个版本：

- **商业版（MySQL Enterprise Edition）**：收费，功能更全面，提供 30 天试用期
- **社区版（MySQL Community Server）**：免费开源，本课程使用 **MySQL Community Server 8.0.34**

### 1.4 MySQL 连接

```bash
mysql -u用户名 -p密码 [-h数据库服务器IP地址 -P端口号]
```

- `-u`：用户名
- `-p`：密码
- `-h`：数据库服务器 IP 地址（可选，默认 localhost）
- `-P`：端口号（可选，默认 3306）

**企业开发中的远程连接示例：**

```bash
mysql -h47.98.197.202 -P3306 -uroot -p
```

### 1.5 数据模型

**关系型数据库**：建立在关系模型基础上，由多张相互连接的二维表组成的数据库。

数据模型层级：

```
DBMS（数据库管理系统）
└── 数据库（Database）
    └── 表（Table）
        └── 数据/记录（Record）
```

- 一个 DBMS 可以管理多个数据库
- 一个数据库可以包含多张表
- 一张表包含多条记录

### 1.6 MySQL 客户端工具

| 工具 | 说明 |
|------|------|
| **命令行** | 无提示，无历史记录 |
| **SQLyog** | GUI 图形化工具 |
| **Navicat** | GUI 图形化工具 |
| **IntelliJ IDEA** | 集成开发环境 |
| **DataGrip** | JetBrains 数据库工具 |

---

## 二、SQL 语句

### 2.1 SQL 分类

| 分类 | 全称 | 说明 |
|------|------|------|
| **DDL** | Data Definition Language | 数据定义语言，定义数据库对象（数据库、表、字段等） |
| **DML** | Data Manipulation Language | 数据操作语言，对数据库表中的数据进行增删改 |
| **DQL** | Data Query Language | 数据查询语言，查询数据库表中的记录 |
| **DCL** | Data Control Language | 数据控制语言，定义访问权限和安全级别 |

---

### 2.2 DDL — 数据库操作

```sql
-- 查询所有数据库
show databases;

-- 查询当前数据库
select database();

-- 使用数据库
use 数据库名;

-- 创建数据库
create database [if not exists] 数据库名 [default charset utf8mb4];

-- 删除数据库
drop database [if exists] 数据库名;
```

---

### 2.3 DDL — 表结构

#### 2.3.1 创建表

```sql
create table tablename(
    字段1 字段类型 [约束] [comment 字段1注释],
    字段2 字段类型 [约束] [comment 字段2注释],
    ...
)[comment 表注释];
```

#### 2.3.2 数据类型

MySQL 中的数据类型有很多，主要分为三类：数值类型、字符串类型、日期时间类型。

**数值类型：**

| 类型 | 大小 | 有符号范围 (Signed) | 无符号范围 (Unsigned) | 说明 |
|------|------|---------------------|----------------------|------|
| TINYINT | 1 byte | -128 ~ 127 | 0 ~ 255 | 小整数值 |
| SMALLINT | 2 bytes | -32768 ~ 32767 | 0 ~ 65535 | 大整数值 |
| MEDIUMINT | 3 bytes | -8388608 ~ 8388607 | 0 ~ 16777215 | 大整数值 |
| INT / INTEGER | 4 bytes | -2147483648 ~ 2147483647 | 0 ~ 4294967295 | 大整数值 |
| BIGINT | 8 bytes | -2^63 ~ 2^63-1 | 0 ~ 2^64-1 | 极大整数值 |
| FLOAT | 4 bytes | - | - | 单精度浮点数 |
| DOUBLE | 8 bytes | - | - | 双精度浮点数 |
| DECIMAL | 可变 | - | - | 精确数值类型（如金额） |

> **说明：**
> - `unsigned`：无符号类型，表示只能取 0 及正数
> - 不加 `unsigned` 默认是 `signed`，表示可以取负数
> - `DECIMAL(M,D)`：M 为总位数，D 为小数位数，适合存储精确数值（如薪资、价格）

**字符串类型：**

| 类型 | 大小 | 说明 |
|------|------|------|
| **CHAR** | 0-255 bytes | 定长字符串，长度固定，不足用空格填充 |
| **VARCHAR** | 0-65535 bytes | 变长字符串，长度可变 |
| TINYTEXT | 0-255 bytes | 短文本 |
| TEXT | 0-65535 bytes | 长文本 |
| MEDIUMTEXT | 0-16777215 bytes | 中等长度文本 |
| LONGTEXT | 0-4294967295 bytes | 极长文本 |

> **说明：**
> - **CHAR 与 VARCHAR 的区别**：CHAR 是定长字符串，VARCHAR 是变长字符串
> - 如果一个字段的长度是固定的，建议使用 **CHAR**；如：身份证号、手机号
> - 如果一个字段的长度不是固定的，建议使用 **VARCHAR**；如：用户名、姓名

**日期时间类型：**

| 类型 | 大小 | 格式 | 说明 |
|------|------|------|------|
| DATE | 3 bytes | YYYY-MM-DD | 日期值 |
| TIME | 3 bytes | HH:MM:SS | 时间值 |
| DATETIME | 8 bytes | YYYY-MM-DD HH:MM:SS | 日期+时间 |
| TIMESTAMP | 4 bytes | YYYY-MM-DD HH:MM:SS | 时间戳（自动更新） |
| YEAR | 1 byte | YYYY | 年份 |

> **说明：**
> - `DATETIME` 和 `TIMESTAMP` 格式相同，但 `TIMESTAMP` 会自动记录数据的创建和修改时间
> - `TIMESTAMP` 的范围是 1970-01-01 00:00:01 UTC 到 2038-01-19 03:14:07 UTC

#### 2.3.3 约束

约束是作用于表中字段上的规则，用于限制存储在表中的数据。目的是保证数据库中数据的正确性、有效性和完整性。

| 约束 | 描述 | 关键字 |
|------|------|--------|
| 非空约束 | 限制该字段值不能为 null | `not null` |
| 唯一约束 | 保证字段的所有数据都是唯一、不重复的 | `unique` |
| 主键约束 | 主键是一行数据的唯一标识，要求非空且唯一 | `primary key` |
| 默认约束 | 保存数据时，如果未指定该字段值，则采用默认值 | `default` |
| 外键约束 | 让两张表的数据建立连接，保证数据的一致性和完整性 | `foreign key` |

> **说明：**
> - 一个字段上可以添加多个约束，多个约束之间使用空格分开
> - 定义主键的时候指定关键字 `auto_increment` 可实现主键自增效果
> - 一张表只能有一个主键

#### 2.3.4 查询表结构

```sql
-- 查询当前数据库的所有表
show tables;

-- 查询表结构
desc 表名;

-- 查询建表语句
show create table 表名;
```

#### 2.3.5 修改表结构

```sql
-- 添加字段
alter table 表名 add 字段名 类型(长度) [comment 注释] [约束];

-- 修改字段类型
alter table 表名 modify 字段名 新数据类型(长度);

-- 修改字段名与字段类型
alter table 表名 change 旧字段名 新字段名 类型(长度) [comment 注释] [约束];

-- 删除字段
alter table 表名 drop column 字段名;

-- 修改表名
alter table 表名 rename to 新表名;
```

#### 2.3.6 删除表

```sql
drop table [if exists] 表名;
```

---

### 2.4 DML — 数据操作

#### 2.4.1 添加数据（INSERT）

```sql
-- 指定字段添加数据
insert into 表名(字段名1, 字段名2) values (值1, 值2);

-- 全部字段添加数据
insert into 表名 values (值1, 值2, ...);

-- 批量添加数据（指定字段）
insert into 表名 (字段名1, 字段名2) values (值1, 值2), (值1, 值2);

-- 批量添加数据（全部字段）
insert into 表名 values (值1, 值2, ...), (值1, 值2, ...);
```

**注意事项：**
- 字段与值要一一对应
- 字符串和日期类型值需要用引号包裹
- 批量添加时，每组值用逗号分隔

#### 2.4.2 修改数据（UPDATE）

```sql
update 表名 set 字段名1 = 值1, 字段名2 = 值2, ... [where 条件];
```

**注意事项：**
- 必须加 `where` 条件，否则会修改表中所有记录
- 可以同时修改多个字段，用逗号分隔

#### 2.4.3 删除数据（DELETE）

```sql
delete from 表名 [where 条件];
```

**注意事项：**
- 必须加 `where` 条件，否则会删除表中所有记录
- `DELETE` 删除数据后，自增主键不会重置；`TRUNCATE TABLE` 会重置

---

### 2.5 DQL — 数据查询

#### 2.5.1 完整语法

```sql
select 字段列表
from 表名
[where 条件列表]
[group by 分组字段名 [having 分组后过滤条件]]
[order by 排序字段 排序方式]
[limit 起始索引, 查询记录数];
```

#### 2.5.2 基本查询

```sql
-- 查询多个字段
select 字段1, 字段2, 字段3 from 表名;

-- 查询所有字段
select * from 表名;

-- 设置别名
select 字段1 [as 别名1], 字段2 [as 别名2] from 表名;

-- 去除重复记录
select distinct 字段列表 from 表名;
```

#### 2.5.3 条件查询

```sql
select 字段列表 from 表名 where 条件列表;
```

**比较运算符：**

| 运算符 | 说明 |
|--------|------|
| `>` | 大于 |
| `>=` | 大于等于 |
| `<` | 小于 |
| `<=` | 小于等于 |
| `=` | 等于 |
| `<>` 或 `!=` | 不等于 |
| `BETWEEN ... AND ...` | 在某个范围之内（含两端） |
| `IN (...)` | 在某个集合中 |
| `LIKE` | 模糊查询 |
| `IS NULL` | 判断是否为 NULL |

**LIKE 通配符：**
- `_`：匹配单个字符
- `%`：匹配任意个字符（包括 0 个）

**逻辑运算符：**

| 运算符 | 说明 |
|--------|------|
| `AND` / `&&` | 并且（多个条件同时满足） |
| `OR` / `\|\|` | 或者（多个条件满足其一） |
| `NOT` / `!` | 非（取反） |

#### 2.5.4 分组查询

```sql
select 字段列表
from 表名
[where 条件列表]
group by 分组字段名
[having 分组后过滤条件];
```

**聚合函数：**

| 函数 | 说明 |
|------|------|
| `COUNT()` | 统计数量 |
| `MAX()` | 最大值 |
| `MIN()` | 最小值 |
| `AVG()` | 平均值 |
| `SUM()` | 求和 |

**注意事项：**
- NULL 值不参与聚合函数计算
- 推荐使用 `COUNT(*)` 而非 `COUNT(字段)`，因为 `COUNT(*)` 会统计所有行
- `WHERE` 在分组**前**过滤，`HAVING` 在分组**后**过滤
- 执行顺序：`WHERE` → 聚合函数 → `HAVING`

#### 2.5.5 排序查询

```sql
select 字段列表
from 表名
[where 条件列表]
[group by 分组字段名 having 分组后过滤条件]
order by 排序字段 排序方式;
```

- `ASC`：升序（默认）
- `DESC`：降序
- 多字段排序时，先按第一个字段排序，第一个字段值相同时再按第二个字段排序

#### 2.5.6 分页查询

```sql
select 字段
from 表名
[where 条件]
[group by 分组字段 having 过滤条件]
[order by 排序字段]
limit 起始索引, 查询记录数;
```

**说明：**
1. 起始索引从 **0** 开始
2. 分页查询是数据库的**方言**，不同数据库有不同的实现，MySQL 中使用 `LIMIT`
3. 如果起始索引为 0，可以省略，直接简写为 `limit 10`

**项目开发中的分页公式：**

> 前端传递的是**页码**，需要转换为**起始索引**
>
> **起始索引 = (页码 - 1) × 每页展示记录数**

---

## 三、小结

### DDL（数据定义语言）
- 数据库操作：`show databases`、`use`、`create database`、`drop database`
- 表结构操作：`create table`、`show tables`、`desc`、`alter table`、`drop table`

### DML（数据操作语言）
- `INSERT`：添加数据
- `UPDATE`：修改数据（注意加 `where` 条件）
- `DELETE`：删除数据（注意加 `where` 条件）

### DQL（数据查询语言）
- 基本查询：`select`、别名、`distinct`
- 条件查询：比较运算符、逻辑运算符、`LIKE`、`BETWEEN`、`IN`、`IS NULL`
- 分组查询：聚合函数（`COUNT`/`MAX`/`MIN`/`AVG`/`SUM`）、`GROUP BY`、`HAVING`
- 排序查询：`ORDER BY`（`ASC`/`DESC`）
- 分页查询：`LIMIT 起始索引, 记录数`
