def solution(my_string, m, c):
    tmp=[my_string[i:i+m] for i in range(0,len(my_string),m)]
    answer="".join(tmp[i][c-1] for i in range(0,len(tmp)))
    return answer