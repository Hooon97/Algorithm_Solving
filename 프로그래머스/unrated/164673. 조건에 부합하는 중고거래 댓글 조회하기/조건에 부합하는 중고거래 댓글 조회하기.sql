-- 코드를 입력하세요
SELECT B.title, B.board_id, R.reply_id, R.writer_id, R.contents, 
date_format(R.created_date, '%Y-%m-%d') as created_date
FROM used_goods_board as B
JOIN used_goods_reply as R
ON B.board_id = R.board_id
WHERE B.created_date BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY R.created_date, B.title

# SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, "%Y-%m-%d") AS CREATED_DATE
# FROM USED_GOODS_REPLY AS R
# JOIN USED_GOODS_BOARD AS B ON R.BOARD_ID = B.BOARD_ID
# WHERE DATE_FORMAT(B.CREATED_DATE, "%Y-%m") = "2022-10"
# ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;