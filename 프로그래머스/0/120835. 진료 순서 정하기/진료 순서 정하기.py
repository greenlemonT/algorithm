def solution(emergency):
    return [sorted(emergency, reverse=True).index(e) + 1 for e in emergency]