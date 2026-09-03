# C++常用头文件

> 本节按头文件分组整理算法竞赛常用 API：`cmath` 负责数学函数，`algorithm` 负责通用算法（排序、查找、堆），`numeric` 负责数值算法（累加、GCD、扫描）。三者搭配 STL 容器，覆盖刷题 90% 的场景。

## cmath

> `<cmath>` 是 C 标准数学库的 C++ 包装，所有函数都在 `std` 命名空间下，**参数和返回值**多为 `double`。刷题时最常用的是**取整、幂运算、浮点处理**三类。

### 常用函数速览

| 函数 | 功能 | 备注 |
| --- | --- | --- |
| `abs(x)` | 整数绝对值 | 实际定义在 `<cstdlib>`，C++11 起 `<cmath>` 也支持 |
| `fabs(x)` | 浮点绝对值 | 等价于 `abs(double)` |
| `sqrt(x)` | 平方根 | 比 `pow(x, 0.5)` 更快、更准 |
| `cbrt(x)` | 立方根 | C++11 起 |
| `pow(x, y)` | `x^y` | 整数次方**不要**用它，会引入浮点误差 |
| `exp(x)` | `e^x` | |
| `log(x)` | 自然对数 | 底为 `e` |
| `log10(x)` | 常用对数 | 底为 10 |
| `log2(x)` | 底为 2 的对数 | C++11 起 |
| `hypot(x, y)` | `sqrt(x² + y²)` | **防数值溢出**专用，见下 |
| `max(a, b)` / `min(a, b)` | 两值最大/最小 | 也可处理 `initializer_list`（C++11） |
| `fmax(a, b)` / `fmin(a, b)` | 浮点版 max/min | 处理 NaN 行为不同 |

### 三角函数

| 函数 | 功能 |
| --- | --- |
| `sin` / `cos` / `tan` | 正弦 / 余弦 / 正切（弧度） |
| `asin` / `acos` / `atan` | 反正弦 / 反余弦 / 反正切 |
| `sinh` / `cosh` / `tanh` | 双曲正弦 / 余弦 / 正切 |
| `atan2(y, x)` | 二参数反正切，**能区分象限**（比 `atan(y/x)` 安全） |

**常用常量**：

| 常量 | 值 |
| --- | --- |
| `M_PI` | 圆周率 π |
| `M_E` | 自然常数 e |
| `M_SQRT2` | √2 |

> <span style="color:orange">注意</span>：`M_PI` 不是 C++ 标准的一部分，GCC/Clang 默认开启，MSVC 需定义 `_USE_MATH_DEFINES` 后 include `<cmath>`。严谨做法是**自己定义**：`const double PI = acos(-1.0);`

### 取整函数

| 函数 | 功能 | 示例（`x = 2.7`） | 示例（`x = -2.7`） |
| --- | --- | --- | --- |
| `ceil(x)` | 向上取整 | `3` | `-2` |
| `floor(x)` | 向下取整 | `2` | `-3` |
| `round(x)` | 四舍五入（远离 0） | `3` | `-3` |
| `trunc(x)` | 截断小数部分 | `2` | `-2` |
| `fmod(x, y)` | 浮点取模（结果符号同 `x`） | — | — |

```c++
#include <cmath>
#include <iostream>
using namespace std;

int main() {
    cout << ceil(2.7) << " " << floor(2.7) << " " << round(2.7) << endl;       // 3 2 3
    cout << ceil(-2.7) << " " << floor(-2.7) << " " << round(-2.7) << endl;     // -2 -3 -3
    return 0;
}
```

> <span style="color:red">⚠ 警告</span>：**负数取整的方向常与直觉相反**，`floor(-2.7) = -3`（向更小的整数），刷题务必测试。

### 幂运算与整数次方

> <span style="color:red">⚠ 警告</span>：`pow(2, 10)` 看似能算 `2^10`，但**内部用浮点实现**，结果可能因精度损失而不准（如 `pow(10, 2) = 99.9999...`）。**整数次方**用快速幂（手写）或 `1LL << n`（仅限 2 的幂）。

