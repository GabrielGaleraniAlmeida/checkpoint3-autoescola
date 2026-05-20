Markdown
# Checkpoint 3 – API ReST para Agendamento de Autoescola

API ReST desenvolvida com **Java 17** e **Spring Boot** para o cadastramento, listagem, atualização e exclusão de instrutores e alunos de uma autoescola. Esta entrega contempla a arquitetura de persistência, controle de migrações e validações estritas de regras de negócio.

## 👥 Integrantes do Grupo (Grupo 5)
* **Gabriel Galerani Almeida** - RM: 557421
* **Gustavo Alves** - RM: 557876
* **Gabriel Dias** - RM: 556830
* **Pedro Paulo** - RM: 554880
* **Leonardo Taschin** - RM: 554583

---

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 17
* **Framework:** Spring Boot 4.0.6 (Web, Data JPA, Validation)
* **Banco de Dados:** MySQL 8.0 (Rodando via Docker)
* **Gerenciador de Migrações:** Flyway 11.14.1
* **Persistência e ORM:** Hibernate 7.2.12.Final / JPA
* **Ferramenta de Build:** Maven

---

## 🏗️ Arquitetura do Projeto
O projeto foi estruturado utilizando o padrão de camadas para isolamento completo de responsabilidades:
* `controller`: Exposição dos endpoints ReST da API e mapeamento dos verbos HTTP.
* `dto`: Objetos de Transferência de Dados (Data Transfer Objects) implementados como *Records* para validação de payload na entrada de dados.
* `model`: Entidades de domínio mapeadas para o banco de dados e Value Objects (VO) como o Endereço.
* `repository`: Interfaces de abstração de banco de dados estendendo `JpaRepository`.

---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
* **Docker Desktop** instalado e ativo.
* **JDK 17** ou superior configurado no sistema.

### Passo 1: Subir o Banco de Dados (Docker)
Na raiz do projeto (onde encontra-se o arquivo `docker-compose.yml`), abra o seu terminal e execute:
```bash
docker compose up -d


Nota: O contêiner subirá isolado utilizando a porta externa 3307 para evitar conflitos locais com outros serviços MySQL rodando na máquina.
Passo 2: Executar a Aplicação Spring Boot
Você pode rodar a aplicação diretamente pela sua IDE (IntelliJ IDEA) executando a classe Checkpoint3AutoescolaApplication.java, ou via terminal utilizando o wrapper do Maven:



Bash
# No Windows (Prompt de Comando)
mvnw.cmd spring-boot:run

# No Windows (PowerShell)
./mvnw spring-boot:run


O Flyway detectará o banco de dados e executará a migração contida em src/main/resources/db/migration/V1__create-tables.sql automaticamente. O servidor estará ativo em http://localhost:8080.
🛣️ Endpoints Principais
Instrutores (/instrutores)
POST /instrutores: Realiza o cadastro de um novo instrutor. (O campo telefone é ocultado no cadastro inicial para posterior atualização).
GET /instrutores: Retorna uma listagem paginada (10 registros por página) ordenada de maneira crescente pelo nome.
PUT /instrutores: Atualiza nome, telefone e endereço. Bloqueia por regra de negócio a alteração de E-mail, CNH e Especialidade.
DELETE /instrutores/{id}: Realiza a exclusão lógica, alterando o status do instrutor para "inativo" no sistema sem apagar os dados físicos.
Alunos (/alunos)
POST /alunos: Cadastro inicial do aluno com endereço completo.
GET /alunos: Retorna a listagem paginada (10 registros por página) ordenada de maneira crescente pelo nome.
PUT /alunos: Permite a atualização cadastral de nome, telefone e endereço. Bloqueia por regra de negócio a alteração de E-mail e CPF.
DELETE /alunos/{id}: Realiza a exclusão lógica tornando o registro do aluno inativo no sistema.



---

### 📤 Comandos para atualizar o GitHub

Para salvar essas alterações do README e enviar a versão final com os nomes do grupo para o repositório, execute estes comandos no terminal do IntelliJ:

```bash
git add README.md
git commit -m "docs: adiciona integrantes do grupo e RMs ao readme"
git push origin main
