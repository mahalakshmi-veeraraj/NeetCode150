# Write your MySQL query statement below
SELECT teacher_id, COUNT(*) As cnt FROM(
    SELECT DISTINCT teacher_id, subject_id
    FROM
    Teacher
)AS x
GROUP BY teacher_id;