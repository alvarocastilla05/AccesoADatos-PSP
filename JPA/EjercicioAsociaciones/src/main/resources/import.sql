insert into equipo (id, nombre)
values (nextval('equipo_seq'), 'Petroleros FC');

insert into jugador (nombre,posicion, id, equipo_id)
values ('Neymar','Delantero Chulo', nextval('jugador_seq'), currval('equipo_seq'));