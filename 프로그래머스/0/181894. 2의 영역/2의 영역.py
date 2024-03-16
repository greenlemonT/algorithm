def solution(arr):
    answer = []
    
    if 2 in arr:
        if arr.count(2) > 1:
            start = arr.index(2)
            end = len(arr) - arr[::-1].index(2)
            return arr[start:end]
        else:
            idx = arr.index(2)
            return [arr[idx]]
    else:
        return [-1]
    
    return answer