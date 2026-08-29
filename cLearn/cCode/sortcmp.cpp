#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(int x, int y) {
    return x > y;
}
int main() {
    vector <int> v;
    for (int i = 1;i<=10;i++) {
        v.push_back(11-i);
    }

    for (auto p=v.begin();p<v.end();p++)
        cout << *p << " ";

    cout << endl;

    // 排序
    sort(v.begin(),v.end(),cmp); // 原理：返回值为真，x放y前面，为假，x放y后面
    // 返回值部分必须使用>或者<,不能使用>=或者<=

    for (auto p=v.begin();p<v.end();p++)
        cout << *p << " ";
    return 0;
}