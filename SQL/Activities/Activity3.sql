REM   Script: Activity3
REM   Activity3 - select with where clause

SELECT salesman_id, salesman_city  
FROM salesman;

SELECT * FROM salesman  
WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman  
WHERE SALESMAN_NAME =' Paul Adam';

