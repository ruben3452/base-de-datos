drop table Audit_emp cascade constraints;
/*5 */
   
CREATE TABLE AUDITORIA(
  d date,
  CURRENT_USER varchar2(255),
  type varchar2(30),
  name varchar2(30),
  sysevent varchar2(30));

create or replace TRIGGER "AUDIT_DDL_TRG"
AFTER DDL
ON DATABASE begin
insert into AUDITORIA(
d, 
current_user,
type,
name,
sysevent
)
values(
sysdate,
sys_context('USERENV','CURRENT_USER') ,
ora_dict_obj_type,
ora_dict_obj_name,
ora_sysevent
);
end;



/*7*/
SELECT *
FROM AUDITORIA;
/*8 -a*/
SELECT *
FROM catalog,suppliers;

/*b*/
SELECT e.eid ,c.ename,count (*)AS NOVECES
FROM employees c,certified e
where c.EID = e.EID
GROUP BY e.eid,c.ename
HAVING COUNT(*)=(SELECT MAX(NOVECES)
                  FROM (SELECT eid, COUNT (*) AS NOVECES
                        FROM employees
                        GROUP BY eid));
 
/*c*/
SELECT c.NAME,c.room, c.fid ,s.SNAME
FROM class c,student s ;
/*d*/
/*1*/
SELECT Age,SALARY,
SALARY+(SALARY*2.3)
FROM emp
where (AGE =(select min (AGE)  from emp))
;
/*2*/
SELECT Age,SALARY,
SALARY+(SALARY*0.5)
FROM emp
where (AGE>=21 AND 51>=AGE)
;
/*3*/

SELECT Age,SALARY,
SALARY+(SALARY*0.6)
FROM emp
where (51<=AGE)
;

/*E*/
SELECT distance,flno
FROM flights
;
/*f*/
DELETE FROM parts 
WHERE pid=1;

SELECT *
FROM parts;


/* G*/

UPDATE emp SET AGE= 30 WHERE EID=15645489;

/*h*/
/*322654189,'Lisa Walker'*/
delete from emp  WHERE EID=322654189;

