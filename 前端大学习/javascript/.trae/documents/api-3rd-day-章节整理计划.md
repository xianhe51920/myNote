# API 课程 11~19 章节整理计划

## Summary

将 `e:\前端大学习\javascript\APIs` 文件夹中**第 3 天起的新增截图**（11.事件流 ~ 19.本地存储 共 9 个子文件夹，约 67 张图）按之前 0~10 章相同的标准（三级标题 + 引子 + 表格 + 代码块 + Mermaid）整理到 [javascript.md](file:///e:/%E5%89%8D%E7%AB%AF%E5%A4%A7%E5%AD%A6%E4%B9%A0/javascript/javascript.md) 的 `## APIs` 节点下，并更新 `### 课程导览` 表格加入第 3 天及后续课程。

## Current State Analysis

- **`javascript.md`** 当前 `## APIs` 章节下已包含 `### 课程导览` 与 `### 0.~10.` 共 12 个子节，约 597 行。
- **`APIs\`** 现有 19 个子文件夹，其中 0~10 已整理完毕，**本次任务目标 11~19**：
  - `11.事件流`（0-7.png, 8 张）
  - `12.事件委托`（0-4.png, 4 张）
  - `13.其它事件`（0-16.png, 16 张）
  - `14.日期对象`（**`0..png` 双点异常文件名** + 1-7.png, 7 张有效）
  - `15.节点操作`（0-12.png, 12 张）
  - `16.M端事件`（1.png, 1 张）
  - `17.JS插件`（1-2.png, 2 张）
  - `18.windows对象`（0-14.png, 14 张）
  - `19.本地存储`（0-12.png, 12 张）
- **`api课程安排\`** 新增 `7.png`~`9.png`（第 3 天：Web APIs 第三天 - Dom 事件进阶）。
- **已通过 0.png 抽样的章节大纲**（Phase 1 已确认）：

| 章节 | 0.png 大纲 | 已抽样子节 |
|---|---|---|
| 11. 事件流 | 事件流与两个阶段说明 / 事件捕获 / 事件冒泡 / 阻止冒泡 / 解绑事件 | 1.1~1.5 已读全 |
| 12. 事件委托 | 委托的好处（图示：爸爸照顾孩子） | 1.png 思考 / 2.png 实现 |
| 13. 其它事件 | 页面加载事件 / 元素滚动事件 / 页面尺寸事件 | 1.png load / 2.png 总结 / 3.png DOMContentLoaded |
| 14. 日期对象 | （无 0.png，使用 1.png）日期对象 + 学习路径：实例化/方法/时间戳 | 1.png 概念 / 2.png 实例化 / 3.png getXxx / 4.png toLocale / 5.png 时间戳 |
| 15. 节点操作 | DOM 节点 / 查找节点 / 增加节点 / 删除节点 | 1.png 类型 / 2.png 总结 / 3.png parentNode / 4.png childNodes/children |
| 16. M 端事件 | （无 0.png）触屏事件 | 1.png touchstart/move/end |
| 17. JS 插件 | （无 0.png）插件概念 / swiper 学习路径 | 1.png swiper 5 步 / 2.png 本地文件 |
| 18. windows 对象 | BOM / 定时器-延时函数 / JS 执行机制 / location / navigator / history | 1.png BOM / 2.png setTimeout / 3.png 单线程 / 4.png 同步/异步 |
| 19. 本地存储 | 本地存储介绍 / 本地存储分类 / 存储复杂数据类型 | 1.png 介绍 / 2.png localStorage 特性 / 3.png setItem/getItem / 4.png + removeItem |

## Proposed Changes

### 改动 1：更新 `javascript.md` 课程导览表格（L2094 附近）

**文件**：`e:\前端大学习\javascript\javascript.md`

**变更**：在 `### 课程导览` 下的课程安排表格中，**追加第 3~7 天**（如课件未提及，可只追加第 3 天；其余以"待补充"占位）。

### 改动 2：在 `## APIs` 末尾追加 `### 11.~19.` 共 9 个新章节

**文件**：`e:\前端大学习\javascript\javascript.md`

**插入点**：在最后一个 `### 10. 回调函数` 之后的"待补充"提示行（javascript.md L2911 附近）**之后**追加。

**统一风格**（与之前 0~10 章完全一致）：
- `### N. 章节中文名`，下方加 `> 章节涵盖：...` 引子
- `#### N.M 小节名`（保留原 PPT 编号如 `1.1`、`2.2`）
- 文字要点 → 无序列表
- 代码示例 → ` ```js ` 代码块（保留 PPT 中代码块原文）
- 对比/分类 → 表格
- 流程/关系/树 → Mermaid `flowchart LR`，**节点文本中含 `<br/>` / `=` / `delete` 等特殊字符时必须用双引号包裹**（修复上一轮 spec 中的 parse error）
- 设计型图示（PPT 装饰、京东秒杀 UI、思考图标）→ 1~2 句文字描述

**9 个新章节内容规划**：

#### 11. 事件流
- 11.1 事件流和两个阶段说明（Document → html → body → div 捕获 / div → body → html → Document 冒泡 + Mermaid `flowchart LR` 双向）
- 11.2 事件捕获（语法 `addEventListener(type, fn, useCapture)` + 说明）
- 11.3 事件冒泡（默认行为 + 3 层父子示例代码）
- 11.4 阻止冒泡（`事件对象.stopPropagation()` + `e.preventDefault()` 阻止默认行为）
- 11.5 解绑事件（L0 `btn.onclick = null` / L2 `removeEventListener`，匿名函数无法解绑）
- 11.6 两种注册事件的区别（L0 vs L2 对比表格）
- 11.7 本章总结

#### 12. 事件委托
- 12.1 思考（for 循环注册 vs 一次注册）
- 12.2 事件委托的好处/原理/实现（target.tagName 区分 + Mermaid 父子关系图）
- 12.3 本章总结（减少注册次数 + 父元素接收 + tagName 定位）

#### 13. 其它事件
- 13.1 页面加载事件（`load` 给 window/img + `DOMContentLoaded` 给 document，对比表格）
- 13.2 元素滚动事件（`scroll` + 案例：固定导航栏/返回顶部）
- 13.3 页面尺寸事件（`resize` + `window.innerWidth/Height`）
- 13.4 本章总结（2 个加载事件 + 滚动 + 尺寸）

#### 14. 日期对象
- 14.1 什么是日期对象（京东秒杀倒计时案例 + 学习路径 1.实例化 2.方法 3.时间戳）
- 14.2 实例化（`new Date()` 当前 / `new Date('2008-8-8')` 指定 / 数字参数）
- 14.3 日期对象方法（getXxx 7 个方法 + toLocaleString 三种格式对比表）
- 14.4 时间戳（1970-01-01 起算的毫秒数 + `+new Date()` / `Date.now()` / `valueOf()` + 倒计时算法）
- 14.5 本章总结

#### 15. 节点操作
- 15.1 DOM 节点（元素节点/属性节点/文本节点 + DOM 树 Mermaid）
- 15.2 查找节点（父 `parentNode` / 子 `childNodes` vs `children` 重点 / 兄弟 `nextElementSibling` / `previousElementSibling`）
- 15.3 增加节点（`document.createElement` + `parent.appendChild` / `insertBefore`）
- 15.4 删除节点（`parent.removeChild(child)`）
- 15.5 本章总结

#### 16. M 端事件
- 16.1 触屏事件（touchstart/touchmove/touchend 对比表）
- 16.2 本章总结（移动端事件与 PC 端区别，提示性能问题）

#### 17. JS 插件
- 17.1 什么是插件（别人写好的代码，复制即可使用 + swiper 案例）
- 17.2 学习插件的基本过程（5 步：官网/演示/使用流程/API/类名区分）
- 17.3 本地文件结构（package/css/js 三个目录）

#### 18. windows 对象
- 18.1 BOM（Browser Object Model + window 是顶级对象 Mermaid）
- 18.2 定时器-延时函数（`setTimeout(回调, 毫秒)` / `clearTimeout(timer)`）
- 18.3 JS 执行机制（单线程 → 同步 vs 异步 → 任务执行顺序代码示例）
- 18.4 location 对象（href/search/hash/assign/reload/replace）
- 18.5 navigator 对象（userAgent）
- 18.6 history 对象（back/forward/go）
- 18.7 本章总结

#### 19. 本地存储
- 19.1 本地存储介绍（数据存在用户浏览器，约 5M，刷新不丢失）
- 19.2 本地存储分类（localStorage 永久 / sessionStorage 会话对比表 + API `setItem/getItem/removeItem`）
- 19.3 存储复杂数据类型（`JSON.stringify` 存 / `JSON.parse` 取）
- 19.4 本章总结（两种存储对比 + JSON 转换）

## Assumptions & Decisions

1. **跳过异常文件**：`14.日期对象\0..png`（双点）属于系统截图误生成，跳过该文件，从 `1.png` 开始。
2. **保留短章节**：`16.M端事件`（1 张）和 `17.JS插件`（2 张）虽然内容很少，仍独立成节以保持目录结构完整。
3. **课程导览表更新策略**：仅追加第 3 天明确的 4 个章节（事件流/委托/其他事件/元素尺寸与位置/综合案例），其余以"待补充"占位以保持表格稳定。
4. **Mermaid 节点文本引号规则**：节点文本中含 `<br/>` / `=` / `delete` 等特殊字符时必须用双引号包裹整段文本（沿用 `fix-mermaid-array-diagram` spec 的规则）。
5. **风格一致性**：与 0~10 章完全相同的 `### N.` / `#### N.M` 编号系统、相同 Markdown 元素使用方式、相同 Mermaid `flowchart LR` 习惯。
6. **不内嵌 PNG 路径**：与之前一致，只整理文字+图表化的知识。
7. **可扩展性**：本次只整理 11~19，未来新增章节（如 20.正则表达式）只需继续追加 `### 20. 章节名`，**不修改**已有内容。

## Implementation Steps

### Step 1：读取剩余图片（覆盖验证 + 补全大纲）

- 11.事件流 已读 0-7 全部 → 不再读
- 12.事件委托 已读 0-4 全部 → 不再读
- 13.其它事件 已读 0-4，需补读 **5-16.png**（12 张）
- 14.日期对象 已读 0..png (跳), 1-5，需补读 **6-7.png**（2 张）
- 15.节点操作 已读 0-5，需补读 **6-12.png**（7 张）
- 18.windows对象 已读 0-4，需补读 **5-14.png**（10 张）
- 19.本地存储 已读 0-4，需补读 **5-12.png**（8 张）
- 16.M端事件 仅 1.png，已读完
- 17.JS插件 1-2.png，已读完
- api课程安排 7-9.png，已读完

> 主 agent 直接读取剩余 **39 张**图片，每读完一张立即汇总到内部（不进 context），按"11~19 大章节"切分批写入 `javascript.md`。

### Step 2：更新 `### 课程导览` 表格

- 找到 L2094 附近的"7 天课程安排"表格
- 追加第 3 天行（事件流/事件委托/其他事件/元素尺寸与位置/综合案例）
- 其余 4~7 天以"待补充"占位

### Step 3：按"批次"写入 9 个新章节

- 批次 A（事件进阶）：`### 11. 事件流` + `### 12. 事件委托` + `### 13. 其它事件`
- 批次 B（DOM 进阶）：`### 14. 日期对象` + `### 15. 节点操作`
- 批次 C（移动/扩展）：`### 16. M 端事件` + `### 17. JS 插件`
- 批次 D（BOM/存储）：`### 18. windows 对象` + `### 19. 本地存储`

每批写入后立即在 `### N. 章节名` 末空一行分隔。

### Step 4：本地校验

- 全文 `Select-String` 统计 `### N\.` 数量（应为 19 个 0~19）
- 全文 `Select-String` 统计 `#### N\.M` 数量（每章子节数应为 3~7）
- 全文 `Select-String` 统计 Mermaid 块数量（每个流程/关系图对应一个）
- 再次 `Read` L2091~L3000 检查无格式错乱

## Verification

1. **完整性**：`## APIs` 之下出现 20 个 `###`（课程导览 + 0~19 共 20 个二级标题），其中本次新增 9 个。
2. **无渲染错误**：所有 Mermaid 块节点文本均用双引号包裹（含 `<br/>` / `=` / `delete` 等特殊字符时），不会再触发上一轮的 parse error。
3. **风格一致**：与 0~10 章（事件监听/事件类型/事件对象/环境对象/回调函数）保持相同的三级标题 + 引子 + 表格 + 代码块 + Mermaid 风格。
4. **课程导览更新**：表格中"Web APIs 第三天"行存在，主题为"Dom 事件进阶"。
5. **异常处理**：`14.日期对象\0..png` 已跳过，未引发错误。
