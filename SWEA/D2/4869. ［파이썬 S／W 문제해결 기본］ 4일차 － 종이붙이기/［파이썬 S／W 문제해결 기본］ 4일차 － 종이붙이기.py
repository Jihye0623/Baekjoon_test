def f(n):
    if n<2:
        return 1
    return f(n-1) + f(n-2)*2

test = int(input())

for t in range(1, test+1):
    n = int(input())       
    
    print(f"#{t} {f(n//10)}") 
