import sys
input=sys.stdin.readline

def answer(s):
    sum=0
    for i in s:
        if i.isdigit():
            sum+=int(i)
    return sum

n=int(input())
numbers=[input().rstrip() for i in range(n)]
#길이, 모든자릿수의 합, 사전순으로 정렬
numbers.sort(key=lambda x:(len(x),answer(x),x))
for num in numbers:
    print(num)