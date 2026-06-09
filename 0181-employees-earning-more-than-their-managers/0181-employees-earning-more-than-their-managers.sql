# Write your MySQL query statement below
SELECT e1.name as Employee FROM Employee as e1 JOIN Employee as e2
ON e1.managerId=e2.id WHERE e2.salary<e1.salary;