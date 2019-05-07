/*borrar tablas*/
drop table banco cascade constraints;
drop table Contralor�a cascade constraints;
drop table cuenta cascade constraints;
drop table donacion cascade constraints;
drop table Entidadinternacional cascade constraints;
drop table Valor_auxilios cascade constraints;
drop table Entidad_nacional cascade constraints;
drop table Persona_natural cascade constraints;
drop table Cr�dito cascade constraints;
drop table Asignaci�n_presupuestal cascade constraints;
drop table empresa cascade constraints;
drop table Censo_damnificados cascade constraints;
drop table Familia_afectada cascade constraints;
drop table Grupo_familiar cascade constraints;
drop table da�os_materiales cascade constraints;



/*creacion de tablas basandonos en  el modelado de bases de datos */
create table banco(
	No_cuentas number(19,0),
  creditos number(19,0) 	
	);
  
 
 create table Contralor�a(
	Donaciones_recibidas_exterior number(9,0),
	Donaciones_recibidas_bancarias number(9,0),
	Auxilios_otorgados  number(9,0),
  creditos number(9,0),
  Valor_cuenta_gobierno number(9,0)	
	);
  
 create table cuenta(
	saldo_total number(19,0),
	consignaciones_realisadas number(19,0)
	
	);
  
  create table donacion(
	id_entidad_internacional number(19,0),
/*  check (id_entidad_internacional is not null),*/
  valor_internacional number(19,0),
  check (valor_internacional>=0),
	id_entidad_nacional number(19,0),
/*  check (id_entidad_nacional is not null),*/
  valor_nacional number(19,0),
  check (valor_nacional>=0),
	No_personas_naturales number(19,0),
  /*check (id_entidad_natural is not null),*/
  valor_personas_naturales number(19,0),
  check (valor_personas_naturales>=0),
  Fecha varchar2(20),
  primary key(id_entidad_internacional,id_entidad_nacional,No_personas_naturales)
	);

create table Entidadinternacional(
	id_entidad_internacional number(19,0) primary key,
  Pa�s varchar2(30),
	Tipo_entidad varchar2(25),
	Valor_auxilios number(20,0),
  Direcci�n varchar2(20),
  Tel�fono number(10),
  CHECK (Tel�fono BETWEEN 0000000 and 9999999999),
  nombre varchar2(20)	
  
  /*foreign key(id_entidad_internacional) references Aportes */
	);

create table Valor_auxilios(
	id_entidad_internacional number(19,0)primary key,
	Monto number(20,0),
  Fecha_consignaci�n varchar2(20)
 /* foreign key(id_entidad_internacional) references Entidadinternacional(id_entidad_internacional)*/
  );


create table Entidad_nacional(
	Id_entidad_nacional number(19,0) primary key,
  Nombre varchar2(30),
	Responsable varchar2(25),
	Monto_aportes number(20,0),
  Tel�fono number(10),
  CHECK (Tel�fono BETWEEN 0000000 and 9999999999)
	);

create table Persona_natural(
	
  Numero_cuenta number(19,0) ,
  Tipo_cuenta varchar2(30),
	Entidad varchar2(25),
	Valor number(20,0)

	);

create table Cr�dito(
	Cr�ditoNo number(19,0),
  Id_entidad number(19,0) ,
  Entidad varchar2(30),	
	Monto_credito number(20,0),
  Plazo_meses varchar2(20),
  Responsable varchar2(20),
  Tel�fono number(13,0),
  CHECK (Tel�fono BETWEEN 0000000 and 9999999999),
  Tasa_interes number(3,0),
  CHECK (Tasa_interes BETWEEN 1 and 99),
  Meses_de_gracia varchar2(20),	
  No_Asignaci�n_presupuestal number(13,0),
  primary key(No_Asignaci�n_presupuestal,Cr�ditoNo,Id_entidad)
  
	);

create table Asignaci�n_presupuestal(
  No_Asignaci�n_presupuestal number(19,0) primary key,
  Fecha_asignaci�n varchar2(30),	
  Persona_responsable varchar2(20),
  Tel�fono number(10),
  CHECK (Tel�fono BETWEEN 0000000 and 9999999999),
  Descripci�n_obra varchar2(20),	
  Valor_asignado number(20,0)
	 
  );
  
  
 create table empresa(
  Censo_damnificados_No number(19,0) primary key	,
	informe_contraloria  varchar2(30)
  );
  

  
create table Censo_damnificados(
	Censo_damnificados_No number(19,0) primary key,
  departamento varchar2(30),	
  ciudad varchar2(20),
  tipo_catastrofe varchar2(20),
  fecha varchar2(20), 
  No_familia_afectada varchar2(20) primary key
	);


