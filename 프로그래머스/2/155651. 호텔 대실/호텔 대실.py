#백준-회의실배정,순회강연과 비슷

from heapq import heappush, heappop

def solution(book_time):
    answer = 1
    
    # "HH:MM" → HH * 60 + MM
    time = [(int(start[:2]) * 60 + int(start[3:]), 
             int(end[:2]) * 60 + int(end[3:])) 
            for start, end in book_time]
    time.sort()
    
    heap = []
    for start, end in time:
        if not heap:
            heappush(heap,end+10)
            continue
        if heap[0] <= start:
            heappop(heap)
        else:
            answer += 1
        heappush(heap,end+10)
    
    return answer