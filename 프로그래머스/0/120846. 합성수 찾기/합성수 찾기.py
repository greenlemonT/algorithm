def solution(n):
    arr = []
    answer = 0
    for i in range(2, n+1):
        for j in range(1, i+1):
            if i % j == 0:
                arr.append(i)
        if arr.count(i) >= 3:
            answer += 1
    return answer