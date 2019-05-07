SELECT UPPER(FNAME)||' '||UPPER(LNAME) AS "NOMBRES Y APELLIDOS"
FROM STAFF
ORDER BY LNAME DESC;
/**1)****************************************************************************/
SELECT PRI.FNAME,PRI.LNAME,PRO.STREET,PRO.CITY,PRO.TYPE
FROM PRIVATEOWNER PRI, PROPERTYFORRENT PRO
WHERE PRI.OWNERNO= PRO.OWNERNO
ORDER BY PRI.FNAME;

/**2)**************************************************************************/
SELECT PRI.FNAME,PRI.LNAME,PRO.STREET,PRO.CITY,PRO.TYPE
FROM PRIVATEOWNER PRI 
     JOIN PROPERTYFORRENT PRO ON (PRI.OWNERNO = PRO.OWNERNO)
ORDER BY PRI.FNAME DESC;

/**3)******************************************************************************/

SELECT FNAME, LNAME
FROM STAFF
WHERE SALARY= (SELECT MAX(SALARY)
FROM STAFF);

/**4)******************************************************************************/
SELECT C.CLIENTNO,C.FNAME,C.LNAME,COUNT (*) AS NOVECES
FROM VIEWING V, CLIENT C
WHERE V.CLIENTNO = C.CLIENTNO
GROUP BY C.CLIENTNO,C.FNAME,C.LNAME
HAVING COUNT(*)=(SELECT MAX(NOVECES)
                  FROM (SELECT CLIENTNO, COUNT (*) AS NOVECES
                        FROM VIEWING
                        GROUP BY CLIENTNO));
/******5)************************************************************************/
SELECT PROPERTYNO,(RENT*12)
FROM LEASE;

/****6)***************************************************************************/
SELECT L.PROPERTYNO,L.RENT, C.CLIENTNO,C.MAXRENT
FROM  PROPERTYFORRENT L , CLIENT C
WHERE L.RENT <= C.MAXRENT;
/***7)***************************************************************************/

SELECT P.PROPERTYNO,P.STREET,P.CITY,COUNT (*) AS NOVECES
FROM VIEWING V, PROPERTYFORRENT P
WHERE V.PROPERTYNO = P.PROPERTYNO
GROUP BY P.PROPERTYNO,P.STREET,P.CITY
HAVING COUNT(*)=(SELECT MAX(NOVECES)
                  FROM (SELECT PROPERTYNO, COUNT (*) AS NOVECES
                        FROM VIEWING
                        GROUP BY PROPERTYNO));
               
                        
/*8)****************************************************************************/

SELECT PROPERTYNO,CLIENTNO,RENT,(RENT*DURATION)
FROM  LEASE  ;
/*9)***************************************************************************/


