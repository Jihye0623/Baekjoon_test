import sys

a=int(input())
ali=list(map(int, sys.stdin.readline().split()))
b=int(input())
bli=list(map(int, sys.stdin.readline().split()))

ali.sort()
    
for i in bli:
    cnt=0
    left=0
    right=len(ali)-1
    while left<=right:
        mid=(left+right)//2
        if ali[mid]==i:
            print("1", end=' ')
            cnt=1
            break
        elif ali[mid]>i:
            right=mid-1
        else:
            left=mid+1
    if cnt==0:
        print("0", end=' ')