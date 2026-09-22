# Write your MySQL query statement below
Select v.customer_id , COUNT(*) AS count_no_trans
FROM Visits v
left join Transactions t
on v.visit_id = t .visit_id 
where t.visit_id is null
group by v.customer_id