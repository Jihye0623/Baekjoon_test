import sys
sys.setrecursionlimit(10**6) 
INF = -987654321

def sum(n, in_arr, d):
    if n == 1:
        return in_arr[1]
    if d[n] != INF:
        return d[n]
    d[n] = max(sum(n - 1, in_arr, d) + in_arr[n], in_arr[n])
    return d[n]


n = int(input())
in_arr = [0] * (n + 1) 
d = [INF] * (n + 1)     

in_arr[1:] = list(map(int, input().split()))  

d[1] = in_arr[1]  
sum(n, in_arr, d)

res = INF
for i in range(1, n + 1):
    res = max(res, d[i])  
    
print(res)
