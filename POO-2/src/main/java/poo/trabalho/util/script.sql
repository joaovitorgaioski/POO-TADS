DROP DATABASE IF EXISTS dbtrabalho_poo;
CREATE DATABASE dbtrabalho_poo;
USE dbtrabalho_poo;

CREATE TABLE tbpessoa
(
    id_pessoa INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    cpf       CHAR(11)     NOT NULL,
    telefone  VARCHAR(20)  NOT NULL,
    endereco  VARCHAR(100)
);

CREATE TABLE tbcliente
(
    id_cliente INT NOT NULL PRIMARY KEY,
    filiacao   INT NOT NULL,

    FOREIGN KEY (id_cliente) REFERENCES tbpessoa (id_pessoa)
    ON DELETE CASCADE
);

CREATE TABLE tbfuncionario
(
    id_funcionario   INT            NOT NULL PRIMARY KEY,
    horas_trabalho   INT            NOT NULL,
    salario          DECIMAL(10, 2) NOT NULL,

    FOREIGN KEY (id_funcionario) REFERENCES tbpessoa (id_pessoa)
    ON DELETE CASCADE
);
