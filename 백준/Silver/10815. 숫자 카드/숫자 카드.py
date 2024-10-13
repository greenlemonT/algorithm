n = int(input())

arr = list(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))

arr.sort()

for now in check:
    s = 0
    e = n - 1
    ans = 0

    while s <= e:
        mid = (s + e) // 2

        if now > arr[mid]:
            s = mid + 1
        elif now == arr[mid]:
            ans = 1
            break
        else:
            e = mid - 1
    print(ans, end=" ")