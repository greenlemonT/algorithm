import re
def solution(my_string):
    return re.sub(r'[aeiou]', '', my_string)