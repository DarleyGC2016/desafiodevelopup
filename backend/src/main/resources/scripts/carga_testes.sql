CREATE SCHEMA IF NOT EXISTS H2DB AUTHORIZATION sa;

create table H2DB.pessoa
(
    id int not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    contato varchar(200) not null,
    email varchar(200) not null,
    cargo varchar(27) not null,
    primary key(id)
);



--create unique index pessoa_contato_uindex
  --  on H2DB.pessoa (contato);

--create unique index pessoa_email_uindex
  --  on H2DB.pessoa (email);

--create unique index pessoa_id_uindex
  --  on H2DB.pessoa (id);

--alter table H2DB.pessoa
  --  add constraint pessoa_pk
    --    primary key (id);

--alter table H2DB.pessoa modify id integer auto_increment;

create table H2DB.equipe(
    id int not null,
    nome varchar(255) not null,
    pessoa_id int,  
    primary key(id)
);

ALTER TABLE H2DB.equipe 
ADD CONSTRAINT fk_pessoa 
FOREIGN KEY (pessoa_id) REFERENCES H2DB.pessoa(id);
