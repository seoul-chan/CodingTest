SELECT * FROM DBA_USERS; --���� �����ͺ��̽��� ��ϵ� ������ ��ȸ�ϴ� ��ɾ� (-- : �ּ� ó��)

-- �⺻���� ��ɾ �����Ϸ��� ��ɾ� �ۼ�LINE(SELECT * FROM DBA_USERS;)�� Ŀ���� ���� CTRL+ENTER;�� ������.
-- ��ɾ�� ���پ��� ���� �� �� �ִ�.

SELECT * FROM TAB; --���� ������ ��ϵǾ� �ִ� ���̺��� ��ȸ�ϴ� ��ɾ�

--������ �̿��� DBA_USERS, TAB, ROLE_SYS_PRIVS ���̺��� ����Ŭ�� �̿��ڿ��� DB�� ���� ������
-- �����ϱ� ���� ����� ���� ������ ���̺� -> DATA DICTIONARY

-- ����Ŭ�� �⺻������ DB�� �����ϴ� ������ �ڵ����� �ο��� ��.
-- 1. SYSTEM ���� : �Ϲݰ����� ���� -> ������ ���̽��� ����/���� �� ������ ����. ����� ������ ���, ���Ѻο� �� ����
-- 2. SYS(SYS AS SYSDBA) : ���۰����� ���� -> �����ͺ��̽��� �����ϰ�, ������ ������ �ְ�, ����ڰ����� ���, ���Ѻο� ���ҵ� ��

-- �⺻������ DB�� �̿��ϴ� ����� ������ ����ϰ� �̿��غ���
-- ����� ������ SYSTEM/SYS AS SYSDBA������ ����� ��
-- ����Ŭ DB�� �̿��Ϸ��� �ݵ�� ������ �־�� ��
-- CREATE : ������ �����ϴ� ��ɾ�
-- CREATE USER ������ IDENTIFIED BY ��й�ȣ
-- �������� ��ҹ��� �������� �ʰ�, ��й�ȣ�� ��ҹ��� ������ ��
CREATE USER KH IDENTIFIED BY KH;

SELECT * FROM DBA_USERS;

--���Ѻο��ϱ�
--GRANT : ����||��[ROLE] -> [����||ROLE],... TO ������;
--CONNECT(ROLE) : ������ DB�� ����(����)�� �� �ִ� ���� �ο�
GRANT CONNECT TO KH; --������ �� �ִ� ������ �ο�

-- ������ KH�������� ��ȸ�غ���
-- KH DB(����)�� ���� �� �Ʒ� ��ɾ� ����
SELECT * FROM TAB; --���� ���� ������ ������ �ִ� ���̺� ��ȸ

CREATE TABLE TEST1(
 NAME VARCHAR2(20)  -- ������ ������ �� �ִ� ���� Ȯ��
);                   -- SYSTEM���� ���̺� ���� ������ �ο����� �ʾұ⿡ KH�������� ���̺� ������ �� �� ����.
                    -- ���� SYSTEM�� �ο��� �ϸ� �� �� �ִ�.
-- ���̺�(���� ���� : �����͸� ������ �� �ִ�)�� ������ �� �ִ� ������ �ο��Ǿ���.
--RESOURCE (ROLE)�� �ο� : ���̺��� �����ϰ� �̿��� �� �ִ� ������ �ִ� ROLE;

--DBA�� �̵�
GRANT RESOURCE TO KH; --KH�� ���̺� ���� ���� �ο�

-- KH�� �̵�
-- KH DB�� ���� �������� ������ �����⿡ �α� �ƿ� �� �ٽ� �����ؾ� �ο��� ������ ������� �� �ִ�.
-- �ٽ� ���� �� �Ʒ� ��ɼ� �����ϸ� ���̺� ������ �ȴ�.
CREATE TABLE TEST1(
 NAME VARCHAR2(20)  
);

DROP TABLE TEST1; -- ���̺� ����� ��ɾ�

-- TEST/TEST ���� ���� �� ���̺� �����
CREATE USER TEST IDENTIFIED BY TEST;
GRANT CONNECT,RESOURCE TO TEST;
CREATE TABLE TEST(
 NAME VARCHAR2(20)
);
SELECT * FROM TEST;

-- DATA DICTIONARY ���̺� ����
SELECT * FROM DICT; --�����ڰ���, ����ڰ����� �̿�

--�ܺ� SQL�� ���� KH DB�� ���̺� �߰� �۾��� ����Ǿ���
--KH���� Ȱ���� ��񳻿� Ȯ��
SELECT * FROM EMPLOYEE;
DESC EMPLOYEE; --����� �÷� Ȯ��
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
SELECT * FROM LOCATION;
SELECT * FROM NATIONAL;
SELECT * FROM SAL_GRADE;


