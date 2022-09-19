create table entrega(
	
	id bigint not null auto_increment,
	cliente_id bigint not null,
	taxa decimal(10,2) not null,
	status varchar(20) not null,
	data_pedido datetime not null,
	data_finalizacao datetime,
	
	detinatario_nome varchar(60) not null,
	detinatario_logradouro varchar(255) not null,
	detinatario_numero varchar(30) not null,
	detinatario_complemento varchar(60) not null,
	detinatario_bairro varchar(30) not null,
	
	primary key (id)

);

alter table entrega add constraint fk_entrega_cliente foreign key (cliente_id) references cliente(id);