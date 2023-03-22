import sys

n=int(input())
li=[]
for i in range(n):
    mini_list=list(map(int,sys.stdin.readline().split()))
    li.append(mini_list)
    temp=li[i][0]
    li[i][0]=li[i][1]
    li[i][1]=temp
    
li.sort()    

for i in range(n):
    temp=li[i][0]
    li[i][0]=li[i][1]
    li[i][1]=temp
    print(*li[i])