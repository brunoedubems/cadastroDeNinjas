-- V1: Criação da tabela tb_cadastro e chave estrangeira para missoes

CREATE TABLE tb_cadastro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade INT,
    img_url VARCHAR(255),
    missoes_id BIGINT
);


-- V1: Criação da tabela tb_missoes

CREATE TABLE tb_missoes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    dificuldade VARCHAR(255)
);
