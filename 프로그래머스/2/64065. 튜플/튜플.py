def solution(s):
    li=[]
    for i in s.split("},"):
        li.append(i.replace("{","").replace("}","").split(","))
    li.sort(key=len)
    answer=[]
    for i in li:
        for j in i:
            if j not in answer:
                answer.append(j)
    return list(map(int,answer))
