-- 총 누계거리 계산 후 concat으로 문자열로 만들었기 때문에 제대로 정렬x
select route, concat(round(sum(d_between_dist),1),'km') as total_distance, concat(round(avg(d_between_dist),2), 'km') as average_distance
from subway_distance
group by route
order by round(sum(d_between_dist),1) desc;
