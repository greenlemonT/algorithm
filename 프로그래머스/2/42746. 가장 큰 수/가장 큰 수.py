#정렬

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    #000' 이나 '00' 등이 나올 경우 '0'으로 줄여서 반환하기 위함
    #str->int->str 문제에서 숫자크니까 문자열로 return하라고 함
    return str(int(''.join(numbers)))
