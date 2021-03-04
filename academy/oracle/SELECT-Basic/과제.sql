1. JOB���̺��� JOB_NAME�� ������ ��µǵ��� �Ͻÿ�
SELECT JOB_NAME FROM JOB;

2. DEPARTMENT���̺��� ���� ��ü�� ����ϴ� SELECT���� �ۼ��Ͻÿ�
SELECT * FROM DEPARTMENT;

3. EMPLOYEE ���̺��� �̸�(EMP_NAME),�̸���(EMAIL),��ȭ��ȣ(PHONE),�����(HIRE_DATE)�� ����Ͻÿ�
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE ;

4. EMPLOYEE ���̺��� �����(HIRE_DATE) �̸�(EMP_NAME),����(SALARY)�� ����Ͻÿ�
SELECT HIRE_DATE, EMP_NAME, SALARY FROM EMPLOYEE;

5. EMPLOYEE ���̺��� ����(SALARY)�� 2,500,000���̻��� ����� EMP_NAME �� SAL_LEVEL�� ����Ͻÿ� 
SELECT EMP_NAME, SAL_LEVEL FROM EMPLOYEE WHERE SALARY>=2500000;

6. EMPLOYEE ���̺��� ����(SALARY)�� 350���� �̻��̸鼭 
    JOB_CODE�� 'J3' �� ����� �̸�(EMP_NAME)�� ��ȭ��ȣ(PHONE)�� ����Ͻÿ�
SELECT EMP_NAME, SAL_LEVEL FROM EMPLOYEE WHERE SALARY>=2500000;

1. EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ�����), �Ǽ��ɾ�(�� ���ɾ�-(����*���� 3%))�� ��µǵ��� �Ͻÿ�
  BONUS�� NULL�� ����� NULL�� ���
SELECT EMP_NAME AS �̸�, SALARY*12 AS ����, 
(SALARY*12)*(1+(BONUS/100)) AS �Ѽ��ɾ�, ((SALARY*12)*(1+(BONUS/100))-(SALARY*(1-(3/100)))) AS �Ǽ��ɾ�
FROM EMPLOYEE;
WHERE SALARY>=2500000;

2. EMPLOYEE ���̺��� �̸�, �ٹ� �ϼ�(�Ի����� �����ΰ�)�� ����غ��ÿ�.

SELECT EMP_NAME AS �̸�, SYSDATE-HIRE_DATE AS �ٹ��ϼ�
FROM EMPLOYEE;

3. EMPLOYEE ���̺��� 20�� �̻� �ټ����� �̸�,����,���ʽ����� ����Ͻÿ�
SELECT EMP_NAME AS �̸�, SALARY AS ����, BONUS AS ���ʽ���
FROM EMPLOYEE
WHERE SYSDATE-HIRE_DATE >=7300;

�μ� �ڵ尡 D6 �̰� �޿��� 2000000���� ���� �޴� ������ �̸�, �μ��ڵ�,�޿� ��ȸ
SELECT EMP_NAME AS �̸�, DEPT_CODE AS �μ��ڵ�, SALARY AS �޿�
FROM EMPLOYEE
WHERE DEPT_CODE='D6' AND SALARY>=2000000;

�μ��ڵ尡 D6�� �ƴ� �����ȸ
SELECT *
FROM EMPLOYEE
WHERE NOT DEPT_CODE='D6';

�����ڵ尡 J1�� �ƴ� ������� ���޵��(sal_level)�� �ߺ����� ����ϼ���.
SELECT DISTINCT SAL_LEVEL
FROM EMPLOYEE
WHERE NOT DEPT_CODE='J1';

EMPLOYEE ���̺��� ������� 90/01/01 ~ 01/01/01 �� ����� ��ü ������ ����Ͻÿ�
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE >'90/01/01' AND HIRE_DATE <'01/01/01';

�̸� ��� ���ڰ� '��'�� ��� ��ȸ(�̸��� ��� 3������)
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_��_';

EMAIL _���� 4������ ����� �̸� �̸����� ��ȸ�ϼ���
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____\_%' ESCAPE '\';

1. EMPLOYEE ���̺��� �̸� ���� ������ ������ ����� �̸��� ����Ͻÿ�
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ����Ͻÿ�
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

3. EMPLOYEE ���̺��� �����ּ� '_'�� ���� 4���̸鼭, DEPT_CODE�� D9 �Ǵ� D6�̰�
  ������� 90/01/01 ~ 00/12/01�̸鼭, ������ 270������ ����� ��ü ������ ����Ͻÿ� 
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____\_%' ESCAPE '\' AND DEPT_CODE='D9' OR DEPT_CODE='D6'
AND HIRE_DATE>'90/01/01' AND HIRE_DATE<'00/12/01';  
  �μ� ��ġ�� ���� �ʾ����� ���ʽ��� �����ϴ� ���� ��ȸ 
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;
  
  �����ڵ� ���� �μ� ��ġ�� ���� ���� ���� �̸� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IN NULL;