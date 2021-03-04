--===========================================================================================================================================================
--===========================================================================��       ��======================================================================

-- ����Ŭ�� �����ϴ� �Լ��� ���� �˾ƺ���
-- ���ڿ� ó�� �Լ�
-- 1. LENGTH : ���ڿ��� ���̸� ��Ÿ���� �Լ�
-- ��� ���� : LENGTH(���ڿ�||�÷���) ���ڸ� ��ȯ
SELECT LENGTH('����3��') FROM DUAL;

SELECT LENGTH(EMAIL) FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=16;

-- LENGTHB(���ڿ� �Ǵ� �÷���) : ���ڿ� BYTEũ��
-- �ѱ��� 3BYTE�� ó����(EXPRESS ����) , ENTERPRISE ������ 2BYTE�� ó��
SELECT LENGTHB('������'), LENGTH('������'), LENGTHB('ABC')
FROM DUAL;
SELECT LENGTH(EMP_NAME), LENGTH(EMAIL)
FROM EMPLOYEE;

-- INSTR : ã�� ���ڿ�||�÷����� ������ ��ġ ~���� ~������ ���ڿ� �ε��� ��ȯ.
-- ������� : INSTR(��� ���ڿ�||�÷�, ã������[, ������ġ, Ƚ��]) 
-- ������ġ, Ƚ�� : ������ġ ���ڿ��� �˻��� �����Ͽ� Ƚ�� ��°�� ���ڿ��� �˻�
-- ������ġ, Ƚ�� ���� �� DEFAULT=1�� ó�� ��ġ�� �ϳ� ã���� ���� ��
-- Ƚ���� �ߺ� ���� ������ �� ��ȿ��
SELECT INSTR('KH����������','KH') FROM DUAL;
SELECT INSTR('KH���������� KH CLASS ȭ����','KH',4) FROM DUAL;
SELECT INSTR('KH���������� KH CLASS ȭ����','KH',1,2) FROM DUAL;
--������ġ�� ����(-)�� ��� �ڿ��� ���� ã�� == LASTINDEXOF
SELECT INSTR('KH���������� KH RCLASS ȭ���� KH�� ����','KH',-7,1) FROM DUAL; --��� 9

-- EMAIL���� @�� ��ġ�� ã�ƺ���
-- EMAIL���� �ι�° .�� ��ġ�� ã�ƺ���
SELECT INSTR(EMAIL,'@'), INSTR(EMAIL,'.',1,2)
FROM EMPLOYEE;


-- LPAD/RPAD
-- Ư�� ������ ������ ����� �� ������ Ư�����ڷ� ä��� �Լ�
-- LPAD/RPAD(����ڿ�, ��������[,Ư������])
-- �ѱ��� ���ڴ� 2���ڷ� �ν�
-- Ư������ �� ������ �������� ä������.
SELECT '�ȳ�',LPAD('�ȳ�',10) FROM DUAL; 
SELECT '�ȳ�',LPAD('�ȳ�',10,'#') FROM DUAL; 
SELECT '�ȳ�',RPAD('�ȳ�',10,'#') FROM DUAL; 
SELECT EMAIL, RPAD(EMAIL,16,'*') FROM EMPLOYEE;

