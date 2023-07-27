def solution(name):

    answer = 0
    
    # 기본적인 최소 움직임
    min_move = len(name) - 1
    
    
    for i, char in enumerate(name):
        # A부터 오름차순으로 찾는 것이 빠른지, 아니면 Z부터 내림차순으로 찾는 것이 빠른지 비교
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
        
        # 연속된 A 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
            
        min_move = min([min_move, 2 *i + len(name) - next, i + 2 * (len(name) -next)])
        
    answer += min_move
    return answer