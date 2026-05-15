DROP DATABASE IF EXISTS dbtrabalho_poo;
CREATE DATABASE dbtrabalho_poo;
USE dbtrabalho_poo;

CREATE TABLE tbproduto
(
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome       VARCHAR(50)   NOT NULL,
    sabor      VARCHAR(50)   NOT NULL,
    preco      DECIMAL(4, 2) NOT NULL
);

CREATE TABLE tbingrediente
(
    id_ingrediente INT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(50) NOT NULL,
    qtd_estoque    INT         NOT NULL,
    unidade        ENUM('KG', 'G', 'L', 'ML', 'UNIDADE') NOT NULL
);

CREATE TABLE tbreceita
(
    id_produto     INT,
    id_ingrediente INT,
    qtd_receita    INT NOT NULL,

    FOREIGN KEY (id_produto) REFERENCES tbproduto (id_produto),
    FOREIGN KEY (id_ingrediente) REFERENCES tbingrediente (id_ingrediente),
    PRIMARY KEY (id_produto, id_ingrediente)
);
