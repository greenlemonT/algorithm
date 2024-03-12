def solution(arr):
    stk = []
    idx = 0
    
    while idx < len(arr):
        if len(stk) == 0:
            stk.append(arr[idx])
            idx += 1
        elif len(stk) > 0 and stk[-1] < arr[idx]:
            stk.append(arr[idx])
            idx += 1
        elif len(stk) > 0 and stk[-1] >= arr[idx]:
            stk.pop()
    
    return stk