def solution(s):
    answer = True
    right=0
    left=0
    
    for i in range(len(s)):
        if left==right and s[i]==')':
            return False
        elif i==len(s)-1 and s[i]=='(':
            return False
        elif s[i]=='(':
            left=left+1
        else:
            right=right+1
            

    if right!=left:
        return False 
    
    return True