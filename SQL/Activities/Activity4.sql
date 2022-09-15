REM   Script: Activity4
REM   Activity4 - update table

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

