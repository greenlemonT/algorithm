def solution(intStrs, k, s, l):
    answer = []

    for i in intStrs:
        if int(i[s:s+l]) > k:
            answer.append(int(i[s:s+l]))

    return answer