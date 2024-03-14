def solution(my_string, is_prefix):
    answer=0
    tmp=[my_string[:i] for i in range(len(my_string))]
    if is_prefix in tmp:
        answer=1
    else:
        answer=0
    return answer