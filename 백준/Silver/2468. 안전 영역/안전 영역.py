from collections import deque

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
maxCnt = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and temp[nx][ny] == 0:
                temp[nx][ny] = 1
                queue.append([nx, ny])


for i in range(101):
    temp = [[0] * n for i in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if graph[j][k] <= i:
                temp[j][k] = 1
    for j in range(n):
        for k in range(n):
            if temp[j][k] == 0:
                temp[j][k] = 1
                bfs(j, k)
                cnt += 1

    if cnt == 0:
        break
    maxCnt = max(maxCnt, cnt)

print(maxCnt)