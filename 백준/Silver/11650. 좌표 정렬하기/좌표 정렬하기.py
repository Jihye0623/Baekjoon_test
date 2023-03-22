import sys

n=int(input())
li=[]
for i in range(n):
    mini_list=list(map(int,sys.stdin.readline().split()))
    li.append(mini_list)
    
li.sort()

for i in range(n):
    print(*li[i])