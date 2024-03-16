def solution(n, k):
    return [num for num in range(1, n+1) if num % k == 0]