-- 입양 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
SELECT ao.animal_id, ao.name
from animal_ins ai right outer join animal_outs ao
on ai.animal_id = ao.animal_id
where ai.animal_id is null
order by ao.animal_id;