-- �⺻ SELECT�� Ȱ���ϱ�
-- SELECT����� ���ϴ� �÷���[, �÷���...]
-- FROM ���̺�

SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE FROM EMPLOYEE;
-- SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, TEST <-- ���� �÷��� �ۼ� �� ���� �߻�


----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------


--EMPLOYEE ���̺��� ��ü �÷��� ��ȸ�ϱ�
DESC EMPLOYEE;

-- ���̺� �ִ� ��ü �÷��� �ҷ��ö��� ���ϵ�ī��(*)
SELECT * FROM employee;

-- RESULT SET���� ROW(DATA) ���͸�(���ϴ� ���ǿ� �´� �����͸� ����������) WHERE���----------------------------------WHERE-------------------------
-- ���͸��� ���ϴ� ��쿡�� WHERE�� ����ϸ� �ȴ�.
-- SELECT �÷���, �÷���, �÷��� ... FROM ���̺�� [WHERE ���ǽ�(==,!=,>,<)]
SELECT * FROM employee WHERE SALARY>=3000000; --���� 300�� �̻��� �����͸� ���

--DB������ ��κ��� �͵��� SELECT���ȿ��� �̷���� -> �Լ�����, �������
--SELECT������ ��� �����ϱ� -> +,-,*,/
SELECT 10+20,10-50,2/5,20*40 FROM DUAL; --10,20 : ���ͷ�, DUAL : ORACLE�� �����ϴ� �׽�Ʈ�� ���̺�, ������ ������ ����� �� �� �ִ�.

-- DB������ �ڷ��� ���� ���� ���ڴ� ��� ���������� ����Ѵ�.
-- ��������� ���ͷ��� �����Ѱ� �ƴϴ�. �÷����� ������ ó���� ������.
-- �������ÿ��� �ڷ����� NUMBERŸ���̾�� �Ѵ�.
-- ���� : NUMBER (����,�Ǽ� ����X)
-- ���ڿ� : VARCHAR2, CHAR
-- ��¥ : DATE

--�÷�, ���ͷ� ��������ϱ�
-- NULL���� ����ó���� ���� �ʴ´�.
SELECT SALARY, SALARY+2000000 FROM EMPLOYEE;
SELECT SALARY, BONUS,SALARY*BONUS FROM EMPLOYEE; --BOUNS�� NULL�� �����ʹ� ����� NULL�� ��� ��

-- EMPLOYEE���̺��� �� ����� ������ ��ȸ����
-- EMP_NAME, EMP_NO, DEPT_CODE, SALARY, ����
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, SALARY*12 FROM EMPLOYEE;

-- ���ʽ��� �߰��� �ݾ����� ����غ���.(����+���ʽ��ݾ�)*12
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, (SALARY+BONUS)*12 FROM EMPLOYEE;

-- ����Ŭ���� ''�� ���ڿ� ���ͷ� ǥ��
SELECT '20'+30 FROM DUAL; --�ڵ� ����ȯ���� ���� ����
SELECT '�̽�'+30 FROM DUAL; --����, ����Ŭ�� +���� �� ��� ���ڷ� ����(<->�ڹٴ� ���ڿ� ����)


--RESTULSET �÷����� �����ϱ� -> �÷��� ��Ī�ο�
-- ����� ���ϴ� �÷��� ��Ī���� ��µǵ��� �Ѵ�.
-- �÷��� AS ������ �÷��̸� || �÷��� ������ �÷���
SELECT EMP_NAME �����, PHONE ��ȭ��ȣ, EMAIL �̸���, SALARY*12 AS ���� FROM EMPLOYEE;
SELECT EMP_NAME AS �����, PHONE AS ��ȭ��ȣ, EMAIL AS �̸���, SALARY*12 AS ���� FROM EMPLOYEE;

--����� ��Ī�ο��� �ν�,��ȣ() �� Ư����ȣ�� ����� �Ұ��ϱ⿡
-- ��� �� ""�� �����ָ� �ȴ�.
SELECT EMP_NAME AS "�� �� ��", SALARY AS "����(��)", SALARY*12 AS ���� FROM EMPLOYEE; 

-- �÷� �ۼ� ��ġ�� ���ͷ� ��� �� ��� ���� ���ͷ� �߰�
SELECT EMP_NAME, '��', '100' FROM EMPLOYEE;

-- DISTINCT : �÷��� �ִ� �ߺ����� �����ϰ� ����ϴ� �����(������)
-- SELECT���� �Ѱ��� ����� �����ϴ�.
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE,JOB_CODE FROM EMPLOYEE; --���ÿ� �ߺ��� �͸� ����
SELECT DISTINCT DEPT_CODE, DISTINCT JOB_CODE FROM EMPLOYEE; --����

