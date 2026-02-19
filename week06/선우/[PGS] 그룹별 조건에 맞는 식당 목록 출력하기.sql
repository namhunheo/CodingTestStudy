-- 코드를 입력하세요
SELECT m.member_name, r.review_text,
DATE_FORMAT(r.review_date, '%Y-%m-%d') AS review_date
 
from member_profile m join rest_review r on m.member_id = r.member_id
where m.member_id in (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(*) AS cnt
        FROM rest_review
        GROUP BY member_id
    ) t
)
    )
order by r.review_date asc, r.review_text asc;

