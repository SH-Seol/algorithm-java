--프로그래머스 select문 3월에 태어난 여성 회원 목록 출력하기
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE DATE_OF_BIRTH LIKE '%03%' AND TLNO IS NOT NULL and GENDER = 'W'
ORDER BY MEMBER_ID;
--date_format을 유의하고, %M의 경우 영어로 월이, %D의 경우 16th 와 같은 표기법으로 나온다.
