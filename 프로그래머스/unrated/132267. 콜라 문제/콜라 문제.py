def solution(a, b, n):
    answer = 0
    
    mine = n
    
    while mine>=a:
        m = mine//a
        n = m*b
        mine = mine - m*a + n
        answer+=n
    
        
    return answer