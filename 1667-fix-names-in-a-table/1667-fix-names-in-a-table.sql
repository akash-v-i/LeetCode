# Write your MySQL query statement below

SELECT user_id , CONCAT(Upper(SUBSTR(name,1,1)), Lower(SUBSTR(name,2)))
 as name FROM Users
 ORDER BY user_id;