#백트래킹
#combination사용했을때
import sys
from itertools import combinations
input=sys.stdin.readline
n,m= map(int,input().split())
num=list(map(int,input().split()))
ans=0
for i in range(1,n+1):
    for a in combinations(num,i):
        if sum(a)==m:
            ans+=1
print(ans)