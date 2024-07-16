answer = 0
def solution(numbers, target):
    def dfs(index, result):
        global answer
        if index >= n:
            if result == target:
                answer += 1
            return
        
        dfs(index + 1, result + numbers[index])
        dfs(index + 1, result - numbers[index])
    
    n = len(numbers)
    dfs(0, 0)
    return answer