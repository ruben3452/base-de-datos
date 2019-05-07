/*2-3*/

CREATE USER usuario_Prueba
IDENTIFIED BY usuarioPrueba 
DEFAULT TABLESPACE USERS  QUOTA 10M ON USERS 
TEMPORARY TABLESPACE temp;

/*3*/
grant create session to usuario_Prueba 
/*eliminar usuario*/
DROP USER usuario_Prueba ;

/* 4 permiso crear tabla a usuario*/
grant create table to usuario_Prueba;

/*6*/

GRANT SELECT ON DB2014.STAFF TO usuario_Prueba;

/*7*/
GRANT SELECT, INSERT, UPDATE ON DB2014.STAFF TO usuario_Prueba;
/*10*/
GRANT SELECT ON usuario_Prueba.Secuenciador TO DB2014;
/*11-12*/
GRANT SELECT, INSERT, UPDATE ,DELETE ON usuario_Prueba.Secuenciador TO DB2014;