-- 코드를 입력하세요
SELECT RI.rest_id, RI.rest_name, RI.food_type, 
RI.favorites, RI.address, ROUND(AVG(RR.review_score), 2) as score
FROM rest_info as RI
JOIN rest_review as RR ON RI.rest_id = RR.rest_id
GROUP BY RI.rest_id
HAVING RI.address LIKE '서울%'
ORDER BY score DESC, RI.favorites DESC
