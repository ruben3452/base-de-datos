/*crear tabla para el nuevo usuario*/

CREATE USER usuario
IDENTIFIED BY usuario
DEFAULT TABLESPACE USERS  QUOTA 10M ON USERS 
TEMPORARY TABLESPACE temp;

/*crear sesion para el usuario*/
grant create session to usuario ;
/*eliminar usuario*/
DROP USER usuario;

/*  permiso crear tabla a usuario*/
grant create table to usuario;

