SELECT B.ANIMAL_ID,B.NAME
FROM ANIMAL_OUTS AS B
JOIN ANIMAL_INS AS A
ON A.ANIMAL_ID=B.ANIMAL_ID
WHERE A.DATETIME>B.DATETIME
ORDER BY A.DATETIME

