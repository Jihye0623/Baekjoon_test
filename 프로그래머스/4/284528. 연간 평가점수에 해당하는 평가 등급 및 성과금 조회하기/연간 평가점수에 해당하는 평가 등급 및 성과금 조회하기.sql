-- 코드를 작성해주세요
-- 사원별 성과금 정보를 조회하려합니다. 
-- 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요.
-- 평가등급의 컬럼명은 GRADE로, 성과금의 컬럼명은 BONUS로 해주세요.
-- 결과는 사번 기준으로 오름차순 정렬해주세요.

SELECT EMP_NO, EMP_NAME, GRADE,
    (CASE
            WHEN GRADE='S' THEN SAL*0.2 
            WHEN GRADE='A' THEN SAL*0.15 
            WHEN GRADE='B' THEN SAL*0.1
            ELSE 0
      END) AS BONUS
FROM (SELECT E.EMP_NO, E.EMP_NAME, E.SAL ,
      (CASE
            WHEN AVG(SCORE)>=96 THEN 'S'
            WHEN AVG(SCORE)>=90 THEN 'A'
            WHEN AVG(SCORE)>=80 THEN 'B'
            ELSE 'C'
      END) AS GRADE
     FROM HR_EMPLOYEES E JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
     GROUP BY E.EMP_NO) T
ORDER BY 1