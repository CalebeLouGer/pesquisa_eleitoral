CREATE TABLE estado (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(2) NOT NULL
);

CREATE TABLE municipio (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    populacao INTEGER,
    grupo INTEGER,
    estado_id INTEGER NOT NULL,

    CONSTRAINT UQ_municipio UNIQUE (nome, estado_id),

    CONSTRAINT fk_municipio_estado
        FOREIGN KEY (estado_id)
        REFERENCES estado(id)
);

CREATE TABLE candidato (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE pesquisa (
    id BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL
);

CREATE TABLE entrevista (
    id BIGSERIAL PRIMARY KEY,
    pesquisa_id INTEGER NOT NULL,
    municipio_id INTEGER NOT NULL,
    candidato_id INTEGER NOT NULL,

    CONSTRAINT fk_entrevista_pesquisa
        FOREIGN KEY (pesquisa_id)
        REFERENCES pesquisa(id),

    CONSTRAINT fk_entrevista_municipio
        FOREIGN KEY (municipio_id)
        REFERENCES municipio(id),

    CONSTRAINT fk_entrevista_candidato
        FOREIGN KEY (candidato_id)
        REFERENCES candidato(id)
);

CREATE TABLE usuarios(
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);