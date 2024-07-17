#플로이드워셜
import sys
input = sys.stdin.readline

def floyd_warshall(n, adj):
    dist = [[float('inf')] * n for _ in range(n)]

    for i in range(n):
        dist[i][i] = 0

    for i in range(n):
        for j in adj[i]:
            dist[i][j] = 1
            dist[j][i] = 1

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    return dist

def find_chairman(n, dist):
    scores = [max(dist[i]) for i in range(n)]
    min_score = min(scores)
    candidates = [i + 1 for i in range(n) if scores[i] == min_score]

    return min_score, candidates

n = int(input())
adj = [[] for _ in range(n)]

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    adj[a - 1].append(b - 1)
    adj[b - 1].append(a - 1)

dist = floyd_warshall(n, adj)
min_score, candidates = find_chairman(n, dist)

print(min_score, len(candidates))
print(*candidates)
