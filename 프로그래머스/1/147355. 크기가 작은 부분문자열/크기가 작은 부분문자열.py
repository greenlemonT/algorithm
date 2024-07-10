def solution(t, p):
    answer = 0
    num = len(p)
    p_num = int(p) 
    
    for i in range(len(t) - num + 1):
        temp = t[i:i + num]
        if int(temp) <= p_num:  
            answer += 1
    
    return answer
