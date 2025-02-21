INF = 1234567890

def solve(i, d):
    if i < 0:
        return INF
    if d[i] != 0:
        return d[i]
    d[i] = min(solve(i - 3, d), solve(i - 5, d)) + 1
    return d[i]

n = int(input())
d = [0] * (5001)
d[3] = 1
d[5] = 1

# 계산을 시작하기 전에 d[i] 값들이 초기화되지 않은 상태에서 시작되는지 체크
for i in range(6, n + 1):
    if d[i] == 0:
        result = solve(i, d)

result = solve(n, d)
if result >= INF:
    print(-1)
else:
    print(result)
