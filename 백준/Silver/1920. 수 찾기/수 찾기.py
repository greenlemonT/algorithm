m = int(input())
m_list = list(map(int, input().split()))
n = int(input())
n_list = list(map(int, input().split()))

m_set = set(m_list)

answer = []
for num in n_list:
    if num in m_set:
        answer.append(1)
    else:
        answer.append(0)

for ans in answer:
    print(ans)