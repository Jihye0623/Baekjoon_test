n=int(input())
li=list(map(int,input().split()))
cnt=0

for i in li:
    count=0
    for j in range(1,i+1):
        if i%j==0:
            count+=1
    if count==2:
        cnt+=1
        
print(cnt)