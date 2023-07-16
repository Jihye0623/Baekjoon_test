def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    
    for i in range(len(citations)):
        cnt=i
        if cnt>=citations[i]:
            return i
    
    return len(citations)