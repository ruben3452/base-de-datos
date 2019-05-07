/* crear tabla*/
 create table Cuenta_de_la_republica (
  total_internacional number(19,0),
	total_nacional number(19,0),
	total_naturales number(19,0)
  );
/**/
/*internacional*/
select sum(v.MONTO)
from Valor_auxilios v;
/*nacional*/
select sum(mp.Monto_aportes)
from Entidad_nacional mp;
/*naturales*/
select sum(pn.Valor_recibido)
from Persona_natural pn;
/*agregacion de los datos */
INSERT INTO Cuenta_de_la_republica (total_internacional,TOTAL_NACIONAL,TOTAL_NATURALES) 
VALUES (571000000, 351000000,61000000); 
/*consulta de la cuenta de la republica*/
select total_internacional,TOTAL_NACIONAL,TOTAL_NATURALES
from Cuenta_de_la_republica;
/*actualizacion del registro de la tabla*/
update Cuenta_de_la_republica set total_internacional=570000000,TOTAL_NACIONAL=350000000,TOTAL_NATURALES=60000000;
/*eliminacion de un registro de la tabla*/
delete from Cuenta_de_la_republica
 where total_internacional=570000000;
 /**/