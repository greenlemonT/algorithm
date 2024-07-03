def solution(name, yearning, photo):
    answer = []
    dic = dict(zip(name, yearning))

    for group in photo:
        score = 0
        for person in group:
            if person in dic:
                score += dic[person]
        answer.append(score)

    return answer