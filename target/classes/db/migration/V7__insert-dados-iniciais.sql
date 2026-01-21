-- 1. Inserindo Cursos
INSERT INTO curso (nome, categoria) VALUES ('Java e Spring Boot', 'PROGRAMACAO');
INSERT INTO curso (nome, categoria) VALUES ('SQL para Iniciantes', 'BANCO_DE_DADOS');

-- 2. Inserindo Perfis (Regras de acesso)
INSERT INTO perfil (nome) VALUES ('ROLE_ADMIN');
INSERT INTO perfil (nome) VALUES ('ROLE_ALUNO');

-- 3. Inserindo Usuários
INSERT INTO usuario (nome, email, senha) VALUES ('Fabiana Cordeiro', 'fabiana.cordeiro@forumhub.com', '$2a$12$VJzm4yweyuUF4VRsV.amk.7ax/jxD46Yv7ZgQBuC6CLKXyQM14MaC');
INSERT INTO usuario (nome, email, senha) VALUES ('Bruno Souza', 'bruno.souza@forumhub.com', '$2a$12$2SVqBre0V1X4Pj6lUouofeoGiwB0cDQsc1j3pK0RadH/biD50EZtm');

-- 4. Associando Usuários aos Perfis (Tabela Intermediária)
INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES (1, 1);
INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES (2, 2);

-- 5. Criando um Tópico
-- Referencia o autor (usuario_id 2) e o curso (curso_id 1)
INSERT INTO topico (titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES (
    'Dúvida com JPA',
    'Não estou conseguindo realizar o mapeamento ManyToOne.',
    '2024-01-20 10:00:00',
    'NAO_RESPONDIDO',
    2,
    1
);

-- 6. Respondendo ao Tópico
-- Referencia o tópico (topico_id 1) e quem respondeu (usuario_id 1 - Ana)
INSERT INTO resposta (mensagem, data_criacao, solucao, topico_id, autor_id)
VALUES (
    'Verifique se você importou as anotações do pacote jakarta.persistence.',
    '2024-01-20 14:30:00',
    true,
    1,
    1
);