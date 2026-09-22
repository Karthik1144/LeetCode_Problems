# Write your MySQL query statement below
Select 
    r.contest_id,
    Round(Count(r.user_id)*100.0/(select count(*) from Users),2) as percentage
from Register r
group by r.contest_id
order by percentage desc , r.contest_id ;