s = input()
l = set()
for i in range(1, len(s)+1):
    for j in range(len(s)):
        l.add(s[j:j+i])
print(len(l))