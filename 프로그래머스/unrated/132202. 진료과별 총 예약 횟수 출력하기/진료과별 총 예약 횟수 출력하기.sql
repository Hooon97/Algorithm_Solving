-- 코드를 입력하세요
# SELECT mcdp_cd as '진료과 코드', COUNT(pt_no) as '5월예약건수'
# FROM appointment
# WHERE YEAR(apnt_ymd) = '2022' AND MONTH(apnt_ymd) = '05'
# GROUP BY mcdp_cd
# ORDER BY '5월예약건수', mcdp_cd

SELECT
MCDP_CD AS '진료과코드',
COUNT(MCDP_CD) AS '5월예약건수'
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%'
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD) ASC, MCDP_CD ASC