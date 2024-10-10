from collections import Counter

def solution(k, tangerine):
    count = Counter(tangerine)
    sorted_count = count.most_common()
    
    answer = 0
    sum = 0
    
    for size, cnt in sorted_count:
        sum += cnt
        answer += 1
        if sum >= k:
            break
            
    return answer