```c++
// 整数快速幂：a^n mod mod（比赛最常用）
long long qpow(long long a, long long n, long long mod) {
    long long res = 1;
    a %= mod;
    while (n > 0) {
        if (n & 1) res = res * a % mod;
        a = a * a % mod;
        n >>= 1;
    }
    return res;
}
```

### 浮点处理技巧

**1. 浮点比较**：`==` 比较浮点几乎一定出错，必须用容差：

```c++
#include <cmath>
const double EPS = 1e-9;
bool eq(double a, double b) { return fabs(a - b) < EPS; }
bool lt(double a, double b) { return a < b - EPS; }
bool le(double a, double b) { return a < b + EPS; }
```

**2. 防止 `sqrt(x² + y²)` 溢出**：

```c++
// 错误：x、y 很大时 x*x 先溢出
double len = sqrt(x * x + y * y);

// 正确：hypot 内部做缩放
double len = hypot(x, y);
```

**3. INF / NaN**：

```c++
double inf = numeric_limits<double>::infinity();
double nan = numeric_limits<double>::quiet_NaN();
```

### 关键注意点

| 易错点 | 说明 |
| --- | --- |
| <span style="color:red">整数次方用 `pow`</span> | 浮点精度坑，改用快速幂 |
| 三角函数单位是**弧度** | 转角度：`rad * PI / 180` |
| 负数 `floor` / `ceil` | 方向与直觉相反 |
| `M_PI` | 非标准常量，MSVC 需宏定义 |
| 浮点 `==` | 必带 EPS 容差 |
| `sqrt(x*x + y*y)` | 大数时改用 `hypot(x, y)` |

## algorithm

> `<algorithm>` 是 STL **算法**层的核心头文件，提供排序、查找、变换、堆等通用算法。所有算法通过**迭代器**操作容器，与具体容器解耦。

### 取最值

| 函数 | 范围 | 返回值 |
| --- | --- | --- |
| `min(a, b)` / `max(a, b)` | 两个值 | 较小/较大的值 |
| `min({a, b, c})` / `max({...})` | 多个值（C++11 initializer_list） | 同上 |
| `min_element(begin, end)` | 区间 | **迭代器**，需 `*` 解引用 |
| `max_element(begin, end)` | 区间 | **迭代器**，需 `*` 解引用 |
| `minmax(a, b)` | 两个值 | `pair<较小值, 较大值>` |
| `minmax_element(begin, end)` | 区间 | `pair<最小迭代器, 最大迭代器>` |
| `clamp(v, lo, hi)` | 单值（C++17） | 钳制到 `[lo, hi]` |

```c++
#include <algorithm>
using namespace std;

vector<int> v = {3, 1, 4, 1, 5, 9, 2, 6};

// 容器里的最大值（迭代器要 * 解引用）
auto it = max_element(v.begin(), v.end());
cout << *it;            // 9
cout << it - v.begin(); // 4（下标）

// 三个数
cout << max({1, 5, 3}); // 5

// 钳制
cout << clamp(15, 0, 10); // 10
```

### 排序

| 函数 | 特点 |
| --- | --- |
| `sort(begin, end)` | 快速排序（实际 introsort），O(n log n)，**不稳定** |
| `stable_sort(begin, end)` | 稳定排序，相等元素保持原顺序 |
| `partial_sort(begin, mid, end)` | 排序到 `mid`，**取前 k 小** O(n log k) |
| `nth_element(begin, nth, end)` | 第 `nth` 位置就位（**前 k 小**，不保证其余顺序） |
| `is_sorted(begin, end)` | 是否已排序（O(n)） |

```c++
vector<int> v = {3, 1, 4, 1, 5};
sort(v.begin(), v.end());                      // 1 1 3 4 5
partial_sort(v.begin(), v.begin() + 2, v.end());// 前 2 小排到头部
```

