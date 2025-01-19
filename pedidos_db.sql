create database pedidos_db;

use pedidos_db;

create table usuario_db(
		email VARCHAR(128) NOT NULL PRIMARY KEY,
	    senha VARCHAR(128) NOT NULL
);

insert into usuario_db (email, senha) VALUES ("admin@gmail.com", "admin");

CREATE TABLE pedido_db (
    id INT AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(500),
    username VARCHAR(150) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username, id),
    FOREIGN KEY (username) REFERENCES usuario_db(email) ON DELETE CASCADE
);

select * from usuario_db;

select * from pedido_db;