while True:
    li=[]
    n=int(input())
    
    if n==-1:
        break
        
    for i in range(1,n):
        if n%i==0:
            li.append(i)
    
    if sum(li)==n:
        print(n, "= ", end='')
        print(*li, sep=' + ')
    else:
        print(n,"is NOT perfect.")