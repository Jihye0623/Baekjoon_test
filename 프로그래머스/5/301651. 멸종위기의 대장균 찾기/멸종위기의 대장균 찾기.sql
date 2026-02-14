with recursive generations as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.generation+1
    from ecoli_data e
    inner join generations g
    on e.parent_id = g.id
)

select count(*) as count, g.generation
from generations g
where not exists(
select 1
from ecoli_data child
where child.parent_id = g.id)
group by g.generation
order by g.generation