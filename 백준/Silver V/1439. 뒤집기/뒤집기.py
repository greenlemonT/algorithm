data=input()
cnt=0
for i in range(len(data)-1):
    if data[i]!=data[i+1]:
        cnt+=1
print((cnt+1)//2)