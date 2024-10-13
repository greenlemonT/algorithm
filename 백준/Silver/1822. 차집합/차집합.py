from sys import stdin

n, m = map(int, stdin.readline().split())
a = set(map(int, stdin.readline().split()))
b = set(map(int, stdin.readline().split()))

res = a-b

if res:
    print(len(res))
    print(*sorted(list(res)))
else:
    print(0)