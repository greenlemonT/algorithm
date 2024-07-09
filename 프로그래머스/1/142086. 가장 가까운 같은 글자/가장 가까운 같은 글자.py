def solution(s):

  answer = []
  di = {}

  for i in range(len(s)):
    if s[i] not in di:
      answer.append(-1)
    else:
      answer.append(i-di[s[i]])
    di[s[i]] = i

  return answer