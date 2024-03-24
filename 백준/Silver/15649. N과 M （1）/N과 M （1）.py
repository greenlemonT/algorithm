#tuple -> str 
from itertools import permutations

N, M = map(int, input().split())
P = permutations(range(1, N+1), M)  
for i in P:
    print(' '.join(map(str, i)))