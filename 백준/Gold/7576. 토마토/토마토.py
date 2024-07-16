import sys
from collections import deque

M, N = map(int, sys.stdin.readline().strip().split())

matrix = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(N):
    matrix.append(list(map(int, sys.stdin.readline().strip().split())))

Q = deque()

for x in range(N):
    for y in range(M):
        if matrix[x][y] == 1:
            Q.append([x, y])

# 출발지가 여러개므로 BFS 실행
while Q:
    x, y = Q.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and matrix[nx][ny] == 0:
            matrix[nx][ny] = matrix[x][y] + 1
            Q.append([nx, ny])

day = 0

for row in matrix:
    for value in row:
        if value == 0:
            print(-1)
            exit(0)
    day = max(day, max(row))

print(day - 1)
