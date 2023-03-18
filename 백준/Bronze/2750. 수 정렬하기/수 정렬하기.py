n=int(input())
li=[]

for i in range(n):
    k=int(input())
    li.append(k)
    
li.sort()
print(*li)