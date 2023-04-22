-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, '%Y-%m-%d') AS date_of_birth
FROM member_profile
WHERE TLNO IS NOT NULL
AND Month(date_of_birth) = 3 AND gender ='W'
ORDER BY member_id 