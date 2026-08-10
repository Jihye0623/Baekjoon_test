select i.item_id as ITEM_ID, i.item_name as ITEM_NAME, i.rarity as RARITY
from item_info i join item_tree t on i.item_id = t.item_id 
where parent_item_id in (select item_id from item_info where rarity='RARE')
order by 1 desc;