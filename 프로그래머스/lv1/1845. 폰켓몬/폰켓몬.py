def solution(nums):
    n=len(nums)
    cnt=n//2
    
    li=list(set(nums))
    n_uni=len(li)
    
    if n_uni>=cnt:
        return cnt
    else:
        return n_uni