SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT ORDER BY 2;
SELECT * FROM TAB;

--1.
UPDATE TB_CLASS SET CLASS_TYPE='�����ʼ�' WHERE DEPARTMENT_NO=001;
UPDATE TB_CLASS SET CLASS_TYPE='��������' WHERE DEPARTMENT_NO=002;
UPDATE TB_CLASS SET CLASS_TYPE='�����ʼ�' WHERE DEPARTMENT_NO=003;
UPDATE TB_CLASS SET CLASS_TYPE='���缱��' WHERE DEPARTMENT_NO=004;
UPDATE TB_CLASS SET CLASS_TYPE='��������' WHERE DEPARTMENT_NO=005;
SELECT * FROM TB_CLASS;

--2.
CREATE TABLE TB_�л��Ϲ����� 
AS SELECT STUDENT_NO AS �й�, STUDENT_NAME AS �л��̸�, STUDENT_ADDRESS AS �ּ�
FROM TB_STUDENT;
SELECT * FROM TB_�л��Ϲ�����;

--3. 
SELECT * FROM TB_STUDENT ORDER BY 2;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;

CREATE TABLE TB_������а�
AS SELECT STUDENT_NO AS �й�, STUDENT_NAME AS �л��̸�, SUBSTR(STUDENT_SSN,1,2) AS ����⵵, PROFESSOR_NAME AS �����̸�
FROM TB_STUDENT
LEFT JOIN TB_PROFESSOR ON COACH_PROFESSOR_NO = PROFESSOR_NO
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '������а�';

--4.


--5.
UPDATE TB_STUDENT SET STUDENT_ADDRESS='����� ���α� ���ε� 181-21' WHERE STUDENT_NO='A413042';
SELECT * FROM TB_STUDENT WHERE STUDENT_NO='A413042';

--6. 
UPDATE TB_STUDENT SET STUDENT_SSN=SUBSTR(STUDENT_SSN,1,6);
SELECT * FROM TB_STUDENT;

--7. 
SELECT * FROM TB_STUDENT;
SELECT * FROM TB_GRADE;

UPDATE TB_GRADE SET POINT=3.5 
WHERE STUDENT_NO=
(SELECT STUDENT_NO 
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE STUDENT_NAME='�����' AND DEPARTMENT_NAME='���а�')
        AND TERM_NO=200501;

SELECT * FROM TB_GRADE
WHERE STUDENT_NO=
(SELECT STUDENT_NO 
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE STUDENT_NAME='�����' AND DEPARTMENT_NAME='���а�')
        AND TERM_NO=200501;

--8. 
SELECT * FROM TB_GRADE WHERE STUDENT_NO='A445008';
SELECT * FROM TB_STUDENT;

DELETE FROM TB_GRADE
WHERE STUDENT_NO IN 
        (SELECT STUDENT_NO 
        FROM TB_STUDENT
        WHERE ABSENCE_YN='Y')