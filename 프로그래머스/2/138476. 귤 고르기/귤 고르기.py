from collections import Counter

def solution(k, tangerine):
    count = Counter(tangerine)
    sorted_count = count.most_common()
    
    answer = 0
    sum_count = 0
    
    for size, cnt in sorted_count:
        sum_count += cnt
        answer += 1
        if sum_count >= k:
            break
            
    return answer