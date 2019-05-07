/*vistas*/
/*eliminar vista*/
DROP VIEW damnificados_vista cascade constraints;

/*crear vista damnificados*/

CREATE VIEW  damnificados_vista AS
SELECT c.departamento,c.ciudad,tipo_catastrofe,c.fecha,n.Dirección,n.Teléfono,n.No_Grupo_familiar,n.Vivienda,n.Ubicación_actual
FROM Censo_damnificados c ,Familia_afectada n
WHERE c.No_familia_afectada= n.No_familia_afectada;


/*consular vista damnificados*/
select c.departamento,c.ciudad,tipo_catastrofe,c.fecha,n.Ciudad,n.Vivienda,n.Ubicación_actual
from damnificados_vista
WHERE c.No_familia_afectada= n.No_familia_afectada;





/*tegers - restricciones */
CREATE TABLE AUDITOR(
  d date,
  CURRENT_USER varchar2(255),
  type varchar2(30),
  name varchar2(30),
  sysevent varchar2(30));

create or replace TRIGGER "AUDIT_DDL_TRG"
AFTER DDL
ON DATABASE begin
insert into AUDITOR(
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

/**/


/*consultas*/
/*el valor de todos los auxilios de las entidades internacionales */
select *
from Valor_auxilios f,Entidadinternacional g
where f.id_entidad_internacional=g.id_entidad_internacional;

/*suma de todas la donaciones internacionales*/
select sum(v.MONTO)
from Valor_auxilios v;

/*lista de numbre de perosna de l a familia ciudad total grupo familiar y parentesco*/
select a.No_Grupo_familiar ,a.Dirección ,g.Ciudad,g.departamento,g.tipo_catastrofe
from Familia_afectada a, Censo_damnificados g
where a.No_Familia_afectada=g.No_Familia_afectada;

/**/

