n=int(input())
li=[]

for i in range(n):
    line=input()
    if line in li:
        continue
    li.append(line)
    
li.sort()
li.sort(key=len)

for i in li:
    print(i)