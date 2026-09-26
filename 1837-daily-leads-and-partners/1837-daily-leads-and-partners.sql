# Write your MySQL query statement below
SELECT 
    date_id,
    make_name,
    Count(Distinct lead_id) as unique_leads,
    count(Distinct partner_id) as unique_partners
from DailySales
group by date_id,make_name;