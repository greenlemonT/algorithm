import sys

n=int(sys.stdin.readline().strip())
result=[]
stack=[]

cur=1

for _ in range(n):
    seq=int(sys.stdin.readline().strip())
    while cur<=seq:
        stack.append(cur)
        result.append('+')
        cur+=1
    if stack[-1]==seq:
        stack.pop()
        result.append('-')
    else:
        result.clear()
        result.append('NO')
        break

for answer in result:
    print(answer)