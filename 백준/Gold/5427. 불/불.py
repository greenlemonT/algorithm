#불 처리 후 사람 처리
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def escape(a, b):
    q = deque()
    fire_q = deque()
    visited = [[-1] * n for _ in range(m)]
    fire_visited = [[-1] * n for _ in range(m)]

    q.append((a, b))
    visited[a][b] = 0

    for i in range(m):
        for j in range(n):
            if maps[i][j] == '*':
                fire_q.append((i, j))
                fire_visited[i][j] = 0

    while fire_q:
        x, y = fire_q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and fire_visited[nx][ny] == -1 and maps[nx][ny] == '.':
                fire_visited[nx][ny] = fire_visited[x][y] + 1
                fire_q.append((nx, ny))

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                return visited[x][y] + 1
            if 0 <= nx < m and 0 <= ny < n and visited[nx][ny] == -1 and maps[nx][ny] == '.':
                if fire_visited[nx][ny] == -1 or fire_visited[nx][ny] > visited[x][y] + 1:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))

    return 'IMPOSSIBLE'

t = int(input())

for tc in range(t):
    n, m = map(int, input().split())
    maps = [list(input().strip()) for _ in range(m)]
    result = 'IMPOSSIBLE'
    for i in range(m):
        for j in range(n):
            if maps[i][j] == '@':
                result = escape(i, j)
                break
    print(result)
