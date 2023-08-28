-- -----------------------------------------------------
-- Table Projeto
-- -----------------------------------------------------
CREATE TABLE projetos (
    id bigserial NOT NULL,
    nome VARCHAR(200) NOT NULL,
    data_inicio DATE ,
    data_previsao_fim DATE ,
    data_fim DATE ,
    descricao VARCHAR(5000) ,
    status VARCHAR(45) NOT NULL ,
    orcamento FLOAT ,
    risco VARCHAR(45) ,
    idgerente bigint NOT NULL,
    CONSTRAINT pk_projeto PRIMARY KEY (id)
);
-- -----------------------------------------------------
-- Table Membros
-- -----------------------------------------------------
CREATE TABLE membros (
    idprojeto bigint NOT NULL,
    idpessoa bigint NOT NULL,
    CONSTRAINT pk_membros PRIMARY KEY (idprojeto, idpessoa),
    CONSTRAINT fk_projeto FOREIGN KEY (idprojeto)
    REFERENCES projetos (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);