> <span style="color:orange">注意</span>：`sort` 的 `cmp(x, y)` 返回 `true` 表示 `x` 排前；**必须用严格 `>` / `<`**，不能 `>=` / `<=`。

### 查找

| 函数 | 前提 | 返回值 |
| --- | --- | --- |
| `find(begin, end, val)` | 无 | 第一个等于 `val` 的迭代器 |
| `find_if(begin, end, pred)` | 无 | 第一个满足 `pred` 的迭代器 |
| `count(begin, end, val)` | 无 | 等于 `val` 的元素**个数** |
| `count_if(begin, end, pred)` | 无 | 满足 `pred` 的元素**个数** |
| `binary_search(begin, end, val)` | **已排序** | `bool`：是否存在 |
| `lower_bound(begin, end, val)` | **已排序** | 第一个 `>= val` 的迭代器 |
| `upper_bound(begin, end, val)` | **已排序** | 第一个 `> val` 的迭代器 |
| `equal_range(begin, end, val)` | **已排序** | `[lower, upper)` 的 `pair` |

```c++
vector<int> v = {1, 2, 2, 3, 4};
auto lo = lower_bound(v.begin(), v.end(), 2); // 指向第一个 2
auto hi = upper_bound(v.begin(), v.end(), 2); // 指向 3
cout << hi - lo; // 2（2 出现了 2 次）
```

### 修改 / 变换

| 函数 | 功能 |
| --- | --- |
| `reverse(begin, end)` | 翻转 |
| `rotate(begin, mid, end)` | 旋转（`mid` 移到开头） |
| `shuffle(begin, end, rng)` | 随机打乱（C++11，需 `<random>` 引擎） |
| `next_permutation(begin, end)` | 下一个排列，到末尾返回 `false` |
| `prev_permutation(begin, end)` | 上一个排列 |
| `fill(begin, end, val)` | 填充 |
| `replace(begin, end, old, new)` | 替换 |
| `unique(begin, end)` | **相邻**去重（需先 `sort`） |
| `swap(a, b)` / `iter_swap(it1, it2)` | 交换 |

> <span style="color:orange">注意</span>：`unique` 只删**相邻**重复，所以通常先 `sort` 再 `unique`。返回值是新结尾迭代器：`v.erase(it, v.end())`。

```c++
vector<int> v = {1, 2, 2, 3, 2, 4};
sort(v.begin(), v.end());
v.erase(unique(v.begin(), v.end()), v.end()); // 1 2 3 4
```

### 集合算法（已排序区间）

> 输入区间必须**有序**，结果区间可与输入重叠。

| 函数 | 含义 |
| --- | --- |
| `merge(a, b, out)` | 归并两个有序区间到 `out` |
| `set_union(a, b, out)` | 并集 |
| `set_intersection(a, b, out)` | 交集 |
| `set_difference(a, b, out)` | 差集（在 a 不在 b） |
| `set_symmetric_difference(a, b, out)` | 对称差 |
| `includes(a, b)` | b 是否是 a 的子集 |

### 堆（priority_queue 替代品）

> `priority_queue` 内部用堆，但只暴露受限接口。如需**在任意位置**操作堆，用 algorithm 提供的 4 个函数。

| 函数 | 功能 |
| --- | --- |
| `make_heap(begin, end)` | 把区间建成**大根堆**（默认 `less`，最大元素在 `begin`） |
| `push_heap(begin, end)` | 假设 `end-1` 是新元素，**上浮**调整 |
| `pop_heap(begin, end)` | 把堆顶移到 `end-1`，**下沉**调整 |
| `sort_heap(begin, end)` | 堆排序（区间先 make_heap） |
| `is_heap(begin, end)` | 是否是堆 |

```c++
vector<int> v = {3, 1, 4, 1, 5, 9, 2, 6};
make_heap(v.begin(), v.end()); // 大根堆：9 在 v[0]
pop_heap(v.begin(), v.end()); // 9 移到末尾
cout << v.back();              // 9
v.pop_back();                  // 真正删除
```

