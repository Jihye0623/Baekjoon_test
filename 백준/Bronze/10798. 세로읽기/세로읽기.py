li=[]
line=[]
for i in range(5):
    line=list(input())
    li.append(line)

res=''
for i in range(15):
    for k in range(5):
        if i<len(li[k]):
            res+=li[k][i]
print(res)