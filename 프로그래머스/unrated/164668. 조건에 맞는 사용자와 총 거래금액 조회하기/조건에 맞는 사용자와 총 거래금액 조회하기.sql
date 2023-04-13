-- 코드를 입력하세요
SELECT U.user_id, U.nickname, SUM(B.price) as TOTAL_SALES
FROM used_goods_user as U
JOIN used_goods_board as B
ON B.writer_id = U.user_id AND B.status = 'DONE'
GROUP BY U.user_id
HAVING SUM(B.price) >= 700000
ORDER BY SUM(B.price)