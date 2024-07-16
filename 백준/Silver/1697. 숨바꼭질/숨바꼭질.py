import sys
from collections import deque

def bfs(v):
    q = deque([v])
    array[v] = 0  
    while q:
        v = q.popleft()
        if v == k:
            return array[v]
        for next_v in (v-1, v+1, 2*v):
            if 0 <= next_v < MAX and array[next_v] == -1:
                array[next_v] = array[v] + 1
                q.append(next_v)

MAX = 100001
n, k = map(int, sys.stdin.readline().split())
array = [-1] * MAX
print(bfs(n))
