def turn_right(key, m):
    temp = [[0]*m for _ in range(m)]
    for i in range(m):
        for j in range(m):
            temp[i][j] = key[(m-j-1)%m][i]
    return temp

def check(nlock, n):
    for i in range(n,n*2):
        for j in range(n,n*2):
            if nlock[i][j] != 1:
                return False
    return True
    
def solution(key, lock):
    answer = False
    n,m = len(lock), len(key)
    graph = [[0]*n*3 for _ in range(n*3)]
    for i in range(n,2*n):
        for j in range(n,2*n):
            graph[i][j] = lock[i%n][j%n]

    for r in range(4):
        key = turn_right(key,m)
        for x in range(n*2):
            for y in range(n*2):
                for i in range(m):
                    for j in range(m):
                        graph[x+i][y+j] += key[i][j]

                if check(graph,n):
                    return True
                for i in range(m):
                    for j in range(m):
                        graph[x+i][y+j] -= key[i][j]
        
    return answer