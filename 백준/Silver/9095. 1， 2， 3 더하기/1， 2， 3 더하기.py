

def go(sum, goal):
    if sum > goal:
        return

    if sum == goal:
        global answer
        answer += 1
        return

    now = 0

    for i in range(1, 4):
        go(sum + i, goal)

n = int(input())
answer = 0

for _ in range(n):
    goal = int(input())
    go(0, goal)
    print(answer)
    answer = 0