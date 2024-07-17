def solution(phoneBook):
    phoneBook.sort()

    for i in range(len(phoneBook)-1):
        if phoneBook[i+1][:len(phoneBook[i])]==phoneBook[i]:
            return False
            break
    return True