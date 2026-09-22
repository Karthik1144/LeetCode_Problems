# Write your MySQL query statement below
Select 
    s.student_id,
    s.student_name,
    su.subject_name,
    Count(e.subject_name) as attended_exams 
from Students s
cross join Subjects su
left JOIN Examinations e
    on s.student_id = e.student_id
    and su.subject_name = e.subject_name
Group by 
    s.student_id,
    s.student_name,
    su.subject_name
Order by 
    s.student_id,
    su.subject_name;