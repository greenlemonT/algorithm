from collections import deque

def bfs(start, end, maps):
    dy = [0, 1, -1, 0]
    dx = [1, 0, 0, -1]
    
    n = len(maps)       
    m = len(maps[0])   
    visited = [[False]*m for _ in range(n)]
    q = deque()
    flag = False
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:      
                q.append((i, j, 0))    
                visited[i][j] = True
                flag = True; 
                break 
        if flag: 
            break
                
    while q:
        y, x, cost = q.popleft()
        
        if maps[y][x] == end:
            return cost
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0<= ny <n and 0<= nx <m and maps[ny][nx] !='X':
                if not visited[ny][nx]:	
                    q.append((ny, nx, cost+1))
                    visited[ny][nx] = True
                    
    return -1	
        
            
def solution(maps):
    a = bfs('S', 'L', maps)	
    b = bfs('L', 'E', maps) 
    
    if a != -1 and b != -1:
        return a+b

    return -1