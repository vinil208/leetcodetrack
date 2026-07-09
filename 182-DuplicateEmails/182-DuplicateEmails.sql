-- Last updated: 09/07/2026, 10:13:42
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    email AS Email
FROM 
    Person
GROUP BY 
    email
HAVING 
    COUNT(email) > 1;