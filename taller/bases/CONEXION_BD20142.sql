create table TBbase (
  id number,
  Nombre varchar2(30)
);

create table TBbaseAudit (
  Id number,
NombreNew varchar2(50),
NombreOld varchar2(50),
Fecha date,
Usuario varchar2(50),
Nombre varchar2(50)
);
drop table TBbaseAudit;
drop SEQUENCE SEQ_IDBaseAudit;

CREATE SEQUENCE SEQ_IDBase
INCREMENT BY 10
START WITH 5;

CREATE SEQUENCE SEQ_IDBaseAudit
INCREMENT BY 1 START WITH 1;

SELECT SEQ_IDBase.NEXTVAL FROM DUAL;
SELECT SEQ_IDBase.CURRVAL FROM DUAL;

SELECT SEQ_IDBaseAudit.NEXTVAL FROM DUAL;
SELECT SEQ_IDBaseAudit.CURRVAL FROM DUAL;

ALTER SEQUENCE SEQ_IDBaseAudit INCREMENT BY 30 MAXVALUE 888888 NOCACHE NOCYCLE;

Select * From USER_SEQUENCES;

INSERT INTO TBbase VALUES (SEQ_IDBase.NEXTVAL, 'Claudia Torres');

Select * From TBbase;



