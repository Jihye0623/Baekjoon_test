def solution(name, yearning, photo):
    answer = []
    
    for ph in photo:
        res = 0
        for p in ph:
            if p in name:
                res+=yearning[name.index(p)]
        
        answer.append(res)
    
    return answer