import math

T = int(input())
for _ in range(T):
    N,M = map(int,input().split()) # mCn
    arr = list(range(1,M+1))
    print(math.comb(M,N))
