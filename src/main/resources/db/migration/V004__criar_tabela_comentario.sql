create table comentario (
	id bigint  not null auto_increment, 
    ordem_Servico_id bigint not null, 
    descricao text not null, 
    data_envio datetime not null, 
    
    primary key (id)
);

alter table comentario add constraint fk_comentario_ordem_servico
foreign key (ordem_Servico_id) references ordem_servico (id)