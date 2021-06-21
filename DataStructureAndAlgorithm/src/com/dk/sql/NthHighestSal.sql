CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
   Select NthHighestSalary into result from (Select distinct Salary as NthHighestSalary, dense_rank() over(order by Salary desc) rank from Employee) where rank = N;

    RETURN result;
END;