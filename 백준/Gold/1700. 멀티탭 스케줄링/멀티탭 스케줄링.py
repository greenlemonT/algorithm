#남은 사용 중에 가장 늦게 사용되는것을 뽑으면 된다!
N, K = map(int,input().split(' '))
use = list(map(int,input().split(' ')))
code = []
answer = 0

for this in range(K):
    if use[this] in code :  
        continue

    if len(code) < N : 
        code.append(use[this])
        continue

    priority = []
    for c in code:  
        if c in use[this:]: 
            priority.append(use[this:].index(c))
        else:
            priority.append(101)
    target = priority.index(max(priority))
    code.remove(code[target])
    code.append(use[this])
    answer += 1

print(answer)