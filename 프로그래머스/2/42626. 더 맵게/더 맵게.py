import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)  
    
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1  
        
        m = heapq.heappop(scoville)  
        n = heapq.heappop(scoville)  
        temp = m + (n * 2)
        heapq.heappush(scoville, temp) 
        answer += 1
    
    return answer
