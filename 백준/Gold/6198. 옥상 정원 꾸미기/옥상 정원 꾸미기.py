#나를 볼수있는 건물기준 (내가볼수있는 건물관점x)
#탑문제랑 접근 비슷
import sys

n = int(sys.stdin.readline())
m= []
for _ in range(n):
    m.append(int(sys.stdin.readline()))

cnt=0
stack=[]
for floor in m:
    while stack:
        if stack[-1]<=floor:
            stack.pop()
        else:
            cnt+=len(stack)
            break
    stack.append(floor)

print(cnt)

