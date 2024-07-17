from collections import deque

def solution(bridge_length,weight,truck_weights):
    time=0
    bridge=deque([0]*bridge_length)
    truck_weights=deque(truck_weights)
        
    current=0
    #다리에서 먼저 빼고난후 들어올 truckweight.popleft()와 더해서 비교
    while len(truck_weights)!=0:
        time+=1
        current-=bridge.popleft()
            
        if current+truck_weights[0]<=weight:
            current+=truck_weights[0]
            bridge.append(truck_weights.popleft())
        else:
            bridge.append(0)
    time+=bridge_length
    
    return time