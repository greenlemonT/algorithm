def solution(n):
    answer = []
    divide = 2
    while divide <= n:
        if n % divide == 0:
            if divide not in answer:
                answer.append(divide)
            n /= divide
        else:
            divide += 1
    return answer