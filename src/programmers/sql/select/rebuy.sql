--프로그래머스 재구매가 일어난 상품과 회원 리스트 구하기
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
--group by를 하면 요소별로 그룹화하고 몇번 발생했는지 카운트를 한다. 따라서 count를 통해 해당 회수를 계산하여 중복을 검출한다.