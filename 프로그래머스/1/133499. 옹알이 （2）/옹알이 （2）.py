def solution(babbling):
    answer = 0
    able = ["aya", "ye", "woo", "ma"]
    for token in babbling:
        for a in able:
            if a * 2 not in token:
                token = token.replace(a, ' ')
        if token.isspace():
            answer += 1
    return answer