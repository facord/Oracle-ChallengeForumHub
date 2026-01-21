# Challenge Fórum Hub

API REST desenvolvida em Java com Spring Boot para gerenciamento de **Tópicos** e **Respostas** em um fórum.

O projeto implementa boas práticas de desenvolvimento de APIs, incluindo autenticação e autorização com **Spring Security** e **JWT**, controle de acesso, tratamento de erros, versionamento de banco de dados com **Flyway** e documentação automática com **Swagger (SpringDoc)**.

> 🚧 **Status do projeto**: Em desenvolvimento. No momento, não há endpoints para criação de **Usuários** e **Cursos**, porém as tabelas já existem e são inicializadas com dados para testes.

---

## 🧩 Funcionalidades

- CRUD completo de **Tópicos**
- CRUD completo de **Respostas**
- Relacionamento entre Tópicos e Respostas
- Autenticação com JWT
- Controle de acesso por perfil
- Validações e regras de negócio
- Tratamento padronizado de erros
- Documentação interativa da API com Swagger

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **JSON Web Token (JWT)**
- **MySQL**
- **FlywayDB**
- **Swagger / SpringDoc OpenAPI**
- **Maven**

---

## 📐 Arquitetura e Boas Práticas

- Separação em camadas (Controller, Service, Repository, DTO)
- Uso de **DTOs** para controle de exposição de dados
- **Records** para objetos imutáveis de resposta
- Padrão RESTful
- Controle de exceções com `@ControllerAdvice`
- Endpoints protegidos com autenticação

---

## 🔐 Segurança

- Autenticação baseada em **JWT**
- Endpoints públicos e privados configurados via Spring Security
- Sessão **STATELESS**
- Filtros de segurança personalizados

---

## 📄 Documentação da API

Após subir a aplicação, a documentação estará disponível em:

- Swagger UI:  
  `http://localhost:8080/swagger-ui.html`

- OpenAPI JSON:  
  `http://localhost:8080/v3/api-docs`

---

## 🗄️ Banco de Dados

- Banco: **MySQL**
- Versionamento de schema com **Flyway**
- Dados iniciais inseridos automaticamente para testes

### Principais Tabelas

- `topico`
- `resposta`
- `usuario`
- `curso`
- `perfil`

---

## ▶️ Como Executar o Projeto

É necessário criar as váriaveis de ambiente para teste ou a troca das informações em "application.properties":
<p>spring.datasource.url=${DATASOURCE_URL}</p>
<p>spring.datasource.username=${DATASOURCE_USERNAME}</p>
<p>spring.datasource.password=${DATASOURCE_PASSWORD}</p>

### Pré-requisitos

- Java 17+
- MySQL
- Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/facord/Oracle-ChallengeForumHub.git

# Acesse o projeto
cd challenge-forum-hub

# Execute a aplicação
mvn spring-boot:run
```

---

## 📌 Exemplos de Endpoints

```http
POST /login
GET  /topicos
POST /topicos
PUT  /topicos/{id}
DELETE /topicos/{id}

POST /respostas
GET  /topicos/{id}/respostas
```

---

## ❗ Regras de Negócio

- Não é permitido cadastrar tópicos duplicados
- Apenas usuários autenticados podem criar ou responder tópicos
- Um tópico inativo não pode receber respostas

---

## 🧪 Dados para Testes

Usuários e cursos são carregados automaticamente via Flyway para facilitar os testes da API.

---

## 👩‍💻 Autora

**Fabiana Cordeiro Rocha**  
Projeto desenvolvido para fins de estudo e prática com Spring Boot e APIs REST.

---

