def solution(answers):
    answer = []
    
    ans1=[1,2,3,4,5]
    ans2=[2,1,2,3,2,4,2,5]
    ans3=[3,3,1,1,2,2,4,4,5,5]    
    
    cnt1,cnt2,cnt3=0,0,0
    j,k,h=0,0,0
    
    for i in answers:
        if i==ans1[j]:
            cnt1=cnt1+1
        if i==ans2[k]:
            cnt2=cnt2+1
        if i==ans3[h]:
            cnt3=cnt3+1
            
        j=j+1
        k=k+1
        h=h+1
        
        if j==len(ans1):
            j=0
        if k==len(ans2):
            k=0
        if h==len(ans3):
            h=0
    
    res=[[1,cnt1],[2,cnt2],[3,cnt3]]
    max_cnt=max(res[0][1],res[1][1],res[2][1])
    
    for x in res:
        if max_cnt==x[1]:
            answer.append(x[0])

    
    return answer