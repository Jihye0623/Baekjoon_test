from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for perm in permutations(dungeons, len(dungeons)):
        count=0
        hp = k
        
        for p in perm:
            if hp<p[0]:
                break
            hp-=p[1]
            count+=1
        
        
        if answer<count:
            answer=count
        
    
    return answer