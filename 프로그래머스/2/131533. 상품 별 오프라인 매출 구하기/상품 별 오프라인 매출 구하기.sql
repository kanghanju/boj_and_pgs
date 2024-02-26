-- 코드를 입력하세요
# SELECT p.PRODUCT_CODE, SUM(o.SALES_AMOUNT * p.PRICE) AS SALES
# FROM PRODUCT AS p 
# INNER JOIN OFFLINE_SALE AS o
# ON p.PRODUCT_ID = o.PRODUCT_ID
# GROUP BY PRODUCT_ID
# ORDER BY SALES DESC,p.PRODUCT_CODE;

SELECT PD.PRODUCT_CODE , SUM(PD.PRICE * OFF.SALES_AMOUNT) AS SALES 
FROM PRODUCT PD, OFFLINE_SALE OFF
WHERE PD.PRODUCT_ID = OFF.PRODUCT_ID
GROUP BY PD.PRODUCT_CODE
ORDER BY SALES DESC,PD.PRODUCT_CODE ASC;