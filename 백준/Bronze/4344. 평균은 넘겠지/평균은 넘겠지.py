n=int(input())

for i in range(n):
    li=[]
    hap=0
    cnt=0
    
    li=list(map(int,input().split()))
    ave=sum(li[1:])/li[0]
    
    for j in li[1:]:
        if j>ave:
            cnt+=1
            
    res=cnt/li[0]*100
    print('%.3f' %res + '%') 
    