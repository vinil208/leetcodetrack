-- Last updated: 09/07/2026, 10:14:00
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    p.firstName, 
    p.lastName, 
    a.city, 
    a.state
FROM 
    Person p
LEFT JOIN 
    Address a ON p.personId = a.personId;