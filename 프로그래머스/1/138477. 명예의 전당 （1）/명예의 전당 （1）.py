def solution(k, score):
    answer = []
    
    hall = []
    for i in score:
        if (len(hall) < k):
            hall.append(i)
        else:
            if (i > min(hall)):
                hall.remove(min(hall))
                hall.append(i)
                
        hall.sort()
        answer.append(hall[0])
        
    return answer