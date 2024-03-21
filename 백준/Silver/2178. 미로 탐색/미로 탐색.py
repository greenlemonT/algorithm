from collections import deque
import sys
N,M = map(int, sys.stdin.readline().split())
pan = [list(str(sys.stdin.readline().strip())) for _ in range(N)]
visited = [[False for _ in range(M)] for i in range(N)]
distance = [[1 for _ in range(M)] for i in range(N)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]
def bfs():
    queue = deque()
    queue.append((0,0))
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or ny < 0 or nx>=N or ny >= M:
                continue
            if visited[nx][ny]==False and pan[nx][ny] == '1':
                queue.append((nx,ny))
                visited[nx][ny] = True
                distance[nx][ny] += distance[x][y]

bfs()
print(distance[N-1][M-1])