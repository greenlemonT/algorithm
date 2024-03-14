def solution(my_string, is_suffix):
    answer = 0
    tmp=[my_string[i:]for i in range(0,len(my_string))]
    if is_suffix in tmp:
        answer=1
    else:
        answer=0

    return answer