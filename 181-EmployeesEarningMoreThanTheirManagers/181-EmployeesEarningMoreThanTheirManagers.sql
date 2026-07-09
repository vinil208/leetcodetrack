-- Last updated: 09/07/2026, 10:13:44
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    e.name AS Employee
FROM 
    Employee e
JOIN 
    Employee m ON e.managerId = m.id
WHERE 
    e.salary > m.salary;