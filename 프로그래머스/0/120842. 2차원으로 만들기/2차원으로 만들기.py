def solution(num_list, n):
    answer = []
    temp = []
    count = 0;
    for i in num_list:
        temp.append(i)
        count += 1
        if count == n:
            answer.append(temp)
            count = 0
            temp = []
    return answer