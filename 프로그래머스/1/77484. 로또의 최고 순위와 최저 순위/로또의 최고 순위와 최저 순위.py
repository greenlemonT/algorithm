def solution(lottos, win_nums):
    answer = []
    count = 0
    max_match = 0
    min_match = 0
    
    for i in lottos:
        if i in win_nums:
            count += 1
        if i == 0:
            max_match += 1
    
    max_match += count
    min_match = count
    
    # 최고 순위 계산
    if max_match == 0 or max_match == 1:
        answer.append(6)
    else:
        answer.append(7 - max_match)
    
    if min_match == 0 or min_match == 1:
        answer.append(6)
    else:
        answer.append(7 - min_match)
    
    return answer
