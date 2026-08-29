#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
    vector <int> m(10);
    for (int i = 0;i<m.size();i++) {
        m[i] = i;
    }

    m.push_back(-1);
    // 排序
    sort(m.begin(),m.end());

    for (int i = 0;i<m.size();i++)
        cout << m[i] << " "; // -1 0 1 2 3 4 5 6 7 8 9
    return 0;
}