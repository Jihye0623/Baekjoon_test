def solution(n):
    answer = 0
    
    k = n-1
    res = []
    
    for i in range(1, int(k**(1/2)) + 1):
        if (k%i==0):
            res.append(i)
            
            # 제곱근이 아니라면(중복 숫자)
            if ((i**2)!=k):
                res.append(k//i)
                
    res.sort()
    del res[0]
    answer = min(res)
    
    return answer