-- LTRIM/RTRIM
-- ����, �������� ����, Ư�� ��ȣ�� �����ϴ� ��
-- LTRIM/RTRIM(�����||�÷�[,����)
-- �� ���� ã�� �� ���� ���ڰ� ��ġ�ϴ� ���ڰ� ������ �ʴ� ��� ���Ÿ� �����Ѵ�.
SELECT LTRIM('     SQL') FROM DUAL;
SELECT LTRIM('SSSSSSSQL','S') FROM DUAL;

-- �� ���ھ� ������ �� ��ġ�ϴ� �׸��� �ִ��� �� ('��''��''��')
-- �� ���� ��,��,�ٴ� ��� ���ŵǾ� ��µȴ�.
SELECT LTRIM('�����ٰ����ٰ����ٰ����ٶ���','������') FROM DUAL;
-- ������ ������ ����
SELECT RTRIM(LTRIM('�����ٰ����ٰ����ٰ����ٶ��󰡳��ٰ�����','������'),'������') FROM DUAL;

-- TRIM : ���ʿ� �ִ� �������, Ư������ ����
-- �ɼǿ� ���� ����, �����ʿ� Ư������, ������ ������ ���� ����
-- LTRIM/RTRIM�� �޸� �Ѱ� ���ڸ� ���Ű� �����ϴ�.
-- TRIM(����||�÷�)
-- TRIM('Ư������' FROM ���ڿ�||�÷���)
-- TRIM(LEADING 'Ư������' FROM ���ڿ�||�÷���) --����
-- TRIM(TRAILING 'Ư������' FROM ���ڿ�||�÷���) --������
-- TRIM(BOTH 'Ư������' FROM ���ڿ�||�÷���) -- ����
SELECT TRIM(' CHAN  ') FROM DUAL;
SELECT TRIM('K' FROM 'KKK CHAN KKK') FROM DUAL; --���� K����
SELECT TRIM(BOTH 'K' FROM 'KKK CHAN KKK') FROM DUAL; --���� K����
SELECT TRIM(LEADING 'K' FROM 'KKK CHAN KKK') FROM DUAL; --���� K����
SELECT TRIM(TRAILING 'K' FROM 'KKK CHAN KKK') FROM DUAL; --���� K����


-- SUBSTR : ���ϴ� ��ġ�� ���ڸ� �߶󳻴� ���
-- SUBSTR('���ڿ�'||�÷���,'�����ε���[,����])
-- ���̴� �����ε��� ���ڸ� ������ ���̴�.
SELECT SUBSTR('HELLO FUNCTION',6) FROM DUAL;
SELECT SUBSTR('HELLO FUNCTION',7,2) FROM DUAL;
SELECT SUBSTR('HELLO FUNCTION',-8,3) FROM DUAL; --�ڿ��� ����
SELECT SUBSTR('HELLO FUNCTION',INSTR('HELLO FUNCTION','F'),3) FROM DUAL;

--EMPLOYEE���̺��� ����� ���� ����ϱ�
SELECT SUBSTR(EMP_NAME,1,1) FROM EMPLOYEE;

-- EMPLOYEE���̺��� ���ڻ���� ����ϱ�
SELECT * FROM EMPLOYEE WHERE SUBSTR(EMP_NO,8,1)='1';

-- LOWER/UPPER/INITCAP
-- DB���� �� �� ��ҹ��� ���� �� ���
SELECT LOWER('Welcome to world') FROM DUAL;
SELECT LOWER('Welcome to world') FROM DUAL;
SELECT INITCAP('Welcome to world') FROM DUAL;

-- CONCAT (==||): ���ڿ� ����, ��ġ��
SELECT CONCAT('���ڿ���',' �����ش�.') FROM DUAL;
SELECT CONCAT(EMP_NAME, SALARY) FROM EMPLOYEE;

-- REPLACE : �÷�||���ڿ��� �����κ��� �����ϴ� �Լ�
-- REPLACE(����||�÷�, �����, ������ ����)
-- ��½ÿ��� ����Ǿ� ��µ� �� ���� �����Ͱ� ����Ǵ� ���� �ƴϴ�.
SELECT REPLACE('I LOVE YOU','LOVE','HATE') FROM DUAL;
SELECT REPLACE(EMAIL,'kh.or.kr','rclass.com') FROM EMPLOYEE;

--REVERSE : ��� ��������
SELECT REVERSE('I LOVE YOU') FROM DUAL;

--TRANSLATE : Ư�����ڸ� ������ ���ڷ� �ڵ����� �����ؼ� ������ִ� ���
SELECT TRANSLATE('010-1234-5678', '01012345678', '���Ͽ����̻�����ĥ��') FROM EMPLOYEE;

--EMPLOYEE���̺��� �����ȣ, �����, �ֹι�ȣ, ������ ��ȸ
-- �ֹι�ȣ�� ������ϸ� ����ϰ� �������� *�� ǥ��
SELECT EMP_ID, EMP_NAME, SUBSTR(EMP_NO,1,6)||'******', SALARY FROM EMPLOYEE;


-- �������ڿ����� �յ� ��� ���ڸ� �����ϼ���
-- '982341678934529HELLO89798739273402'


-- ����ó���Լ�
-- ABS : ���밪 ���
SELECT ABS(10),ABS(-10) FROM DUAL;

-- MOD : ���������� == %
-- MOD(����, ������) : �������� ��ȯ
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10,4) FROM DUAL;



-- �Ǽ�ó���Լ�
-- ROUND : �ݿø��ϴ� �Լ�
-- ROUND(�Ǽ�, �Ҽ����ڸ���) : �Ǽ��� �Ҽ��� �ڸ������� �ݿø��Ѵ�.
SELECT ROUND(126.456,2) FROM DUAL;

--FLOOR : �Ҽ��� �ڸ� ����
SELECT FLOOR(126.456) FROM DUAL;
SELECT FLOOR(SYSDATE-HIRE_DATE) FROM EMPLOYEE;

--TRUNC : ���ϴ� ��ġ�� �Ҽ��� �ڸ� ����
SELECT TRUNC(126.456,2) FROM DUAL;

--CEIL : ������ �ø�.
SELECT CEIL(126.456) FROM DUAL;



-- ��¥ó�� �Լ�
-- ��¥���� ������� -> ����(����)
-- ��¥�ϰ� ���ڸ� ������� -> ��¥(���ڸ�ŭ ���ڸ� ���)

-- SYSDATE : ���糯¥ ���
-- SYSTIMESTAMP : ���糯¥ �� �� �� �и������� ���
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MI:SS') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE,'HH:MI:SS') FROM DUAL;

-- ���� ���� ���� ����ϱ�
SELECT SYSDATE-1 AS ����,SYSDATE AS ����,SYSDATE+1 AS ���� FROM DUAL;
-- ������ ���
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) FROM DUAL;
-- ����� �Ի��� �� �Ѵ޵ڸ� ��ȸ�ϱ�
SELECT EMP_NAME, ADD_MONTHS(HIRE_DATE,1) FROM EMPLOYEE;

