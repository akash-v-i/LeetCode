# Write your MySQL query statement below
SELECT MAX(b.num) as num
FROM(
    SELECT a.num
    FROM MyNumbers as a
    GROUP BY a.num
    HAVING COUNT(a.num)=1 
) as b;