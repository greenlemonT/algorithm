def solution(n):
    cnt1 = bin(n)[2:].count("1")
    
    while True:
        n += 1
        if cnt1 == bin(n)[2:].count("1"):
            break

    return n