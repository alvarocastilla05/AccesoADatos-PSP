insert into categoria (id, nombre)
values (nextval('categoria_seq'), 'Categoria 1');

insert into producto (descripcion,nombre,precio, id, categoria_id)
values ('Lorem ipsum dolor sit amet','Botellín fresquito', 1.0, nextval('producto_seq'), currval('categoria_seq'));