-- Last updated: 09/07/2026, 10:13:53
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  # Calculate the offset since LIMIT offsets are 0-indexed (e.g., 2nd highest means skipping 1 row)
  SET N = N - 1;
  
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary 
      FROM Employee 
      ORDER BY salary DESC 
      LIMIT 1 OFFSET N
  );
END