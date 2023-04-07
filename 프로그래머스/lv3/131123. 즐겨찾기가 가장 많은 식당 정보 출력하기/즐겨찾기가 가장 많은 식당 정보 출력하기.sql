-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, favorites
FROM rest_info
WHERE
(food_type, favorites) in (
    select food_type, max(favorites)
    from rest_info group by food_type)
ORDER BY food_type DESC