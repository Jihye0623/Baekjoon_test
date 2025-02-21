def fib(n, d):
    if n == 0:
        return 0
    if d[n] != 0:
        return d[n]
    d[n] = fib(n - 1, d) + fib(n - 2, d)
    return d[n]


n = int(input())
d = [0] * 46  # d 배열 크기 설정 (0부터 45까지)
d[1] = 1  # 초기 값 설정
print(fib(n, d))
