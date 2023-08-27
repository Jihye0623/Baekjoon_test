def solution(brown, yellow):
    answer = []
    
    total = brown + yellow      
    
    for x in range(1,total+1):
        if total % x == 0:
            y = total / x
            if x >= y:             
                if yellow == (x-2) * (y-2):
                    answer.append(x)
                    answer.append(y)
                    break
                    
    return answer