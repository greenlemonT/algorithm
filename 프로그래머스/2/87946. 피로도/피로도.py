from itertools import permutations
def solution(k, dungeons):
    answer = -1
    
    for i in permutations(dungeons,len(dungeons)):
        temp=k
        cnt=0
        for need,cost in i:
            if temp>=need:
                temp-=cost
                cnt+=1
        answer=max(cnt,answer)
    return answer