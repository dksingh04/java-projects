/*
   Write a SQL query to find all duplicate emails in a table named Person.

   +----+---------+
   | Id | Email   |
   +----+---------+
   | 1  | a@b.com |
   | 2  | c@d.com |
   | 3  | a@b.com |
   +----+---------+
   For example, your query should return the following for the above table:

   +---------+
   | Email   |
   +---------+
   | a@b.com |
   +---------+
*/

/*Select Email from (Select Email, max(rank) as max_rank from
(Select Email, row_number()
    over(partition by Email order by Email) rank from Person) group by Email) where max_rank != 1;
*/
Select Email from Person group by Email having count(Email) > 1
