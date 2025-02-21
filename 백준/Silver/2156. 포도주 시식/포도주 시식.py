import sys
sys.setrecursionlimit(10**6) 

def logic(n):    
    if dp[n] is None:       
        dp[n] = max(max(logic(n-2), logic(n-3) + wine[n-2]) + wine[n-1], logic(n-1))     
    return dp[n] 

n = int(sys .stdin.readline())    
wine = [int(sys.stdin.readline()) for _ in range(n)]    
dp = [None for _ in range(n+1)]     

dp[0] = 0    
dp[1] = wine[0] 

if n > 1:
        dp[2] = wine[0] + wine[1]     
print(logic(n))
