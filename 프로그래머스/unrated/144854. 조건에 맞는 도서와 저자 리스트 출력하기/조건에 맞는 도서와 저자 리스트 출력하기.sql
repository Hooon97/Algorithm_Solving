-- 코드를 입력하세요
SELECT B.book_id, A.author_name, DATE_FORMAT(B.published_date, '%Y-%m-%d') as published_date
FROM BOOK as B
JOIN AUTHOR as A
ON B.author_id = A.author_id AND B.category = '경제'
ORDER BY published_date
