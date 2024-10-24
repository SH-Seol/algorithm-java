--프로그래머스 sql select문 과일로 만든 아이스크림 고르기
SELECT FLAVOR
FROM FIRST_HALF
WHERE TOTAL_ORDER > 3000 AND FLAVOR IN (SELECT FLAVOR
                                        FROM ICECREAM_INFO
                                        WHERE INGREDIENT_TYPE = 'fruit_based')
ORDER BY TOTAL_ORDER DESC;
--다른 테이블에서도 조건을 걸어 조회를 해야하여 서브쿼리로 진행하였다.