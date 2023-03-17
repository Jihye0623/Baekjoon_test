num,n=map(int,input().split())

li=[]
for i in range(1,num+1):
    if num%i==0:
        li.append(i)
        
        
if n<=len(li):
    print(li[n-1])
else:
    print(0)