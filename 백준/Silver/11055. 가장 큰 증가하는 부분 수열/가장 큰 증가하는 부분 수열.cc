#include<stdio.h>
int ar[1001];
int dp[1001];
int main()
{
int max, N;
scanf("%d", &N);
for (int i = 0; i < N; i++) {
scanf("%d", &ar[i]);
}
dp[0] = ar[0];
max = ar[0];
for (int i = 1; i < N; i++) {
int M = 0;
for (int j = 0; j < i; j++) {
if (ar[i] > ar[j] && dp[j] > M) {
M = dp[j];
}
}
dp[i] = M + ar[i];
if (max < dp[i]) {
max = dp[i];
}
}
printf("%d", max);
}