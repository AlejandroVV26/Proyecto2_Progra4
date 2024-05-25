DROP DATABASE Proyecto;
CREATE DATABASE Proyecto;
USE Proyecto;

create table Usuario (
	id varchar(100) not null,
	contrasena varchar(100) not null,
	tipo varchar(100),
	acceso boolean not null,
	PRIMARY KEY(id)
);

create table Proveedor (
	id varchar(100) not null,
	nombre varchar(100) not null,
	apellido varchar(100) not null,
	telefono varchar(100),
	correo varchar(100),
	PRIMARY KEY (id)
);

create table Cliente (
	id varchar(100) not null,
	nombre varchar(100) not null,
	apellido varchar(100) not null,
	telefono varchar(100),
	correo varchar(100),
	direccion varchar(100),
	tipo varchar(100),
	PRIMARY KEY (id)
);

create table Producto (
	id varchar(20) not null,
	categoria varchar(100) not null,
	descripcion varchar(100) not null,
	unidad_medida varchar(50) not null,
	costo double,
	PRIMARY KEY(id)
);

create table Factura (
	id integer not null,
	id_usuario varchar(100) not null,
	cliente_id varchar(100) not null,
	costo_total double,
	PRIMARY KEY(id)
);

create table FacturaProducto (
	id_factura integer not null,
	id_producto varchar(20) not null
);

create table ProveedorCliente (
	id_proveedor varchar(100) not null,
	id_cliente varchar(100) not null
);

create table ProveedorProducto (
	proveedor varchar(100) not null,
	producto varchar(20) not null
);

create table StubProveedores(
	id_registrada varchar(100) not null,
	PRIMARY KEY(id_registrada)
);

alter table Proveedor add foreign key (id) references Usuario(id);
alter table Factura add foreign key (id_usuario) references Usuario(id);
alter table Factura add foreign key (cliente_id) references Cliente(id);
alter table FacturaProducto add foreign key (id_factura) references Factura(id);
alter table FacturaProducto add foreign key (id_producto) references Producto(id);
alter table ProveedorCliente add foreign key (id_proveedor) references Usuario(id);
alter table ProveedorCliente add foreign key (id_cliente) references Cliente(id);
alter table ProveedorProducto add foreign key (proveedor) references Proveedor(id);
alter table ProveedorProducto add foreign key (producto) references Producto(id);