-- ��¥�� �������̸� ���Ϸ���
-- MONTHS_BETWEEN : �ΰ��� ��¥�� �޾Ƽ� �γ�¥�� ���������̸� ������ִ� �Լ�
SELECT MONTHS_BETWEEN(SYSDATE,ADD_MONTHS(SYSDATE,10)) FROM DUAL;

-- EMPLOYEE���̺��� ����� �����, �μ��ڵ�, �ٹ��������� ����Ͻÿ�
SELECT EMP_NAME, DEPT_CODE, FLOOR(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) FROM EMPLOYEE;

--NEXT_DAY : ���� ����� ���� ������ ��¥�� �����ִ� �Լ�
SELECT NEXT_DAY(SYSDATE,'��') FROM DUAL; -- LOCALE�� KOREA�̱⿡ �ѱ� �ν��� �Ѵ�.
SELECT * FROM V$NLS_PARAMETERS; -- LOCALE Ȯ�� ��ɾ� (NLS_ISO_CURRENCY -> KOREA�� �Ǿ��ִ�)

--LAST_DAY : �״��� ������ �� ���
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EXTRACT : ��, ��, ��, ��, ��, �ʸ� ���� ���������� ���� �� �ִ� �Լ�
-- EXTRACT(YEAR FROM DATE) : ���� ���ڷ� ��ȯ
-- EXTRACT(MONTH FROM DATE) : ���� ���ڷ� ��ȯ
-- EXTRACT(DAY FROM DATE) : ���� ���ڷ� ��ȯ
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;


-- �ú���
-- SYSDATE�δ� �ú��ʸ� ���� ���⿡ TIMESTAMP�� ĳ������ �ؾ� �ú��ʸ� �� �� �ִ�.
SELECT EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;
SELECT EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;
SELECT EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;


-- ����ȯ �Լ�
-- ����Ŭ���� ����ȯ �ڵ����� ���ִ� ��찡 ����
-- '00/01/01'
-- TO_CHAR : ����||��¥�� ���ڷ� �������ִ� �Լ�
-- TO_CHAR(��¥[,FORMAT]) : ��¥�� ���ڷ� ����
-- TO_CHAR(����[, FORMAT]) : ���ڸ� ���ڷ� ����

FORMAT
YYYY : �⵵ 4�ڸ�
YY : �⵵ 2�ڸ�
MONTH : ��, LOCALE ���缭 ���
MM : ���� ���ڷ�
DD : ��¥ ǥ��
D : ������ ���ڷ� ǥ��
DAY : ���� ǥ��
HH : �ð�
MI : ��
SS : ��

SELECT SYSDATE,TO_CHAR(SYSDATE,'YY-MM-DD HH:MI:SS') FROM DUAL;
--������̺��� �����, ����� (1990/2/20(ȭ)) ����ϱ�
SELECT EMP_NAME,TO_CHAR(HIRE_DATE,'YYYY/MM/DD(DY)') FROM EMPLOYEE;


-- ���ڸ� ���ڷ� �����ϱ�
-- 9 : �ش� �ڸ����� ���ڰ� ������ ǥ��, ������ ǥ�� ���� ����
-- 0 : �ش� �ڸ����� ���ڰ� ������ ǥ��, ������ 0���� ǥ��
SELECT TO_CHAR(1000000, '999,999,999') FROM DUAL;
SELECT TO_CHAR(1000000, '000,000,000') FROM DUAL;
SELECT TO_CHAR(1000000, '999,999,999.00') FROM DUAL;


