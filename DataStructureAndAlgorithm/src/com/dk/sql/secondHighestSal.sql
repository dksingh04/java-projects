/* Write your PL/SQL query statement below */
with temp_table as (Select SecondHighestSalary, rank from (Select Salary as SecondHighestSalary, dense_rank() over(order by Salary desc) rank from Employee) where rank = 2);

select COALESCE((select distinct SecondHighestSalary from temp_table where rank=2),null) as "SecondHighestSalary" from dual;
