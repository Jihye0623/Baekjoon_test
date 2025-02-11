#include<iostream>
#include<vector>
using namespace std;
 
int N;
int num[100];
long long dp[100][21];
int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> num[i];
    }
    dp[0][num[0]] = 1;
    for (int i = 1; i < N - 1; i++)
    {
        for (int j = 0; j < 21; j++)
        {
            if (dp[i-1][j] > 0)
            {
                int add = j + num[i];
                int sub = j - num[i];
                if (add < 21)
                    dp[i][add] += dp[i - 1][j];
                if (sub >= 0)
                    dp[i][sub] += dp[i - 1][j];
            }
        }
    }
    cout << dp[N - 2][num[N - 1]];
    return 0;
}
