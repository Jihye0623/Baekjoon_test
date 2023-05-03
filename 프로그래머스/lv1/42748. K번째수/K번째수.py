def solution(array, commands):
    answer = []
    
    for n in commands:
        newArray=array[n[0]-1:n[1]]
        newArray.sort()
        answer.append(newArray[n[2]-1])
        
    return answer