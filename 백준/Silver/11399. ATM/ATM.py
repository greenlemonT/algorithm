n=int(input())
arr=list(map(int,input().split()))
arr.sort()
ans=0
time=0
for i in range(n):
    time+=arr[i]
    ans+=time
print(ans)