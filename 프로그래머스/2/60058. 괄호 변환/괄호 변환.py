def step3(p):
    for i in range(2,len(p)+1):
        string = p[:i]
        if string.count('(') == string.count(')'):
            u = string
            v = p[i:]
            break
    return u,v

def check(string):
    stack = []
    for s in string:
        if s=='(':
            stack.append(s)
        else:
            if len(stack)==0:
                return False
            stack.pop()
    if len(stack): return False
    return True

def solution(p):    
    if p == '':
        return p
    
    temp = ''
    u,v = step3(p)
    if check(u):
        temp += u + solution(v)
    else:
        temp += '('
        temp += solution(v)
        temp += ')'
        tu = u[1:-1]
        for t in tu:
            if t==')':
                temp+='('
            else:
                temp+=')'
    return temp