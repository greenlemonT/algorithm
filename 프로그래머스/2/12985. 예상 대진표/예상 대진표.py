def solution(n,a,b):
    round = 0 
    while a != b:
        round += 1
        a = (a+1) // 2
        b = (b+1) // 2
    return round