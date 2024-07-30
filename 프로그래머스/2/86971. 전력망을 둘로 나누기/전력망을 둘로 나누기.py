from collections import deque

def bfs(graph, start, n):
    visited = [0] * (n + 1)
    q = deque([start])
    visited[start] = 1
    cnt = 1
    while q:
        s = q.popleft()
        for i in graph[s]:
            if not visited[i]:
                q.append(i)
                visited[i] = 1
                cnt += 1
    return cnt

def solution(n, wires):
    res = n
    graph = [[] for _ in range(n + 1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    for a, b in wires:
        # graph에서 간선을 제거
        graph[a].remove(b)
        graph[b].remove(a)
        
        # 두 부분의 크기 차이 계산
        res = min(abs(bfs(graph, a, n) - bfs(graph, b, n)), res)
        
        # 간선을 복구
        graph[a].append(b)
        graph[b].append(a)
    
    return res


 