def solution(sequence, k):
    n = len(sequence)
    left, right = 0, 0
    current_sum = sequence[0]
    min_length = float('inf')
    answer = []

    while right < n:
        if current_sum == k:
            if (right - left) < min_length:
                min_length = right - left
                answer = [left, right]
            elif (right - left) == min_length and (not answer or left < answer[0]):
                answer = [left, right]

            current_sum -= sequence[left]
            left += 1

        if current_sum < k:
            right += 1
            if right < n:
                current_sum += sequence[right]
        elif current_sum > k:
            current_sum -= sequence[left]
            left += 1

    return answer

