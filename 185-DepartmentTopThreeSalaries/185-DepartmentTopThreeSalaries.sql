-- Last updated: 09/07/2026, 10:13:36
# Write your MySQL query statement below
SELECT 
    d.name AS Department, 
    e.name AS Employee, 
    e.salary AS Salary
FROM (
    SELECT 
        name, 
        salary, 
        departmentId,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) as salary_rank
    FROM Employee
) e
JOIN Department d ON e.departmentId = d.id
WHERE e.salary_rank <= 3;