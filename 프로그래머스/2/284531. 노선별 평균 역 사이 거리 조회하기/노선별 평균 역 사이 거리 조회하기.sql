-- 코드를 작성해주세요
-- 노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성해주세요.
-- 총 누계거리는 테이블 내 존재하는 역들의 역 사이 거리의 총 합을 뜻합니다. 
-- 결과는 총 누계 거리를 기준으로 내림차순 정렬해주세요.

select 
    ROUTE, 
    concat(round(sum(D_BETWEEN_DIST),1),'km') as TOTAL_DISTANCE, 
    concat(round(avg(D_BETWEEN_DIST),2),'km') as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
order by round(sum(D_BETWEEN_DIST),1) desc