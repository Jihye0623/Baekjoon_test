def solution(n):
    answer = []
    tri = [[0] * n  for _ in range(n)]
    x, y = -1, 0
    num = 1
    
    
    for i in range(n):
        for j in range(i,n):
            # down
            if i%3==0:
                x+=1
                
            # right
            elif i%3==1:
                y+=1
                
            # up    
            elif i%3==2:
                x-=1
                y-=1
                
            tri[x][y] = num
            num+=1
    
    
                
    for i in range(n):
        for j in range(i+1):
            answer.append(tri[i][j])   
            
    return answer