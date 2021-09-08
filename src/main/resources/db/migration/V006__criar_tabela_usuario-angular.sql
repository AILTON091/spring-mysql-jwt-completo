create table usuario_angular (
	id bigint not null auto_increment, 
    login varchar(60) not null, 
    senha varchar(30) not null, 
    
    primary key (id)
)