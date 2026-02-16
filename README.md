# 📦 Catálogo de Produtos Full Stack

Sistema completo de gerenciamento de produtos com backend em **Spring Boot 3** e interface moderna em **Tailwind CSS**.

---

## 📸 Preview do Sistema
O sistema possui integração total entre API e Frontend, com controle de acesso por nível de usuário.

<img src="https://github.com/user-attachments/assets/8138639b-550d-4c48-8fb9-03029f96cae5" width="100%" alt="Screenshot do Catálogo">

---

## 🛠️ Tecnologias Utilizadas

### **Backend**
* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Segurança:** Spring Security & JWT (JSON Web Token)
* **Gerenciador:** Maven
* **Documentação:** Swagger (OpenAPI 3)

### **Frontend**
* **Estilização:** Tailwind CSS
* **Lógica:** JavaScript (Fetch API)
* **Estrutura:** HTML5

---

## ✨ Funcionalidades

- [x] **Autenticação:** Login seguro via Token JWT.
- [x] **Listagem:** Visualização em tempo real dos produtos cadastrados.
- [x] **Gestão de Produtos:** Cadastro, edição e exclusão (CRUD).
- [x] **Segurança:** Regras de acesso onde apenas **ADMIN** pode alterar dados.

---


## 🛠️ Para Desenvolvedores (Execução Local)

Se você é um desenvolvedor e deseja testar este projeto localmente:

1. Certifique-se de ter o **Java 21** e o **Git** instalados.
2. Clone o repositório:
   `git clone https://github.com/salles1109-coder/catalog-api.git`
3. Entre na pasta e execute:
   `./mvnw spring-boot:run`
4. Acesse: `http://localhost:8080/index.html`
