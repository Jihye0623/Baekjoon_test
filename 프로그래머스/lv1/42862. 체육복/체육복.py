def solution(n, lost, reserve):   
    answer=n-len(lost)
    
    lost.sort()
    reserve.sort()
    
    for i in lost:
        if i in reserve:
            answer=answer+1
            reserve.remove(i)
            lost.remove(i)
            
    for i in lost:
        if i in reserve:
            answer=answer+1
            reserve.remove(i)
        elif (i-1) in reserve:
            answer=answer+1
            reserve.remove(i-1)
        elif (i+1) in reserve:
            answer=answer+1
            reserve.remove(i+1)
            
    return answer