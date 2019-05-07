/*4) crear tabla*/
 create table Secuenciador (
  numERIC number,
  DATO varchar2(30)
);

/*5*/

INSERT INTO Secuenciador (NUMERIC, DATO) 
VALUES (3500, 'marcador1'); 

INSERT INTO Secuenciador (NUMERIC, DATO) 
VALUES (600, 'lapiz'); 
INSERT INTO Secuenciador (NUMERIC, DATO) 
VALUES (500, 'borrador1'); 


SELECT NUMERIC,DATO
FROM Secuenciador ; 
 
/*6*/
SELECT FNAME, LNAME
FROM DB2014.STAFF;

/*7*/

INSERT INTO DB2014.STAFF (FNAME, LNAME) 
VALUES ('pepito', 'perez'); 
INSERT INTO DB2014.STAFF (FNAME, LNAME) 
VALUES ('juanito', 'ford'); 
INSERT INTO DB2014.STAFF (FNAME, LNAME) 
VALUES ('bill', 'gates'); 
/*8*/

update Secuenciador set NUMERIC=456 ,DATO='marcador2';
 /*9*/

delete from Secuenciador
 where DATO='marcador1';

/*14*/
DECLARE i NUMBER;
BEGIN i := 0;
FOR i IN 1..1000000 LOOP
INSERT INTO secuenciador (id, texto) VALUES (i, DBMS_RANDOM.STRING ('p', 30));
END LOOP;
COMMIT;
END;

