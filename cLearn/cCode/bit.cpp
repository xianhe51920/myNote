#include <iostream>
#include <bitset>
using namespace std;

int main() {
    // 初始化
    bitset <5> b; // 5表示5个二进制位，初始化为0，00000
    bitset <5> c(3); // 十进制转二进制，输出b的结果为00011
    bitset <5> d("101"); // 填入字符串，长度不够，高位补0，输出d的结果为00101
    string s = "01010011";
    bitset <5> e(s, 1, 5); // 从字符串的索引1开始，取5个字符10100，高位补0，输出e的结果为10100
    bitset<6> f("10011", 1); // 从字符串的索引0开始，取1个字符，高位补零，输出f的结果为000001

    cout << b << endl; // 00000
    cout << c << endl; // 00011
    cout << d << endl; // 00101
    cout << e << endl; // 10100
    cout << f << endl; // 00011

    // 遍历
    for (int i = 0; i < d.size(); i++) {
        cout << d[i] << " ";
    }

    // 处理
    cout << "是否有1：" << d.any() << endl;
    cout << "是否不存在1：" << d.none() << endl;
    cout << "1的个数：" << d.count() << endl;
    cout << "d中元素个数：" << d.size() << endl;
    cout << "下标为i的元素是不是1：" << d.test(1) << endl;

    d.set(3); // 把下标为i处设置为1

    // 归零
    b.reset(); // 所有位归零
    d.reset(2); // 第i位归零

    // 取反
    d.flip(); // 所有位取反
    d.flip(2); // 第i位取反

    // 转换类型
    cout << "转换为unsigned long类型：" << d.to_ulong() << endl; //
    cout << "转换为string类型：" << d.to_string() << endl;

    return 0;
}