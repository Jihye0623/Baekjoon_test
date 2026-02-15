-- 코드를 작성해주세요
-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력하는 SQL 문을 작성해주세요. 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.

SELECT 
    YEAR(differentiation_date) as YEAR, 
    (MAX(size_of_colony) over(partition by YEAR(differentiation_date)) - size_of_colony) as YEAR_DEV,
    id
FROM ecoli_data e1
order by YEAR, YEAR_DEV