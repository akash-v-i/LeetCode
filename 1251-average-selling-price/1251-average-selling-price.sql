# Write your MySQL query statement below
SELECT p.product_id,ROUND(COALESCE(
    SUM(price * units) / SUM(units),
    0
),2)
as average_price
from Prices as p left join UnitsSold as u
on p.product_id=u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;