> <span style="color:orange">注意</span>：默认是**大根堆**（`less`），想要小根堆传 `greater<int>{}`：`make_heap(v.begin(), v.end(), greater<int>());`

### 其他常用

| 函数 | 功能 |
| --- | --- |
| `for_each(begin, end, f)` | 对每个元素执行 `f`（C++17 起可返回） |
| `transform(a, b, out, f)` | 把 `f` 应用到元素，写到 `out` |
| `any_of` / `all_of` / `none_of` | 谓词判断（任一/全部/无） |
| `equal(a, b)` / `equal(a, b, pred)` | 两区间是否相等 |
| `lexicographical_compare` | 字典序比较 |
| `partition` / `stable_partition` | 按谓词分两段 |

## numeric

> `<numeric>` 提供**针对数值**的算法：累加、内积、扫描、序列生成、最大公约数等。`accumulate` 是刷题出现频率最高的之一。

### 累加 / 归约

| 函数 | 功能 |
| --- | --- |
| `accumulate(begin, end, init)` | 累加 + 初始值（可自定义二元运算） |
| `accumulate(begin, end, init, op)` | 自定义运算（如 `multiplies` 求积） |
| `reduce(begin, end, init)` | 类似但**无序**（C++17，并行友好） |
| `inner_product(a, b, init)` | 两区间内积 + 初始值 |
| `transform_reduce` | `transform` + `reduce` 组合（C++17） |

```c++
#include <numeric>
vector<int> v = {1, 2, 3, 4, 5};

int sum = accumulate(v.begin(), v.end(), 0);          // 15
int prod = accumulate(v.begin(), v.end(), 1, multiplies<int>()); // 120
// 字符串拼接（init 给空串）
string s = accumulate(v.begin(), v.end(), string(""),
                      [](string a, int x) { return a + to_string(x); });
// "12345"
```

> <span style="color:orange">注意</span>：`accumulate` 的初始值是**累加的起点**（不是数组里的元素），整数累加请写 `0LL` 避免溢出。

### 扫描（部分和 / 相邻差）

| 函数 | 功能 |
| --- | --- |
| `partial_sum(begin, end, out)` | 前缀和（含当前项） |
| `inclusive_scan` | C++17，等价 `partial_sum` |
| `exclusive_scan(begin, end, out, init)` | 前缀和（**不含**当前项，从 `init` 开始） |
| `adjacent_difference(begin, end, out)` | 相邻元素差（首元素不变） |

```c++
vector<int> v = {1, 2, 3, 4, 5};
vector<int> pre(5), diff(5);
partial_sum(v.begin(), v.end(), pre.begin());        // 1 3 6 10 15
adjacent_difference(v.begin(), v.end(), diff.begin());// 1 1 1 1 1
```

### 序列生成

| 函数 | 功能 |
| --- | --- |
| `iota(begin, end, val)` | 从 `val` 开始递增填充：`v[i] = val + i` |

```c++
vector<int> v(5);
iota(v.begin(), v.end(), 10); // 10 11 12 13 14
```

### GCD / LCM（C++17）

| 函数 | 功能 |
| --- | --- |
| `gcd(a, b)` | 最大公约数（C++17） |
| `lcm(a, b)` | 最小公倍数（C++17） |
| `midpoint(a, b)` | 两数中点（避免 `(a+b)/2` 溢出，C++20） |

```c++
cout << gcd(12, 18); // 6
cout << lcm(4, 6);   // 12

// 安全的 a+b/2
long long mid = midpoint(1LL, 1e18);
```

> <span style="color:orange">注意</span>：C++17 之前的 `__gcd` 是 GCC 扩展；严谨代码**自己写欧几里得**：
> ```c++
> long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
> ```

### 随机数（`<random>` 配合使用）

> `<random>` 虽不在 `<numeric>` 里，但常一起用。**告别 `rand()`**——`rand()` 范围小、质量差、且依赖实现。

