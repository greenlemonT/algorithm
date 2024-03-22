def solution(numbers):
    answer = sorted(numbers, reverse=True)
    return answer[0] * answer[1]