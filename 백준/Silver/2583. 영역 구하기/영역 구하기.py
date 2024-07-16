#dfs
import sys
sys.setrecursionlimit(10**6)
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def dfs(x, y):
    global volume
    if x < 0 or x >= M or y < 0 or y >= N:
        return 0

    if paper[x][y] == 0:
        volume += 1
        paper[x][y] = 1
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            dfs(nx, ny)
        return volume
    return 0

M, N, K = map(int, input().split())
paper = [[0] * N for _ in range(M)]

for _ in range(K):
    ax, ay, bx, by = map(int, input().split())
    for i in range(ax, bx):
        for j in range(ay, by):
            paper[j][i] = 1

count = 0
volume_list = []

for i in range(M):
    for j in range(N):
        volume = 0
        if dfs(i, j) >= 1:
            count += 1
            volume_list.append(volume)

volume_list.sort()

print(count)
print(" ".join(map(str, volume_list)))