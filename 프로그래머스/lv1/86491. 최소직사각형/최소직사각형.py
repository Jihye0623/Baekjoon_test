def solution(sizes):
    answer = 0
    
    for s in sizes:
        if s[0]>s[1]:
            temp=s[0]
            s[0]=s[1]
            s[1]=temp
            
    maxW=sorted(sizes, key = lambda x: x[0], reverse=True)
    maxH=sorted(sizes, key = lambda x: x[1], reverse=True)
    
    answer=maxW[0][0]*maxH[0][1]

    return answer