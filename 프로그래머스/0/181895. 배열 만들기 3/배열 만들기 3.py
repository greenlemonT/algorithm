def solution(arr, intervals):
    tmp = [arr[i[0]:i[1]+1] for i in intervals]
    answer = []
    for i in tmp:
        answer += i
    return answer