-- �� ȭ���ȣ�� ǥ��
-- L : LOCALE�� ���� ���� �´� ��ȭ ǥ�ø� ������ش�.
SELECT TO_CHAR(1000000, 'L999,999,999') FROM DUAL;


-- TO_DATE : ����, ���ڿ� ��¥�������� �����ϴ� �Լ�
-- TO_DATE('���ڿ�','YYYMMDD') FROM DUAL;
-- �������¿��� ��¥�� ����ȯ�� ���� �Ǿտ� 0�� ����ϸ� �� �ȴ�.
SELECT TO_DATE('19921030','YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('19921030 10:52:22','YYYYMMDD HH:MI:SS'),'YYYY-MM-DD HH:MI:SS') FROM DUAL;


-- TO_NUMBER : ���ڿ��� �������·� �����ϴ� �Լ�, �ڵ� ����ȯ�� ���⿡ ����� ���� ���
 SELECT TO_NUMBER('1,000,000','999,999,999') FROM DUAL;
 
SELECT SYSDATE AS "�ȳ�", ADD_MONTHS(SYSDATE,18) AS "�߰�" FROM DUAL;
 
-- NULL ó���Լ�
-- NVL() : DATA���� NULL�϶� ��ü�ϴ� ���� ����
-- NVL2() : NVL2(DATA,NULL���� �ƴ� ���,NULL���� ���)
SELECT BONUS, NVL(BONUS,0) FROM EMPLOYEE;
SELECT (SALARY+SALARY*NVL(BONUS,0))*12 ���� FROM EMPLOYEE;
SELECT EMP_NAME,NVL(DEPT_CODE,'����')FROM EMPLOYEE;
SELECT BONUS, NVL2(BONUS,'�ִ�','����') FROM EMPLOYEE;


-- SELECT���� ���ǿ� ���� �б��غ���
-- DECODE�Լ� �̿��ϱ�
-- �ڹ��� SWITCH �����
-- DECODE(���ذ�, ����1,���1,����2,���2,...,���(DEFAULT - �ش� ���� ���� ���))
-- ���� �ķ��� ������ �� ����
SELECT EMP_NAME, EMP_NO,
DECODE(SUBSTR(EMP_NO,8,1),'1','����','2','����')
FROM EMPLOYEE;

--===========================================================================================================================================================
--===========================================================================================================================================================


-- CASE�� : ���ǿ� ���� �б� ó���Ǵ� �Լ�
-- CASE
--  WHEN ���� THEN ���౸��
--  WHEN ���� THEN ���౸��
--  ELSE
-- END;
SELECT EMP_NAME, EMP_NO,
    CASE 
     WHEN SUBSTR(EMP_NO,8,1)='1' THEN '����'
     WHEN SUBSTR(EMP_NO,8,1)='2' THEN '����'
     END AS ����
FROM EMPLOYEE;

SELECT EMP_NAME, EMP_NO,
    CASE
    WHEN SUBSTR(EMP_NO,8,1)='1' THEN '����'
    ELSE '����'
    END AS ����
FROM EMPLOYEE;

SELECT TO_NUMBER(EXTRACT(YEAR FROM SYSDATE))-TO_NUMBER(SUBSTR(EMP_NO,1,2))
FROM EMPLOYEE;


SELECT EMP_ID �����ȣ, EMP_NAME �����, 
CONCAT(SUBSTR(EMP_NO,1,8),'*******')AS �ֹι�ȣ,
    CASE WHEN SUBSTR(EMP_NO,8,1)='1' THEN '��' ELSE '��' END AS ����,
    EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'YY'))+1 AS "���糪��(YY)",
    EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))+1 AS "���糪��(RR)",
    TO_NUMBER(EXTRACT(YEAR FROM SYSDATE)) 
    - (TO_NUMBER(SUBSTR(EMP_NO,1,2))
         + CASE WHEN SUBSTR(EMP_NO,8,1) IN ('1','2') THEN 1900 ELSE 2000 END)+1 AS ���糪��
FROM EMPLOYEE;

-- �⵵�� ���ڸ��� ������ �� YY, RR���
-- �⵵�� �� �ڸ��� ������ �� YYYY, RRRR�� �����ϴ�
-- YY���� : ������ ���缼�⸦ �������� �����´�
-- 20 -> 2020��, 98 -> 2098��, 88 -> 2088��
-- RR���� : ���� �⵵�� �������� ���� �⵵ ���� ���ڰ� ũ�� �� ����� �����Ѵ�.


