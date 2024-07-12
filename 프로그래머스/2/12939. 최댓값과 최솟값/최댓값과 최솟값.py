def solution(s):
    numbers = list(map(int, s.split()))

    min_value = min(numbers)
    max_value = max(numbers)

    return f"{min_value} {max_value}"
