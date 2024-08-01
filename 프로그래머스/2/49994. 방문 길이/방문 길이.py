def solution(dirs):
    loc = {'U':(0, 1), 'D':(0, -1), 'R':(1, 0), 'L':(-1, 0)}
    #중복을 제거하기 위해 set(), add()해도 추가안됨
    answer = set()
    x, y = 0, 0
    for d in dirs:
        dx, dy = loc[d]
        nx, ny = x + dx, y + dy
        
        if abs(nx) <= 5 and abs(ny) <= 5:
            answer.add((x, y, nx, ny))
            #반대방향으로 같은 길 가도 제외
            answer.add((nx, ny, x, y))
            x = nx 
            y = ny
            
    return len(answer) // 2