create table Familia_afectada(
  No_Familia_afectada number(19,0) primary key,
  Direcci�n varchar2(20),
  Tel�fono number(10),
  CHECK (Tel�fono BETWEEN 0000000 and 9999999999),
  Ciudad varchar2(20),	
  No_Grupo_familiar number(19,0) ,
  vivienda varchar2(20),
  Ubicaci�n_actual varchar2(20),
  Da�os_materiales varchar2(20)
	);
  
create table da�os_materiales(
  casa varchar2(5),
  apartamento varchar2(5),
  electrodomesticos varchar2(5),	
  finca varchar2(5),
  empresa varchar2(5),
  enseres varchar2(5),
  objetos_personales varchar2(5)
	);
  
create table Grupo_familiar(
	No_Grupo_familiar number(19,0),
  Nombre varchar2(30),	
  Cedula number(19,0) ,
  Parentesco varchar2(20),
  Fecha_nacimiento varchar2(20),
  Estado_civil varchar2(20),	
  Ocupaci�n varchar2(20),
  primary key(No_Grupo_familiar)
	);



/*creacion de bases de datos con poblacion de datos para las tablas*/
/**/
Insert Into banco (No_cuentas,creditos) values (458974256,487512365);
Insert Into cuenta (saldo_total,consignaciones_realisadas) values (571000000,3);
Insert Into donacion (id_entidad_internacional,valor_internacional,id_entidad_nacional,valor_nacional,No_personas_naturales,valor_personas_naturales,fecha) values (487515673,100000000,654649451,100000000,5456982,30000000,'20/06/2002');
Insert Into Entidadinternacional (id_entidad_internacional,Pa�s,Tipo_entidad ,Valor_auxilios,Direcci�n,Tel�fono,nombre) values (487515673,'estados unidos','ong',100000000,'washintos av ',10024587,'onu');
Insert Into Valor_auxilios (id_entidad_internacional,Monto,Fecha_consignaci�n) values (487515673,100000000,'20/06/2002');
Insert Into Entidad_nacional (Id_entidad_nacional,Nombre,Responsable,Monto_aportes,Tel�fono) values (654649451,'postobon','ardila',100000000,2154898);
Insert Into Persona_natural (Numero_cuenta,Tipo_cuenta,Entidad ,Valor) values (4587925,'ahorros','bancolombia',30000000);
Insert Into Cr�dito (Cr�ditoNo,Id_entidad,Entidad ,Monto_credito,Plazo_meses,Responsable,Tel�fono ,Tasa_interes,Meses_de_gracia,No_Asignaci�n_presupuestal) values (487512365,458741656,'banco de la republica',84000000,'10 mese','daniel',2155896,0.2,'2 meses',4567821456);
Insert Into Asignaci�n_presupuestal (No_Asignaci�n_presupuestal,Fecha_asignaci�n,Persona_responsable,Tel�fono,Descripci�n_obra,Valor_asignado) values (4567821456,'15/07/2002','juan',2134586,'recostrucion calles',84000000);
Insert Into empresa (Censo_damnificados_No,informe_contraloria) values (51135593,'informe20');
Insert Into Censo_damnificados (Censo_damnificados_No,departamento,ciudad,tipo_catastrofe,fecha, No_familia_afectada) values (51135593,'quindio','armenia','terremoto','21/06/2002',2345);
Insert Into Familia_afectada (No_Familia_afectada,Direcci�n,Tel�fono,Ciudad,No_Grupo_familiar,Vivienda,Ubicaci�n_actual,Da�os_materiales) values (2345,'calle 34 n 4-56',2114569,'armenia',4,'casa','albergue','rajaduras');
Insert Into Grupo_familiar (No_Grupo_familiar,Nombre,Cedula,Parentesco,Fecha_nacimiento,Estado_civil,Ocupaci�n) values (4,'pepe',9356426,'padre','21/07/1956','casado','vendedor');
Insert Into da�os_materiales(casa,apartamento,electrodomesticos,finca,empresa,enseres,objetos_personales )values('si','no','si','no','no','no','si');
/**/
Insert Into banco (No_cuentas,creditos) values (458974256,487512345);
Insert Into cuenta (saldo_total,consignaciones_realisadas) values (351000000,3);
Insert Into donacion (id_entidad_internacional,valor_internacional,id_entidad_nacional,valor_nacional,No_personas_naturales,valor_personas_naturales,fecha) values (487515645,110000000,654649481,110000000,5456972,120000000,'21/07/2002');
Insert Into Entidadinternacional (id_entidad_internacional,Pa�s,Tipo_entidad ,Valor_auxilios,Direcci�n,Tel�fono,nombre) values (487515645,'europa','empresa',110000000,'calle 456 av napol ',4569875,'ea');
Insert Into Valor_auxilios (id_entidad_internacional,Monto,Fecha_consignaci�n) values (487515645,110000000,'21/07/2002');
Insert Into Entidad_nacional (Id_entidad_nacional,Nombre,Responsable,Monto_aportes,Tel�fono) values (654649481,'colombina','jaime',120000000,21584569);
Insert Into Persona_natural (Numero_cuenta,Tipo_cuenta,Entidad ,Valor) values (4587236,'ahorros','avvillas',20000000);
Insert Into Cr�dito (Cr�ditoNo,Id_entidad,Entidad ,Monto_credito,Plazo_meses,Responsable,Tel�fono ,Tasa_interes,Meses_de_gracia,No_Asignaci�n_presupuestal) values (487512345,458741656,'banco de la republica',94000000,'10 mese','diego',2155721,0.2,'2 meses',4567821458);
Insert Into Asignaci�n_presupuestal (No_Asignaci�n_presupuestal,Fecha_asignaci�n,Persona_responsable,Tel�fono,Descripci�n_obra,Valor_asignado) values (4567821458,'16/08/2002','gonsaga',2134578,'recostrucion puentes',94000000);
Insert Into empresa (Censo_damnificados_No,informe_contraloria) values (51135594,'informe21');
Insert Into Censo_damnificados (Censo_damnificados_No,departamento,ciudad,tipo_catastrofe,fecha, No_familia_afectada) values (51135594,'quindio','armenia','terremoto','21/06/2002',2346);
Insert Into Familia_afectada (No_Familia_afectada,Direcci�n,Tel�fono,Ciudad,No_Grupo_familiar,Vivienda,Ubicaci�n_actual,Da�os_materiales) values (2346,'calle 80 n 7-96',21145856,'armenia',5,'apartamento','albergue','derumbe');
Insert Into Grupo_familiar (No_Grupo_familiar,Nombre,Cedula,Parentesco,Fecha_nacimiento,Estado_civil,Ocupaci�n) values (5,'jaime',9354589,'padre','21/07/1956','casado','abogado');
Insert Into da�os_materiales(casa,apartamento,electrodomesticos,finca,empresa,enseres,objetos_personales )values('si','no','si','si','no','no','si');
/**/
Insert Into banco (No_cuentas,creditos) values (458974256,587512345);
Insert Into cuenta (saldo_total,consignaciones_realisadas) values (61000000,3);
Insert Into donacion (id_entidad_internacional,valor_internacional,id_entidad_nacional,valor_nacional,No_personas_naturales,valor_personas_naturales,fecha) values (767515645,180000000,414649481,180000000,6356972,130000000,'23/07/2002');
Insert Into Entidadinternacional (id_entidad_internacional,Pa�s,Tipo_entidad ,Valor_auxilios,Direcci�n,Tel�fono,nombre) values (767515645,'asia','empresa',180000000,'kijanshi va shi ',4569100,'netsof');
Insert Into Valor_auxilios (id_entidad_internacional,Monto,Fecha_consignaci�n) values (767515645,180000000,'23/07/2002');
Insert Into Entidad_nacional (Id_entidad_nacional,Nombre,Responsable,Monto_aportes,Tel�fono) values (414649481,'comapam','erika',130000000,21684569);
Insert Into Persona_natural (Numero_cuenta,Tipo_cuenta,Entidad ,Valor) values (3587236,'ahorros','avvillas',10000000);
Insert Into Cr�dito (Cr�ditoNo,Id_entidad,Entidad ,Monto_credito,Plazo_meses,Responsable,Tel�fono ,Tasa_interes,Meses_de_gracia,No_Asignaci�n_presupuestal) values (587512345,658741656,'banco de la republica',64000000,'10 mese','diego',2155731,0.2,'2 meses',4567821459);
Insert Into Asignaci�n_presupuestal (No_Asignaci�n_presupuestal,Fecha_asignaci�n,Persona_responsable,Tel�fono,Descripci�n_obra,Valor_asignado) values (4567821459,'16/09/2002','juan',2134578,'recostrucion postes',64000000);
Insert Into empresa(Censo_damnificados_No,informe_contraloria) values (51135495,'informe22');
Insert Into Censo_damnificados (Censo_damnificados_No,departamento,ciudad,tipo_catastrofe,fecha, No_familia_afectada) values (51135495,'quindio','armenia','terremoto','21/06/2002',2347);
Insert Into Familia_afectada (No_Familia_afectada,Direcci�n,Tel�fono,Ciudad,No_Grupo_familiar,Vivienda,Ubicaci�n_actual,Da�os_materiales) values (2347,'calle 60 n 9-36',21145812,'armenia',4,'apartamento','albergue','derumbe');
Insert Into Grupo_familiar (No_Grupo_familiar,Nombre,Cedula,Parentesco,Fecha_nacimiento,Estado_civil,Ocupaci�n) values (4,'julian',9354589,'padre','21/07/1956','casado','ingeniero');
Insert Into da�os_materiales(casa,apartamento,electrodomesticos,finca,empresa,enseres,objetos_personales )values('si','no','si','si','si','no','si');



