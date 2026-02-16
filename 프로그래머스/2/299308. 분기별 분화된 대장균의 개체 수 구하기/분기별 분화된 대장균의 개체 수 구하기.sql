-- 코드를 작성해주세요
-- 각 분기(QUARTER)별 분화된 대장균의 개체의 총 수(ECOLI_COUNT)를 출력하는 SQL 문을 작성해주세요. -- 이때 각 분기에는 'Q' 를 붙이고 분기에 대해 오름차순으로 정렬해주세요. 대장균 개체가 분화되지 않은 분기는 없습니다.
SELECT CONCAT(QUARTER(DIFFERENTIATION_DATE),'Q')AS QUARTER,
       COUNT(*) AS ECOLI_COUNT
FROM ECOLI_DATA 
GROUP BY CONCAT(QUARTER(DIFFERENTIATION_DATE),'Q')
ORDER BY 1 
