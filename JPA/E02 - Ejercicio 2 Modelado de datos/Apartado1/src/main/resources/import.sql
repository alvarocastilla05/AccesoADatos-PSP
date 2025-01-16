insert into categoria (id, nombre) values (nextval('categoria_seq'), 'Categoria 1');

insert into producto (nombre,precio_venta, id, categoria_id) values ('Botellín fresquito', 1.0, nextval('producto_seq'), currval('categoria_seq'));