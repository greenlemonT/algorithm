def solution(keymap, targets):
    d = dict()
    for keys in keymap:
        for key in keys:
            if key in d:
                d[key] = min(keys.index(key) + 1, d[key])
            else:
                d[key] = keys.index(key) + 1
    
    ans = []
    for target in targets:
        cnt = 0
        for s in target:
            if s not in d:
                ans.append(-1)
                break
            cnt += d[s]
        else:
            ans.append(cnt)
        
    return ans