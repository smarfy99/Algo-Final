-- 물고기 길이가 10cm 이하일 경우 : length = null
select count(*) as FISH_COUNT, month(time) as MONTH
from fish_info
group by month(time)
having count(*) is not null
order by month(time)
