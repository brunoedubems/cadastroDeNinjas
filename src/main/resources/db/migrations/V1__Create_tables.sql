-- V1: Criação da tabela tb_cadastro e chave estrangeira para missoes

CREATE TABLE tb_cadastro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade INT,
    missoes_id BIGINT
);
