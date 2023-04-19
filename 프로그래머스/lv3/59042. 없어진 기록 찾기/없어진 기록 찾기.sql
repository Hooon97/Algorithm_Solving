-- 코드를 입력하세요
SELECT outs.animal_id as animal_id, outs.name as name
FROM animal_ins as ins
RIGHT OUTER JOIN animal_outs as outs
ON ins.animal_id = outs.animal_id
WHERE ins.animal_id IS NULL
ORDER BY outs.animal_id