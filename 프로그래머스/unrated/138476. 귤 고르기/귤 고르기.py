def solution(k, tangerine):
    answer = 0
    
    tangerine.sort()
    cnt = {}
    
    for i in tangerine:
        if i in cnt:
            cnt[i]+=1
        else:
            cnt[i]=1
            
    count = dict(sorted(cnt.items(), key=lambda x: x[1], reverse=True))

    for i in count:
        if k<=0:
            break
        
        k-=count[i]
        answer+=1
        
        
    return answer