```c++
#include <random>
#include <ctime>
mt19937 rng(time(nullptr));                        // 32 位引擎
mt19937_64 rng64(chrono::steady_clock::now().time_since_epoch().count()); // 64 位

// 范围 [lo, hi] 均匀整数
uniform_int_distribution<int> dist(1, 100);
int x = dist(rng);

// 范围 [0, 1) 均匀浮点
uniform_real_distribution<double> fdist(0.0, 1.0);
double y = fdist(rng);

// 容器洗牌
shuffle(v.begin(), v.end(), rng);
```

| 引擎 | 位数 | 用途 |
| --- | --- | --- |
| `mt19937` | 32 | 通用、够用 |
| `mt19937_64` | 64 | 大范围 ID、需要 64 位 |
| `default_random_engine` | 视实现 | 不推荐（质量参差） |

### 关键注意点

| 易错点 | 说明 |
| --- | --- |
| <span style="color:red">`accumulate` 初始值用 `0`</span> | 大数累加用 `0LL` 防溢出 |
| `partial_sum` 含当前项 | 想要"前 i-1 项和"用 `exclusive_scan` |
| `iota` 不检查越界 | 区间要先 `resize` |
| `gcd` / `lcm` | C++17 起，旧编译器用 `__gcd` 或手写 |
| `rand()` | 范围小、质量差，统一换 `mt19937` |
| `shuffle` 需要引擎 | 传 `mt19937`，不能传 `time(nullptr)` |

## iomanip

> `<iomanip>` 提供**格式化输出**的"操控器"（manipulator），用来控制 `cout` 的宽度、精度、对齐、进制等。**默认状态不会持久化**——除了 `fixed` / `scientific` / `boolalpha` 等"标志型"，像 `setw` 这种只对**下一次输出**生效。

### 精度与浮点格式

| 操控器 | 作用 | 备注 |
| --- | --- | --- |
| `setprecision(n)` | 设置精度（**有效数字位数**） | 默认模式 |
| `setprecision(n)` + `fixed` | 设置**小数位数** | 刷题**最常考** |
| `setprecision(n)` + `scientific` | 设置科学计数法的小数位数 | |
| `defaultfloat` | 还原默认（C++11） | 退出 `fixed` 模式 |
| `showpoint` / `noshowpoint` | 强制 / 不强制显示小数点 | |

```c++
#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    double pi = 3.14159265358979;

    cout << setprecision(4) << pi << endl;         // 3.142（4 位有效数字）
    cout << fixed << setprecision(2) << pi << endl; // 3.14（保留 2 位小数）
    cout << defaultfloat << setprecision(6) << pi; // 3.14159

    // 默认 cout 输出 1.0 会显示 1，showpoint 强制显示 1.00000
    cout << fixed << setprecision(2);
    cout << 1.0 << endl; // 1.00
    return 0;
}
```

> <span style="color:orange">注意</span>：`fixed` / `scientific` 是**持久的**，影响后续所有浮点输出；用完想还原要 `cout << defaultfloat;`（C++11）。

### 宽度与填充

| 操控器 | 作用 | 备注 |
| --- | --- | --- |
| `setw(n)` | 设置下一次输出的**最小宽度** | **只生效一次** |
| `setfill(c)` | 设置填充字符（默认空格） | 持久 |
| `left` / `right` | 左对齐 / 右对齐（默认 right） | 持久 |
| `internal` | 符号左对齐、数值右对齐（如 `- 123`） | 持久 |

```c++
#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    // 题目要求：输出 4 位整数，不足补 0（如 1 → 0001）
    cout << setfill('0');
    for (int i = 1; i <= 5; i++) {
        cout << setw(4) << i << endl;
    }
    // 0001
    // 0002
    // 0003
    // 0004
    // 0005

    // 对齐：左对齐 + 宽度 10，填充 *
    cout << setfill('*') << left << setw(10) << "hi" << "end" << endl;
    // hi********end
    return 0;
}
```

> <span style="color:red">⚠ 警告</span>：`setw` **只对下一次输出生效**！多个字段都要设宽度时，必须**每次都写** `setw`。

