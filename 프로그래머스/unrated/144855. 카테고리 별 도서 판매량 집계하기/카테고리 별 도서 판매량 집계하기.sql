-- 코드를 입력하세요
SELECT b.category, SUM(bs.sales) as TOTAL_SALES
FROM book_sales as bs
JOIN book as b
ON bs.book_id = b.book_id
WHERE YEAR(bs.sales_date) = '2022' AND MONTH(bs.sales_date) = '01'
GROUP BY category
ORDER BY category