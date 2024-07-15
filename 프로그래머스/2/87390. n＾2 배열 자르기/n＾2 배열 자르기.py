def solution(n, left, right):
    answer = []
    for i in range(left,right+1):
        s,r = divmod(i,n)
        if s >= r:  answer.append(s+1)
        else:   answer.append(r+1)
    return answer