-- 코드를 입력하세요
# SELECT LEFT(product_code, 2) as CATEGORY, COUNT(product_id) as PRODUCTS
# FROM product
# GROUP BY product_code
# ORDER BY category


SELECT left(PRODUCT_CODE,2) CATEGORY ,count(PRODUCT_ID)
from PRODUCT 
group by CATEGORY

order by CATEGORY