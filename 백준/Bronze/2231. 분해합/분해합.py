m=int(input())

for i in range(1,m+1):
    num_list=list(map(int,str(i)))
    res=i+sum(num_list)
    if m==res:
        print(i)
        break
        
    if i==m:
        print(0)