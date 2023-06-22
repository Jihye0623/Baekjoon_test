def solution(progresses, speeds):
    answer = []
    
    while len(progresses)>0:
        done=0
      
        for i in range(len(progresses)):
            progresses[i]=progresses[i]+speeds[i]

              
        for j in range(len(progresses)):
            if progresses[0]>=100:
                done=done+1
                del progresses[0]
                del speeds[0]
            else:
                break
        
        
        if done>0:
            answer.append(done)
        
    return answer