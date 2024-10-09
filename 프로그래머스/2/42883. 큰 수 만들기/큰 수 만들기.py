# Stack
#앞자리에 큰 숫자가 오는 것이 전체 수를 크게 만들 수 있음

def solution(number, k):
    answer = [] 
    for num in number:
        while k > 0 and answer and answer[-1] < num:
            answer.pop()
            k -= 1
        answer.append(num)
        
    return ''.join(answer[:len(answer) - k])