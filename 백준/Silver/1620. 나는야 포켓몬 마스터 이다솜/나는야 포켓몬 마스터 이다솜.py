import sys
input=sys.stdin.readline
n, m=map(int, input().split())
dic={}
dic2={}

for i in range(n):
    name=input().strip()
    dic[name]=(i+1)
    dic2[i+1]=name

for i in range(m):
    ans=input().strip()
    if ans.isdigit():
        print(dic2[int(ans)])
    if ans.isalpha():
        print(dic[ans])