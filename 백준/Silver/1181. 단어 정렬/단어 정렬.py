import sys
input=sys.stdin.readline

n=int(input())
dic=[]
for _ in range(n):
    dic.append(input().rstrip())

#set으로 중복값제거 -> 다시 list
dic2=set(dic)
dic=list(dic2)

#알파벳 순서 정렬+길이
dic.sort()
dic.sort(key= lambda x: len(x))

for i in dic:
    print(i)
