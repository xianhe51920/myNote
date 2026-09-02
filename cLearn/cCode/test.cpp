#include <bits/stdc++.h>
using namespace std;
#define MOD 1e9+7

int main() {
    int n,m;
    cin >> n >> m;
    vector<vector<long>> a(n+1,{0});
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=m;j++){
            if(i==1 && j==1){
                a[i].push_back(1);
            }
            else if (2<=i && j == 1) {
                a[i].push_back(a[i-1][j]);
            }
            else if (2<=j && i == 1) {
                a[i].push_back(a[i][j-1]);
            }
            else{
                a[i].push_back(a[i-1][j] + a[i][j-1]);
            }
        }
    }
    
    cout << (a[n][m] % MOD) << endl;
}
// 64 位输出请用 printf("%lld")