-- || : ���Ῥ����, �÷�||�÷�, �÷��� �÷� �Ǵ� �÷��� ���ͷ��� ����
SELECT '�����'||'������'||'�ݿ���' FROM DUAL; --�ϳ��� �÷����� ���
SELECT EMP_NAME||'��',SALARY||'��' FROM EMPLOYEE; 

SELECT EMP_NAME || '�� ������' ||
SALARY || '�� �Դϴ�.'
FROM EMPLOYEE;


-- �� ������
-- ����񱳿��� : =
SELECT * FROM EMPLOYEE WHERE EMP_NAME='������';

--EMPLOYEE ���̺��� DEPT_CODE D5�� ����� ��ü �÷� ��ȸ
--200���� �̻� ������ �޴� ��� ��ȸ
-- JOB_CODE�� J5�� �ƴ� ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D5';
--�� ������
SELECT * FROM EMPLOYEE WHERE SALARY>2000000;

-- ���� ������
SELECT * FROM EMPLOYEE WHERE JOB_CODE!='J5';
SELECT * FROM EMPLOYEE WHERE JOB_CODE<>'J5';
SELECT * FROM EMPLOYEE WHERE JOB_CODE^='J5';

--RESULT SET�� ��(���ͷ�)���� ��ҹ��ڸ� �����Ѵ�. �� �� ��ɾ� �Է� �� ���� �Է��� ��ҹ��� ���� X

--������ �����ϱ� : AND, OR, NOT
--EMPLOYEE���̺��� DEPT_CODE D5�̸鼭 SALARYRHK 300�鸸�� �̻��� ���.
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D5' AND SALARY>=3000000;

--EMPLOYEE���̺��� DEPT_CODE�� D5�̰ų� D6�� ����� �̸�, �޿� �μ��ڵ带 ��ȸ
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME,SALARY,DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';

-- NOT
-- �μ��ڵ尡 D5�� �ƴ� ����� ��ȸ�ϼ���
SELECT * FROM EMPLOYEE WHERE NOT DEPT_CODE='D5';
SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE NOT (SALARY>=3000000 AND SALARY<=5000000);



-- ORACLE���� �����ϴ� �񱳿�����
-- BETWEEN AND -> Ư�������� ��ȸ�� �� ����ϴ� ������
-- �÷��� BETWEEN �� AND �� �Ǵ� ��<=�÷��� AND ��>=�÷���
SELECT EMP_NAME, DEPT_CODE,SALARY FROM EMPLOYEE 
-- WHERE SALARY BETWEEN 3000000 AND 5000000;
WHERE SALARY NOT BETWEEN 3000000 AND 5000000; --������ ������ �ƴ�

-- ������ ���ϰų� ��Һ񱳸� �Ҷ� ��¥ ���� �����ϴ�.
-- ������� 00/01/01 ������ �Ի��� ����� �̸�, �μ�, ����� ������
DESC EMPLOYEE;
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE FROM EMPLOYEE
WHERE HIRE_DATE <'00/01/01';

-- ������� 90/01/01���� 01/01/01/���� �Ի��� ����� �̸�,�μ�,����� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE 
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- LIKE : Ư�� ������ ���ڰ��� ��ȸ�ϴ� ���
-- SELECT �÷��� FROM ���̺�� WHERE �÷��� LIKE ����;

-- ���ϵ� ī�带 ����ؼ� ��ȸ %,_��ȣ
-- % : 0�� �̻��� ������ ���� (0�� ����)
 -- LIKE '%�ȳ�' -> �ȳ�(O), �Ͼȳ�(O) ,�ƾƾƾƾȳ�(O), �� ��(X) -> �ȳ����� ������ ���ڿ�
 -- LIKE 'ȫ%' : ȫ���� �����ϴ� ���ڿ�
 -- LIKE '%��%' : ���� �����ϰ� �ִ� ���ڿ�
 
-- _ : 1���� ������ ���� ǥ��
 -- LIKE '_�ȳ�' ; �ȳ�(X) �Ͼȳ�(O) 1�ȳ�(O) -> �ȳ����� ������ 3���� ���ڿ�!!!
 -- LIKE '___' : 3���� ���ڿ�
 -- LIKE '_��_' : ��� ���� �����ϴ� 3���� ���ڿ�

-- �ΰ��� ������ �� ����
 -- LIKE '%�ȳ�_' -> �ȳ����� ������ �ѱ��� �� �ִ� ���ڿ�
 -- LIKE '_��_%' -> 3���� �̻� �ι�°���ڰ� �� �� ���ڿ�
 -- LIKE '_��%' -> 2���� �̻� �ι�°���ڰ� �� �� ���ڿ�

