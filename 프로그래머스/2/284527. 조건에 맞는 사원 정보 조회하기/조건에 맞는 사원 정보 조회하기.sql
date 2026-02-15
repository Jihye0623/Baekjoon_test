-- 코드를 작성해주세요
-- HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블에서 
-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 
-- 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회
-- 2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 SCORE로 해주세요.

SELECT 
    SUM(G.SCORE) AS SCORE,  
    E.EMP_NO, 
    E.EMP_NAME, 
    E.POSITION, 
    E.EMAIL
FROM HR_EMPLOYEES E JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
WHERE G.YEAR = 2022
GROUP BY E.EMP_NO
ORDER BY SCORE DESC
LIMIT 1
