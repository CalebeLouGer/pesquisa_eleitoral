CREATE TABLE IF NOT EXISTS estados (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS municipios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    populacao BIGINT,
    grupo VARCHAR(50),
    estado_id BIGSERIAL NOT NULL,

    CONSTRAINT fk_estado
        FOREIGN KEY (estado_id)
        REFERENCES estados(id)
);


CREATE TABLE candidatos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE pesquisas (
    id BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    estado_id BIGSERIAL NOT NULL,
    municipio_id BIGSERIAL NOT NULL,
    candidato_id BIGSERIAL NOT NULL,

    quantidade_voto BIGINT NOT NULL,

    CONSTRAINT fk_municipio
        FOREIGN KEY (municipio_id)
        REFERENCES municipios(id),

    CONSTRAINT fk_estado
            FOREIGN KEY (estado_id)
            REFERENCES estados(id),

    CONSTRAINT fk_candidato
        FOREIGN KEY (candidato_id)
        REFERENCES candidatos(id)
);

CREATE TABLE usuarios(
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);