### 进制与布尔

| 操控器 | 作用 |
| --- | --- |
| `hex` / `dec` / `oct` | 十六进制 / 十进制 / 八进制（持久） |
| `setbase(n)` | 进制（只接受 8/10/16，其余按 10 处理） |
| `showbase` / `noshowbase` | 显示 / 不显示进制前缀（`0x` / `0`） |
| `uppercase` / `nouppercase` | 十六进制字母大写 / 小写 |
| `boolalpha` / `noboolalpha` | bool 输出 `true` / `false` 还是 `1` / `0` |

```c++
cout << hex << 255;              // ff
cout << showbase << hex << 255;  // 0xff
cout << uppercase << hex << 255; // 0XFF

bool flag = true;
cout << flag;                    // 1
cout << boolalpha << flag;       // true
```

### 输入侧操控器

| 操控器 | 作用 |
| --- | --- |
| `ws` | 跳过前导空白字符（常用于 `getline` 前清空残留换行） |
| `get_money(m)` / `put_money(m)` | 货币格式（C++11，少用） |
| `get_time(t, fmt)` / `put_time(t, fmt)` | 时间格式（C++11，少用） |

```c++
int n;
string s;
cin >> n;
// >> 之后缓冲区留有 '\n'，getline 会读空串
cin.ignore(numeric_limits<streamsize>::max(), '\n');
getline(cin, s);
```

> <span style="color:orange">注意</span>：刷题**最常见的坑**是 `cin >> n` 后接 `getline(cin, s)` 读到空串，必须 `cin.ignore` 清除残留换行。

### 关键注意点

| 易错点 | 说明 |
| --- | --- |
| <span style="color:red">`setw` 只生效一次</span> | 多个字段必须**每次都写** |
| `setprecision` 默认是**有效数字** | 想保留 n 位小数要加 `fixed` |
| `fixed` 持久生效 | 用完记得 `defaultfloat` 还原 |
| `cout << bool` 输出 `0/1` | 想看 `true/false` 需 `boolalpha` |
| `hex` 也持久 | 想回十进制要 `dec` |
| `cin >> n` + `getline` | 记得 `cin.ignore()` 清残留换行 |

# <climits>
## 极限宏

| 宏名称       | 对应类型             | 值（十进制）                                                 | 用途                      |
| ------------ | -------------------- | ------------------------------------------------------------ | ------------------------- |
| `INT_MAX`    | `int`                | 2,147,483,647                                                | int 最大值                |
| `INT_MIN`    | `int`                | -2,147,483,648                                               | int 最小值                |
| `LLONG_MAX`  | `long long`          | 9,223,372,036,854,775,807                                    | long long 最大值          |
| `LLONG_MIN`  | `long long`          | -9,223,372,036,854,775,808                                   | long long 最小值          |
| `ULLONG_MAX` | `unsigned long long` | 18,446,744,073,709,551,615                                   | unsigned long long 最大值 |
| `LONG_MAX`   | `long`               | Windows: 2,147,483,647<br>Linux: 9,223,372,036,854,775,807   | 长度随平台，刷题不推荐    |
| `LONG_MIN`   | `long`               | Windows: -2,147,483,648<br>Linux: -9,223,372,036,854,775,808 | 同上                      |

---

## 整型字面量后缀（无需头文件）

| 后缀   | 类型                 | 示例     | 用途                 |
| ------ | -------------------- | -------- | -------------------- |
| 无后缀 | `int`                | `123`    | 默认整型             |
| `L`    | `long`               | `123L`   | 不推荐（平台相关）   |
| `LL`   | `long long`          | `123LL`  | **明确 64 位有符号** |
| `ULL`  | `unsigned long long` | `123ULL` | **明确 64 位无符号** |
| `u`    | `unsigned int`       | `123u`   | 无符号 int           |
| `f`    | `float`              | `3.14f`  | 单精度浮点           |

> ⚠️ **刷题最常用**：`1LL * a * b` 防止乘法溢出。