-- 상품 별로 중복되지 않는 8자리 상품코드 값 가짐
-- 앞 2자리는 카테고리 코드
select truncate(price,-4) as PRICE_GROUP, count(*) as PRODUCTS
from product
group by price_group
order by price_group
