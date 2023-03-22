n,m=map(int,input().split())
li=list(map(int,input().split()))

res=0

for i in range(len(li)):
    for j in range(i+1,len(li)):
        for k in range(j+1,len(li)):
            x=li[i]+li[j]+li[k]
            if m<x:
                continue
            else:
                res=max(res,x)
                
print(res)