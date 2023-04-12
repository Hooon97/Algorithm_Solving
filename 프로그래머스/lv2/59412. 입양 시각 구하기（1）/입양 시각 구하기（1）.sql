-- 코드를 입력하세요
SELECT HOUR(A.datetime) as HOUR, COUNT(animal_id) as COUNT
FROM animal_outs as A
GROUP BY HOUR(A.datetime)
HAVING HOUR BETWEEN 9 AND 19
ORDER BY HOUR(A.datetime)