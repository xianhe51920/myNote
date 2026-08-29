#include <iostream>
#include <vector>
using namespace std;

int main() {
    int a[10] = {1,2,3,4,5,6,7,8,9,10};
    vector<int> v = {1, 2, 3, 4, 5};

    // 输出数组中的每一个元素的值，这里不能改变元素的数值
    for (int i : a) cout << i << " ";

    cout << endl;

    // 将数组中每一个元素都乘以2，只有在引用的时候才能改变元素的值
    for (int &i : a)
        i *= 2;

    // 所有的容器，配合auto，都可以使用这种方式来循环
    for (auto i:v) cout << i << " ";

    return 0;
}