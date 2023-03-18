import sys

li=[]

n=int(input())
for i in range(n):
    a = int(sys.stdin.readline())
    li.append(a)
    
li.sort()
for i in range(n):
    print(li[i])