def solution(arr, idx):
    answer = -1
    
    for key, val in enumerate(arr):
        if key >= idx and val == 1:
            answer = key
            break
    
    return answer