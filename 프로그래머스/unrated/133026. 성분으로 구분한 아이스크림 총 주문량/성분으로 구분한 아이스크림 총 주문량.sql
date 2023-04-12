-- 코드를 입력하세요
SELECT I.ingredient_type as ingredient_type, SUM(F.total_order) as TOTAL_ORDER
FROM first_half as F
JOIN icecream_info as I
ON F.flavor = I.flavor
GROUP BY ingredient_type
ORDER BY SUM(F.total_order)