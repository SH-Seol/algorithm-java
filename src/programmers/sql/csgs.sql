-- 프로그래머스 sql select문 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME ASC;

--여기서 알아야 할 내용은 DATE_FORMAT을 통해 2020-03-01-00:00:00 의 형식을 2020-03-01로 변경하였다는 점
-- MCDP_CD IN('CS', 'GS')로 해야 cs이거나 gs인 놈을 고른다는 점이다.