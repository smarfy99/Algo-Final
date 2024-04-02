-- 코드를 입력하세요
select ai.name as NAME, ai.datetime as DATETIME
from animal_ins ai left outer join animal_outs ao
on ai.animal_id = ao.animal_id
where ao.datetime is null
order by ai.datetime
limit 3;
