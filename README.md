# 📊 Sistema de Pesquisa Eleitoral

API desenvolvida para gerenciar e processar dados de pesquisas eleitorais, permitindo o cadastro de pesquisas, candidatos e cálculo de resultados com base em intenções de voto.

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de dados relacional
- Maven

## 📌 Funcionalidades

- Cadastro de **Estados e Municípios**
- Cadastro de **Candidatos**
- Registro de **Pesquisas Eleitorais**
- Importação de dados via JSON
- Total de votos por candidato
- Agrupamento de resultados por pesquisa

## 🧠 Regras de negócio

- Cada pesquisa possui:
  - ID
  - Data
  - Município e Estado
- Os votos são vinculados aos candidatos

## 📂 Estrutura do projeto

controller -> recebe requisições HTTP <br>
service -> regras de negócio (processamento) <br>
repository -> acesso ao banco <br>
domain -> entidades do sistema <br>
dto -> transferência de dados <br>


## ▶️ Demonstração do projeto

📹 Vídeo explicando o funcionamento da aplicação:

[Assista ao vídeo](https://www.youtube.com/watch?v=37Eebgcv0FE)

## 🔌 Endpoints principais (exemplo)

| Método | Endpoint    | Descrição           |
| ------ | ----------- | ------------------- |
| POST   | /pesquisas  | Cadastrar pesquisa  |
| GET    | /resultados | Ver resultados      |

## 👨‍💻 Autor

**Calebe Lourenço** <br>
Desenvolvedor Back-end
🔗 [https://github.com/CalebeLouGer](https://github.com/CalebeLouGer)

## 📄 Documentação da API (Swagger)

A API possui documentação interativa gerada automaticamente com **SpringDoc OpenAPI (Swagger)**, permitindo visualizar e testar os endpoints de forma prática.

Com o Swagger, é possível:
- Visualizar todos os endpoints disponíveis
- Testar requisições diretamente pelo navegador
- Ver parâmetros, respostas e códigos HTTP
- Facilitar a integração com outras aplicações

Após iniciar o projeto, acesse:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## ⚙️ Tecnologias de documentação

- SpringDoc OpenAPI
- Swagger UI
