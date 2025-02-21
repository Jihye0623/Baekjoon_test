def pleasuer(l, j, i):
    global L, J, joy
    # 마지막인덱스에 도착했을때 들어간다
    if i == n:
        # joy보다 커졌을때 저장한다
        if joy < j:
            joy = j
        # 마지막 인덱스라면 리턴한다
        return
    # 마지막 인덱스에 갈떄까지 재귀
    pleasuer (l, j, i+1)
    # 리턴 시 돌아온다 & 뒤에서부터 L[i]를 뺴도 0보다 크다면 들어간다/ 아님 풀린다.
    if l - L[i] > 0:
        pleasuer(l - L[i], j + J[i], i+1)
    
n = int(input())

L = list(map(int, input().split()))
J = list(map(int, input().split()))

l, j = 100, 0

joy =0
pleasuer(l, j, 0)

print(joy)