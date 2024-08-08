def solution(s):
    answer = -1
    a=list(s)
    b=[]
    
    for i in a:
        if b and b[-1]==i:
            b.pop()
            
        else:
            b.append(i)
    if len(b)==0:
        answer=1
    else:
        answer=0
    return answer