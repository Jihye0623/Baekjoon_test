def solution(t, p):
    answer = 0
    
    nums=[]
    
    for i in range(len(t)):
        if i+len(p)<=len(t):
            nums.append(t[i:i+len(p)])
        
    for n in nums:
        if n<=p:
            answer+=1
            
    return answer