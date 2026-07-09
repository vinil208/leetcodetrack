-- Last updated: 09/07/2026, 10:13:56
# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT salary 
    FROM Employee 
    ORDER BY salary DESC 
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;