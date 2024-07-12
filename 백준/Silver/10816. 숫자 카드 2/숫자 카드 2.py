from collections import Counter

n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))

counter = Counter(n_list)

answer = [counter[i] for i in m_list]

print(" ".join(map(str, answer)))
