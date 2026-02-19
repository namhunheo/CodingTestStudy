-- 코드를 입력하세요
SELECT i.REST_ID, i.REST_NAME,i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(r.review_score),2) as SCORE 
from rest_info i join rest_review r
on i.rest_id = r.rest_id
where i.address like '서울%'
group by i.rest_id, i.rest_name, i.FOOD_TYPE,
    i.favorites, 
    i.address
order by score desc, favorites desc;