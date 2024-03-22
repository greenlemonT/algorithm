from math import factorial

def solution(n):
    answer = 10
    while n < factorial(answer):
        answer -= 1
    return answer