#include <bits/stdc++.h>
using namespace std;

void res(int n, int k) {
    if (k == n -1) {
        cout << -1;
        return;
    }
    for (int i = 1; i <= k; i++) {
        cout << i << " ";
    }
    if (k < n) {
        cout << n << " ";
        for (int i = k+1; i < n; i++) {
            cout << i << " ";
        }
    }
}
int main() {
    int n,k;
    cin >> n >> k;
    res(n,k);
    return 0;
}