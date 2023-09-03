def solution(number, k):
    answer = ''
    
#     nums=[]
#     result=[]
#     # 4177252841
    
#     for i in number:
#         nums.append(int(i))
        
#     h = len(nums)-k-1
    
#     while h!=-1:
#         p = len(nums)-h
        
#         x = nums.index(max(nums[:p]))
#         answer+=str(nums[x])
#         del nums[:x+1]
        
#         h-=1


    
    res = []
    
    for i in number:
        while res and res[-1]<i and k>0:
            res.pop()
            k-=1
        res.append(i)
        
    for i in res:
        answer+=i
        
    if k>0:
        answer=answer[:-k]
    
        

    return answer