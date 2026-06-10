# Write your MySQL query statement below
SELECT class from Courses GROUP BY class Having count(*)>4;