-- Last updated: 09/07/2026, 10:13:40
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    c.name AS Customers
FROM 
    Customers c
LEFT JOIN 
    Orders o ON c.id = o.customerId
WHERE 
    o.id IS NULL;