# 修复 Mermaid 数组图渲染错误

## Why

`javascript.md` L1084-1090 的 Mermaid 流程图在 `Markdown Preview Mermaid Support` 插件中渲染失败，报错 `Parse error on line 2`。原因是节点文本中包含 `<br/>` HTML 标签但未用双引号包裹，解析器在 `B[查<br/>数组[下标]]` 处断词。

## What Changes

- 修改 [javascript.md](file:///e:/%E5%89%8D%E7%AB%AF%E5%A4%A7%E5%AD%A6%E4%B9%A0/javascript/javascript.md) L1086~1089 的 4 行 Mermaid 节点标签
- 为包含 `<br/>` / `=` / `/` 等特殊字符的节点文本统一加双引号包裹
- 同步检查全文其他 Mermaid 块是否有同类问题（避免后续出现类似错误）

## Impact

- Affected specs: Mermaid 渲染兼容性
- Affected code: `javascript.md` 第 8.3 节"操作数组"流程图

## ADDED Requirements

### Requirement: 修复数组操作 Mermaid 流程图

Mermaid 块 L1084-1090 必须能正常渲染，不抛 `Parse error` 错误。

#### Scenario: 包含 HTML 标签的节点文本
- **WHEN** 节点标签中包含 `<br/>` 等 HTML 标签
- **THEN** 必须用双引号 `"..."` 包裹整个标签文本

#### Scenario: 包含特殊符号的节点文本
- **WHEN** 节点标签中包含 `=`、`/`、`()` 等非字母数字字符
- **THEN** 必须用双引号 `"..."` 包裹整个标签文本

## MODIFIED Requirements

无

## REMOVED Requirements

无