insert into KH.EMPLOYEE (EMP_ID,EMP_NAME,EMP_NO,EMAIL,PHONE,DEPT_CODE,JOB_CODE,SAL_LEVEL,SALARY,BONUS,MANAGER_ID,HIRE_DATE,ENT_DATE,ENT_YN) 
values ('250','��ι�','470808-2123341','go_dm@kh.or.kr',null,'D2','J2','S5',4480000,null,null,to_date('94/01/20','RR/MM/DD'),null,'N');



-- �׷��Լ�
-- ����� �Ѱ� ROW�� ��µǱ⿡ �÷��� �߰��� �� ����. 
-- (���� �ϳ��� �÷��� ��� ����)

-- SUM
SELECT SUM(SALARY) FROM EMPLOYEE;

-- ���ڻ���� �޿��� ������ ��ȸ�ϱ�
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';
--��ü ��� ������ ������ ���ϼ���. ���ʽ����� ������ 0���� ���
SELECT SUM(SALARY+SALARY*NVL(BONUS,0))*12
FROM EMPLOYEE;

-- AVG : �׷��� ����� ���ϴ� �Լ�
SELECT TO_CHAR(FLOOR(AVG(SALARY)), 'L999,999,999') AS ��ձ޿� -- ��Ī �ο��� �ڵ� ������ ����
FROM EMPLOYEE;

-- COUNT : �׷��� ROW���� ���ϴ� �Լ�
-- ��ü ������� ���ϼ���
SELECT COUNT(*)
FROM EMPLOYEE;

--�޿��� 300���� �̻�޴� ����� ��
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- COUNT(*||�÷���)
-- �÷��� �����Ϳ� NULL�� ������ �����ϰ� ī��Ʈ�Ѵ�.
SELECT COUNT(*), COUNT(BONUS)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- �׷��Լ��� �ѹ��� ����� ����
SELECT COUNT(*), SUM(SALARY), AVG(SALARY)
--SELECT DEPT_CODE, COUNT(*), SUM(SALARY), AVG(SALARY) --����, DEPT_CODE�� ����� ������ �̱� ������
FROM EMPLOYEE;

-- MAX/MIN
-- ���� �񱳴� �Ұ����ϸ� ����||��¥�� �����ϴ�.
-- ����� �޿��� ���� ���� ����� �޿�, ���� ���� ����� �޿�
SELECT MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE;

SELECT MAX(HIRE_DATE), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- GROUP BY
-- �ϳ��� Ư�� ������ �׷��� �ξ� ����Ѵ�.
-- FROM�� �ٷ� �ڿ��� ���
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--�μ��� ������� ��ȸ�ϼ���
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--���޺� �޿��հ�, ���, �ο����� ��ȸ�ϼ���
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY), COUNT(*) AS �ο���
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY AVG(SALARY) DESC;

-- ���� : ������ �ڷ� ����
SELECT JOB_CODE, COUNT(*), AVG(SALARY)
FROM EMPLOYEE
WHERE JOB_CODE != 'J1'
GROUP BY JOB_CODE;

SELECT EXTRACT(YEAR FROM HIRE_DATE) AS �Ի�⵵, COUNT(*) AS �ο�
FROM EMPLOYEE
WHERE JOB_CODE != 'J1'
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
ORDER BY EXTRACT(YEAR FROM HIRE_DATE);

SELECT DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��') AS ����, COUNT(*)
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��');


-- GROUP BY ������ �ټ��� �÷��� ���� �� ����
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE; -- �� �÷��� ��ġ�ϴ°� �ϳ��� �׷����� ������


--HAVING�� : �׷��Լ��� ���͸� �� �� �ְ� �ϴ°�
-- �׷��Լ��� ������ ROW�� ���͸��Ҷ� WHERE�� ������� ���ϰ�, HAVING���� ����ؾ� �Ѵ�.

-- �μ��� �޿� ����� 300�鸸�� �̻��� �μ����� �μ��ڵ�, �޿������ ��ȸ
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
-- WHERE AVG(SALARY)>=3000000 �׷��Լ��� WHERE���� �� �� ����. -> HAVING�� �ʿ�
GROUP BY DEPT_CODE
HAVING AVG(SALARY)>=3000000;

-- �μ��� �ο��� 3���� ���� �μ��� �ο����� ����ϼ���
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(*)>=3
ORDER BY 2 DESC;

SELECT DEPT_CODE, FLOOR(AVG(SALARY)) ���
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE
ORDER BY 1;