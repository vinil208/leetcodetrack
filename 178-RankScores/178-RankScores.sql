-- Last updated: 09/07/2026, 10:13:49
# Write your MySQL query statement below
SELECT 
    score, 
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM 
    Scores;