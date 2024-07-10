def solution(park, routes):
    r = {"S": [1, 0], "N": [-1, 0], "E": [0, 1], "W": [0, -1]}

    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                x, y = i, j

    for route in routes:
        direction, distance = route.split()
        dx, dy = r[direction]
        n = int(distance)

        temp_x, temp_y = x, y
        can_move = True
        for _ in range(n):
            temp_x += dx
            temp_y += dy
            if temp_x < 0 or temp_x >= len(park) or temp_y < 0 or temp_y >= len(park[0]) or park[temp_x][temp_y] == "X":
                can_move = False
                break

        if can_move:
            x, y = temp_x, temp_y

    return [x, y]

