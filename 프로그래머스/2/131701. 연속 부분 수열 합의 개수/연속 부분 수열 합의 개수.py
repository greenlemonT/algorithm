def solution(elements):
    n = len(elements)
    circle = elements * 2  
    answer = set()

    for length in range(1, n + 1):
        for start in range(n):
            temp = sum(circle[start:start + length])
            answer.add(temp)

    return len(answer)
