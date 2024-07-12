#완전탐색
def solution(brown, yellow):
    total = brown + yellow
    
    for height in range(1, int(yellow**0.5) + 1):
        if yellow % height == 0:
            width = yellow // height
            if (width + 2) * (height + 2) == total:
                return [width + 2, height + 2]

    return []