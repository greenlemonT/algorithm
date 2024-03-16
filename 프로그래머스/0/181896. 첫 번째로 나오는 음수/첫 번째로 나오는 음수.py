def solution(num_list):
    answer = -1
    
    for idx, val in enumerate(num_list):
        if val < 0:
            answer = idx
            break
    
    return answer