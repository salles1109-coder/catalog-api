🛒 Catalog API - Spring Boot

API REST completa para gerenciamento de catálogo de produtos, com autenticação JWT e interface web integrada.

---

🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Maven
- HTML, CSS, JavaScript
- H2 Database (em memória)

---

🔐 Autenticação

A API utiliza autenticação via JWT Token.

Login

Endpoint

POST /auth/login

Body

{
  "username": "admin",
  "password": "123"
}

Resposta

{
  "token": "SEU_TOKEN_JWT"
}

Use o token nas próximas requisições:

Authorization: Bearer SEU_TOKEN

---

📦 Endpoints de Produtos

Listar todos produtos

GET /products

Resposta:

[
  {
    "id": 1,
    "name": "Mouse",
    "price": 50.00
  }
]

---

Buscar produto por ID

GET /products/{id}

Exemplo:

GET /products/1

---

Criar produto

POST /products

Body:

{
  "name": "Teclado",
  "price": 99.90
}

---

Atualizar produto

PUT /products/{id}

Body:

{
  "name": "Teclado Gamer",
  "price": 199.90
}

---

Deletar produto

DELETE /products/{id}

---

🌐 Interface Web

O projeto possui interface web integrada.

Acesse:

http://localhost:8080/index.html

Funcionalidades:

- Login
- Criar produto
- Listar produtos
- Buscar produtos
- Deletar produtos

---

🧪 Swagger (Documentação interativa)

Acesse:

http://localhost:8080/swagger-ui/index.html

---

⚙️ Como executar o projeto

Requisitos

- Java 21
- Git

---

Clone o projeto

git clone https://github.com/salles1109-coder/catalog-api.git

---

Execute

Linux / Mac:

./mvnw spring-boot:run

Windows:

mvnw.cmd spring-boot:run

---

Acesse

http://localhost:8080/index.html

---

👤 Usuário padrão

username: admin
password: 123

---

🔒 Segurança

- Autenticação JWT
- Rotas protegidas
- Apenas ADMIN pode alterar dados

---

📁 Estrutura

controller
service
repository
dto
security

---

📌 Status do Projeto

✅ Completo
✅ Funcional
✅ Pronto para produção (com ajustes)

---

👨‍💻 Autor

Vinicius Sales

GitHub:

https://github.com/salles1109-coder

---

⭐ Objetivo

Projeto desenvolvido para estudo e demonstração de conhecimentos em:

- Backend Java
- Spring Boot
- APIs REST
- Segurança
- Integração Frontend
