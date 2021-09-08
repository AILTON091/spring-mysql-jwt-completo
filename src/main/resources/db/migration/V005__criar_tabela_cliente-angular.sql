create table cliente_angular (
	id bigint not null auto_increment, 
    nome varchar(60) not null, 
    cpf varchar(11) not null, 
    data_Cadastro datetime not null,
    
    primary key (id)
)