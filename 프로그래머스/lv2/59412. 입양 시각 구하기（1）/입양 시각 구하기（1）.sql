-- 코드를 입력하세요
SELECT Hour(datetime) as HOUR, COUNT(datetime) as COUNT
FROM animal_outs
GROUP BY HOUR(datetime)
HAVING HOUR >= 9 AND HOUR < 20
ORDER BY HOUR