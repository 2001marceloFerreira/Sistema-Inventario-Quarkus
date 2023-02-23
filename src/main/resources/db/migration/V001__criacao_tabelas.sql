CREATE TABLE tb_ambiente(
id SERIAL PRIMARY KEY,
ambiente VARCHAR(20)
);

CREATE TABLE tb_pessoa(
id SERIAL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
cargo VARCHAR(40) NOT NULL,
email VARCHAR(50) NOT NULL,
telefone VARCHAR(50) NOT NULL

);

CREATE TABLE tb_tipo(
id SERIAL PRIMARY KEY,
categoria VARCHAR(50) NOT NULL

);

CREATE TABLE tb_produto(
id SERIAL PRIMARY KEY,
patrimonio VARCHAR(40) NOT NULL,
descricao VARCHAR(40) NOT NULL,
situacao VARCHAR(40) NOT NULL,
codigo VARCHAR(40) NOT NULL,
dt_cadastro DATE,
valor DECIMAL,
propriedade VARCHAR(25),
 ambiente_id BIGINT,
 pessoa_id BIGINT,
 tipo_id BIGINT,
 FOREIGN KEY (ambiente_id) REFERENCES tb_ambiente(id),
FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa (id),
FOREIGN KEY (tipo_id) REFERENCES tb_tipo (id)

);