def solution(clothes):
    closet = {} 
    for name, kind in clothes:
        if kind in closet.keys():
            closet[kind] += [name]
        else:
            closet[kind] = [name]
    answer = 1
    for i, value in closet.items():
        answer *= (len(value) + 1)
        
    return answer -1