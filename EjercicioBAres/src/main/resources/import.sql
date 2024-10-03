insert into bar(id, nombre, direccion, latitud, longitud, descripcion, url_imagen) values (1, 'Cervecería Urbión', 'Calle Urbión', 10, 10, 'Buenas Cervezas','cerveceria.jpg');
insert into tag(tag_id, nombre) values (1, 'para tapear');
insert into tag(tag_id, nombre) values (2, 'para comer');
insert into bar_tag(bar_id, tag_id) values (1, 1);