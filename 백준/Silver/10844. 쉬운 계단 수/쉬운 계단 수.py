N = int(input())

dp = [[0]*(N+1) for i in range(10)]
def stair(now, l):
    if now<0 or now>9: return 0
    if l<=1 : return 1
    if dp[now][l] : return dp[now][l]
    dp[now][l] = stair(now-1,l-1)+stair(now+1, l-1)
    return dp[now][l]

total = 0
for i in range(1, 10):
    total += stair(i, N)
print(total%1000000000)