data=input().split('-')

sum=0
for i in data[0].split('+'):
    sum+=int(i)
    
for i in data[1:]:
    for j in i.split('+'):
        sum-=int(j)

print(sum)