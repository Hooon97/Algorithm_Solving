-- 코드를 입력하세요
SELECT first_half.FLAVOR 
FROM first_half, icecream_info
WHERE first_half.flavor = icecream_info.flavor AND
first_half.total_order > 3000 
AND icecream_info.ingredient_type = 'fruit_based' 
ORDER BY first_half.total_order DESC
