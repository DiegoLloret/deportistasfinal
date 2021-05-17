drop database deportistas;
create database deportistas;
use deportistas;



create table  deportes (
id_deporte int(2)  primary key not null auto_increment,
nombre varchar(50),
tipo  varchar(50)
);
create table equipos (
id_equipos int(4)  primary key not null auto_increment,
nombre varchar(45),
pais varchar(45)
);
create table deportista(
id_deportista int(6)  primary key not null auto_increment,
nombre varchar(50),
fecha_nacimiento date,
altura int(3),
nacionalidad char(20),
dorsal int(3),
deporte_jugado int(2),
equipo int(4),
FOREIGN KEY (equipo) REFERENCES equipos(id_equipos),
FOREIGN KEY (deporte_jugado) REFERENCES deportes(id_deporte)
);





insert into deportes (id_deporte,nombre,tipo)
values (1,'futbol','colectivo');
insert into deportes (id_deporte,nombre,tipo)
values (2,'baloncesto','colectivo');
insert into deportes (id_deporte,nombre,tipo)
values (3,'beisbol','colectivo');
insert into deportes (id_deporte,nombre,tipo)
values (4,'futbol americano','colectivo');
insert into deportes (id_deporte,nombre,tipo)
values (5,'tenis','individual');

insert into equipos (id_equipos,nombre,pais)
values (1,'Real madrid fc','españa');
insert into equipos (id_equipos,nombre,pais)
values (2,'Milwaukee Brewers','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (3,'Bayer de munich','alemania');
insert into equipos (id_equipos,nombre,pais)
values (4,'Golden state warriors','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (5,'Real madrid baloncesto','españa');
insert into equipos (id_equipos,nombre,pais)
values (6,'los angeles dodger','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (7,'psg','francia');
insert into equipos (id_equipos,nombre,pais)
values (8,'new orleans pelicans','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (9,'kansas city chief','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (10,' fc barcelona','españa');
insert into equipos (id_equipos,nombre,pais)
values (11,'valencia fc','españa');
insert into equipos (id_equipos,nombre,pais)
values (12,'movistar estudiantes','españa');
insert into equipos (id_equipos,nombre,pais)
values (13,'lakers','estados unidos');
insert into equipos (id_equipos,nombre,pais)
values (14,'estudiantes','argentina');

insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (1, 'Isco Alarcon','1992-04-21',176,'española',22,1,1);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (2, 'Christian Yelich','1992-12-05',193,'Estadounidense',22,3,2);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (3, 'Alphonso Davies','2000-11-02',180,'canadiense',19,1,3);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (4, 'Stephen Curry ','1988-03-14',191,'Estadounidense',30,2,4);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (5, 'Sergio Llull','1987-11-15',190,'española',23,2,5);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (6, 'Mookie Betts','1992-10-07',175,'Estadounidense',50,3,6);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (7, 'Neymar','1992-02-05',175,'brasileña',10,1,7);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (8, 'Zion Williamson','2000-07-06',198,'Estadounidense',1,2,8);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (9, 'Patrick Mahomes','1995-09-17',190,'Estadounidense',15,4,9);
insert into deportista (id_deportista,nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)
values (10, 'Javier Mascherano','1984-06-08',175,'Argentina',14,1,14);









update partidos
set fecha_partido= '2020-02-02'
where ID_partido=1;
update deportista
set equipo= 13
where id_deportista=4;

delete from deportista
where id_deportista = 10;
select nombre, pais from equipos;

select  * from deportista where nacionalidad ='española';
select *  from equipos where pais ='estados unidos';
select  * from deportes where tipo ='individual';
select  * from titulos where categoria ='colectivo';
DELIMITER |
CREATE PROCEDURE InsertarDeportista(
     IN nombre varchar(50),
    IN fecha_nacimiento date,
    IN altura int(3),
    in nacionalidad char(20),
    in dorsal int(3),
    in deporte_jugado varchar(50),
    in equipo varchar(50)

    )
BEGIN

declare iddeporte int;
declare idequipo int;
	select id_equipos into idequipo from equipos where equipos.nombre= equipo;
    select id_deporte into iddeporte from deportes where deportes.nombre= deporte_jugado;
    
    if iddeporte is not null

	THEN
    SET SQL_SAFE_UPDATES=0;
	insert into deportista (nombre,fecha_nacimiento,altura,nacionalidad,dorsal,deporte_jugado,equipo)  values(nombre,fecha_nacimiento,altura,nacionalidad,dorsal,iddeporte,idequipo);
    else 
		SIGNAL SQLSTATE '45000'
       SET MESSAGE_TEXT = 'El deporte o equipo introducido no existe en la base de datos';
    END IF ;
END  |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE ModificarDeportista(
     IN nombre varchar(50),
    IN fecha_nacimiento date,
    IN altura int(3),
    in nacionalidad char(20),
    in dorsal int(3),
    in deporte_jugado varchar(50),
    in equipo varchar(50)

    )
BEGIN

declare iddeporte int;
declare idequipo int; 
	select id_equipos into idequipo from equipos where equipos.nombre= equipo;
    select id_deporte into iddeporte from deportes where deportes.nombre= deporte_jugado;
  if idequipo is not null and iddeporte is not null

	THEN
    SET SQL_SAFE_UPDATES=0;
	update deportista set nombre=nombre,fecha_nacimiento=fecha_nacimiento,
    altura=altura,nacionalidad=nacionalidad,dorsal=dorsal,deporte_jugado=iddeporte,
    equipo=idequipo WHERE deportista.nombre=nombre;
    else 
		SIGNAL SQLSTATE '45000'
       SET MESSAGE_TEXT = 'El deporte o equipo introducido no existe en la base de datos';
    END IF ;
END  |
DELIMITER ;
select * from equipos;
    DELIMITER |
CREATE PROCEDURE ModificarDeporte(
     IN nombre varchar(50),
     In tipo varchar(50)
   

    )
BEGIN


	SET SQL_SAFE_UPDATES=0;
	update deportes set nombre=nombre,tipo=tipo where deportes.nombre=nombre;
   
END  |
DELIMITER ;
select * from deportes;
select * from equipos;
select * from deportista; 
