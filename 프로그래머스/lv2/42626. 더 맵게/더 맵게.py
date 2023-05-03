import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    count=0
    
    while scoville[0]<K:
        temp = heapq.heappop(scoville)+(heapq.heappop(scoville)*2)       
        heapq.heappush(scoville,temp)
        count+=1
        
        if (len(scoville)==1 and scoville[0]<K):
            return -1
        
    return count