#다익스트라
import heapq

INF = int(1e9)

def solution(N, road, K):
    answer = 0
    distance = [INF] * (N + 1)
    start = 1
    distance[start] = 0
    
    graph = [[] for _ in range(N + 1)]
    
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))
        
    queue = []
    heapq.heappush(queue, (0, start))
    
    while queue:
        dist, now = heapq.heappop(queue)
        if distance[now] < dist:
            continue
            
        for c, d in graph[now]:
            temp = dist + d
            if temp < distance[c]:
                distance[c] = temp
                heapq.heappush(queue, (temp, c))
                
    for i in distance:
        if i <= K:
            answer += 1
    
    return answer
        