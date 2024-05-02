import sys

a = sys.stdin.readlines()
numbers = []
for i in a:
    for j in i.split():
        #뒤에 sort해줘야하니까 str->int변환 +역순
        numbers.append(int(j[::-1]))
        
#첫번째원소는 입력개수이므로 빼야함
numbers = numbers[1:]
numbers.sort()
#join 쓰기위해 다시 int->str 변환 
print("\n".join(map(str,numbers)))
