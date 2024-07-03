def solution(answers):
    answer = []
    
    people1 = [1, 2, 3, 4, 5]
    people2 = [2, 1, 2, 3, 2, 4, 2, 5]
    people3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    count1 = 0
    count2 = 0
    count3 = 0
    for i in range(len(answers)):
        if (people1[i - len(people1) * (i // len(people1))] == answers[i]):
                count1 += 1
        if (people2[i - len(people2) * (i // len(people2))] == answers[i]):
                count2 += 1
        if (people3[i - len(people3) * (i // len(people3))] == answers[i]):
                count3 += 1
            
    if (count1 == max(count1, count2, count3)):
        answer.append(1)
    if (count2 == max(count1, count2, count3)):
        answer.append(2)
    if (count3 == max(count1, count2, count3)):
        answer.append(3)
        
    return answer