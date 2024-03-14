def solution(q,r,code):
    answer=''
    for a,b in enumerate(code):
        if a%q==r:
            answer+=b
    return answer  