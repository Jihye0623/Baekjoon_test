def solution(brown, yellow):
    answer = []
    
    # total == a*b
    # brwon == 2a * 2b -4
    # yellow == (a-2) * (b-2)
    
    total = brown + yellow      
    
    for b in range(1,total+1):
        if total % b == 0:
            a = total / b
            if a >= b:                     
                if 2*a + 2*b == brown + 4:  
                    return [a,b]
            
    
    
        
    return answer