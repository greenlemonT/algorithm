from collections import deque

def solution(maps):
    answer=0
    N=len(maps)
    M=len(maps[0])
    
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    
    q=deque()
    q.append((0,0))
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<N and 0<=ny<M and maps[nx][ny]==1:
                maps[nx][ny]=maps[x][y]+1
                q.append((nx,ny))
    answer=maps[N-1][M-1]
    if answer==1:
        answer=-1
    return answer
                