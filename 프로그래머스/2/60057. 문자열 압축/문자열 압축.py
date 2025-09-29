def solution(s):
    answer = len(s)
    
    for i in range(1, len(s)//2+1):
        string = ''
        cnt = 1
        for j in range(0, len(s), i):
            if s[j:j+i] == s[j+i:j+i+i]:
                cnt += 1
            else:
                if cnt>1:
                    string+=(str(cnt)+s[j:j+i])
                else:
                    string+=s[j:j+i]
                cnt = 1
        if len(string)<answer:
            answer=len(string)
    return answer
