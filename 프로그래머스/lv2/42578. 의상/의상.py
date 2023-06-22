def solution(clothes):
    answer = 0
    
    dic={}
    
    for i in clothes:
        if i[1] in dic:   
            dic[i[1]]+=1
        else:
            dic[i[1]]=1
    
    if len(dic)==1:
        answer=dic[clothes[0][1]]
    else:
        answer=1
        for k in dic.keys():
            answer=answer*(dic[k]+1)
        answer-=1
    
        
    return answer