-- ���� ���� ���� ����� ��ȸ�ϱ� �����, �μ��ڵ�, �޿�
SELECT EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '��_%';

-- ����̸� ��ü�� �̰� ���Ե� ����� ��ȸ ��ü�÷�
SELECT * FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMAIL �� _���� 3�ڸ��� ������ ��ȸ
-- ESCAPE������ ����� �ؼ� ����ؾ� �ϸ� ���ϴµ��� ����� �� ����
SELECT * FROM EMPLOYEE
--WHERE EMAIL LIKE '___^_%' ESCAPE '^';
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--�̾��� �ƴ� ����� ��ü �÷��� ��ȸ�غ���.
SELECT * 
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '��_%';

-- NULL�� ã�ƺ���.
-- NULL���� �ƹ� �ǹ̾��� �������� ����ó���� ���� ����
-- WHERE BONUS = NULL;  ����ó���� ���� �ʱ⿡ ã�� �� ����
-- IS NULL : �÷��� �ִ� NULL���� ��ȸ�ϴ� ������
-- IS NOT NULL : �÷��� �ִ� NULL�� �ƴ� ���� ��ȸ�ϴ� ������
SELECT *
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- �μ��� ������ �ȵ� ����� �̸�, �̸��� ��ȭ��ȣ�� ��ȸ�ϼ���
SELECT EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- IN / NOT IN : ���� �����
-- ������ ���������� ���� �� ���
-- DEPT_CODE D5 �Ǵ� �̰ų� D6�� ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE IN ('D5','D6'); -- ,���� OR�� ����
WHERE DEPT_CODE NOT IN('D5','D6');

-- ����� ��å�ڵ尡 J7 �Ǵ� J2�̰�, �޿��� 200�鸸�� �̻��� ����� �̸�, �޿�, �μ��ڵ带 ��ȸ
-- ������ �켱������ ���� AND�� ���� ����Ǳ⿡ ()�� ����Ͽ���.
SELECT EMP_NAME,SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>2000000;

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

-- ������ ��������
-- ORDER BY : ����, �������� ���� -> �÷��� �������� �����Ѵ�.
-- ���� : ���� �� -> ū �� ASC �������� / ū�� -> ���� �� DESC ��������
-- ���ڿ� : ������ �� -> �� ASC / ������ �� -> �� DESC
-- ��¥ : ������ -> ������¥ ASC / ���� ��¥ -> ���� ��¥ DESC

-- ORDER BY �÷��� ���ı���(ASC/DESC)
-- ��� ���� : SELECT �÷���, �÷���... FROM ���̺� �� [WHERE] [ORDER BY �÷��� ���ı���]
-- ORDER BY������ SELECT���� �� �������� �ۼ��ϸ� ASC/DESC�� �����ϸ� �⺻������ �������� ������ �Ѵ�.
-- NULL�� ASC->�� �Ʒ�, DESC->�� ���� ���ĵȴ�.

SELECT * FROM EMPLOYEE ORDER BY EMP_NAME ASC;
SELECT * FROM EMPLOYEE ORDER BY DEPT_CODE, EMP_NAME DESC; -- DEPT_CODE���� ASC���� �� ���� �� EMP_NAME DESC ����

--DEPT_CODE D5�� ��� �� ������ ���� �޴� ��������� ��ü �÷� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5'
ORDER BY SALARY DESC;

-- NULLS �ɼ� : ���� �� NULL ���� ��ġ�� ���� �� �ִ�.
SELECT DEPT_CODE, EMP_NAME
FROM EMPLOYEE
--ORDER BY DEPT_CODE NULLS FIRST;
ORDER BY DEPT_CODE DESC NULLS LAST;

-- ORDER BY ������ �÷��� ���� �ε����� �������� ������ �� �ִ�. (�ε����� 1���� ����)
SELECT EMP_NAME, DEPT_CODE, SALARY, EMAIL
FROM EMPLOYEE
ORDER BY 2;

-- ORDER BY �������� �÷��� �ο��� ��Ī���ε� �̿��� �� �ִ�.
-- FROM -> WHERE -> SELECT -> ORDER BY ������ ������ �ȴ�
-- ��Ī�� �ο��Ǳ� ���� WHERE���� ����Ǳ⿡ WHERE�� ��Ī ����� �Ұ��������� ORDER BY���� �������� ����Ǳ⿡ ��Ī ����� �����ϴ�.
SELECT EMP_NAME, (SALARY+(SALARY*BONUS))*12 AS ����
FROM EMPLOYEE
WHERE (SALARY+(SALARY*BONUS))*12>=40000000
ORDER BY ���� DESC;