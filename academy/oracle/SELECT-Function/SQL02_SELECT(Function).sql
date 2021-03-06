CREATE USER HOME IDENTIFIED BY HOME;
GRANT CONNECT TO HOME;
GRANT RESOURCE TO HOME;
SELECT * FROM TAB;
SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;

--1. 
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, TO_CHAR(ENTRANCE_DATE,'YYYY-MM-DD') 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO='002'
ORDER BY 입학년도;

--2. 
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

--3.    다시 풀기
SELECT PROFESSOR_NAME AS 교수이름,EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(PROFESSOR_SSN,1,2),'RR'))+1 AS 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN,8,1)='1'
ORDER BY EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(PROFESSOR_SSN,1,2),'RR'))+1;

--4.
SELECT SUBSTR(PROFESSOR_NAME,2,3) AS 이름
FROM TB_PROFESSOR;

--5.    -- 다시 하기
SELECT *, DECODE TO_NUMBER(STRSUB(STUDENT_SSN,2,1))<=TO_NUMBER(STRSUB(ENTRANCE_DATE,2,1)),'2',STUDENT_NO
FROM TB_STUDENT;

--6.
SELECT TO_CHAR(TO_DATE('20201225','YYYYMMDD'),'DAY') FROM DUAL;

--7. 
-- YY : 무조건 현재 년도를 의미
-- 99 -> 2099년 , 49 -> 2049년
SELECT TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') FROM DUAL;
-- RR : 값에 따라 년도가 달라짐
-- 99 -> 1999년 , 49 -> 2049년
SELECT TO_DATE('99/10/11','RR/MM/DD'), TO_DATE('49/10/11','RR/MM/DD') FROM DUAL;

--8.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO,1,1)!='A';

--9.
SELECT ROUND(AVG(POINT),1) AS 평점
FROM TB_GRADE
WHERE STUDENT_NO='A517178'
GROUP BY STUDENT_NO;

-- 10.
SELECT DEPARTMENT_NO, COUNT(*)
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

--11.
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

--12.
SELECT SUBSTR(TERM_NO,1,4) AS 년도, ROUND(AVG(POINT),1)
FROM TB_GRADE
WHERE STUDENT_NO='A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY 년도;

--13.   --다시
SELECT DEPARTMENT_NO, COUNT(*)
FROM TB_STUDENT
WHERE ABSENCE_YN='Y'
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;


--14.
SELECT STUDENT_NAME AS 동명이름,COUNT(*) AS "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*)>=2
ORDER BY STUDENT_NAME;

--15.
