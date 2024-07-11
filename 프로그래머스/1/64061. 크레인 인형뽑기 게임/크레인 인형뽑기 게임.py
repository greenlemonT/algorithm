def solution(board, moves):
    nrow, ncol = len(board), len(board[0])
    answer = []
    counts = 0
    for m in moves:
        for i in range(nrow):
            if board[i][m-1]:
                answer.append(board[i][m-1])
                board[i][m-1] = 0
                break
        
        if len(answer) > 1:
            if answer[-2] == answer[-1]:
                answer = answer[:-2]
                counts += 2
    return counts