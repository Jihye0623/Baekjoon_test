a=int(input())
b=int(input())
c=int(input())

if a+b+c!=180:
    print("Error")
elif a==b and b==c and c==a:
    print("Equilateral")
elif a!=b and b!=c and c!=a:
    print("Scalene")
else:
    print("Isosceles")