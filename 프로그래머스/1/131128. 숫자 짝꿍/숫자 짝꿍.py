from collections import Counter
def solution(X, Y):
    countX = Counter(X)
    countY = Counter(Y)

    common_numbers = []
    for digit in range(10):
        if str(digit) in countX and str(digit) in countY:
            common_count = min(countX[str(digit)], countY[str(digit)])
            common_numbers.extend([str(digit)] * common_count)
    
    if not common_numbers:
        return "-1"
    
    common_numbers.sort(reverse=True)
    result = ''.join(common_numbers)
    if result[0] == '0':
        return "0"
    
    return result
