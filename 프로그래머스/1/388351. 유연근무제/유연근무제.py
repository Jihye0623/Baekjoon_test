def convertTime(n):
    h = n // 100
    m = n%100
    return h*60 + m

def solution(schedules, timelogs, startday):
    answer = 0

    for i in range(len(schedules)):
        check = True
        day = startday
        schedule = convertTime(schedules[i])
        for time in timelogs[i]:
            t = convertTime(time)
            if t > (schedule+10) and day != 6 and day!=7 :
                check = False
                break
            day += 1
            if day>7:
                day = 1    
        if check:
            print(schedules[i])
            answer += 1
                    
    
    return answer