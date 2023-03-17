x=[]

for i in range(9):
    li=list(map(int,input().split()))
    x.append(li)
    
n,m=0,0
num=0

for i in range(9):
    for k in range(9):
        if num<x[i][k]:
            num=x[i][k]
            n,m=i,k
            
print(num)
print(n+1,m+1)