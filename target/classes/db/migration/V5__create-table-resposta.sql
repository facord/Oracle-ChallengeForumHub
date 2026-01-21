CREATE TABLE resposta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    solucao BOOLEAN DEFAULT FALSE,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_resposta_topico FOREIGN KEY(topico_id) REFERENCES topico(id),
    CONSTRAINT fk_resposta_autor FOREIGN KEY(autor_id) REFERENCES usuario(id)
);