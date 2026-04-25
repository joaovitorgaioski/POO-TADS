DROP DATABASE IF EXISTS db_poo;
CREATE DATABASE db_poo;
USE db_poo;

CREATE TABLE tb_curso
(
    curso_id INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(50) NOT NULL
);

CREATE TABLE tb_aluno
(
    aluno_id INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100),
    curso_id INT,

    FOREIGN KEY (curso_id) REFERENCES tb_curso (curso_id)
);