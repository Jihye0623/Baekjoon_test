#include <iostream>
#include <algorithm>
#define MAX 2001
using namespace std;
int weight[MAX][MAX], save[MAX][MAX], out[MAX][MAX];
int main() {
     int n, m;
     scanf("%d%d", &n, &m);
     for (int i = 1; i <= n; i++)
          for (int j = 1; j <= m; j++)
               scanf("%1d", &weight[i][j]);
     int ans = 0;
     for (int j = 1; j <= m; j++) {
          for (int i = 1; i <= n; i++) {
               int case1 = out[i - 1][j - 1];
               int case2 = out[i][j - 1];
               int case3 = out[i + 1][j - 1];
               save[i][j] = max(case1, max(case2, case3));
               out[i][j] = save[i][j] + weight[i][j];
               ans = max(ans, save[i][j]);
          }
     }
     cout << ans;
     return 0;
}
