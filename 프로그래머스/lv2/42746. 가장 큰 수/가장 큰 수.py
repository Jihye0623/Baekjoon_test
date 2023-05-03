def solution(numbers):
    answer = ''
    
    for i in range(len(numbers)):
        numbers[i]=str(numbers[i])
        
    numbers.sort(key=lambda x:x*3, reverse=True)
    
    for i in numbers:
        answer+=i
        
    return str(int(answer))