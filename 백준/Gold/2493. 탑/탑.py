#스택 써야함
import sys

n=int(sys.stdin.readline().strip())
m=list(map(int,sys.stdin.readline().split(" ")))

stack=[]
ans=[0]*n

for i,floor in enumerate(m):
    while stack:
        if stack[-1][1]<=floor:
            stack.pop()
        else:
            ans[i]=stack[-1][0]
            break
    stack.append((i+1,floor))

print(*ans)

