#DP_03
import sys

input = sys.stdin.readline
n = int(input())
home = []
for _ in range(n):
    home.append(list(map(int, input().split())))

for i in range(1, n):
    home[i][0] += min(home[i - 1][1], home[i - 1][2])
    home[i][1] += min(home[i - 1][2], home[i - 1][0])
    home[i][2] += min(home[i - 1][0], home[i - 1][1])

result = min(home[n - 1])
print(result)