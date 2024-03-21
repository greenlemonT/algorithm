def solution(numbers, k):
    answer = 0
    return numbers[2 * (k - 1) % len(numbers)]
