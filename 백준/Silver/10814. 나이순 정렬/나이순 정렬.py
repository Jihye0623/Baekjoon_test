n=int(input())
li=[]

for i in range(n):
    line=list(map(str,input().split()))
    line[0]=int(line[0])
    li.append(line)
    
li.sort(key = lambda x : x[0])
for i in range(n):
    print(*li[i])