# 🏥 Medical Clinic API

API REST para gerenciamento de uma clínica médica, desenvolvida com Java e Spring Boot. Permite o cadastro e gerenciamento de médicos, pacientes e consultas, com autenticação via JWT.

---

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 4**
- **Spring Security** — autenticação e autorização
- **Spring Data JPA / Hibernate** — persistência de dados
- **MySQL** — banco de dados relacional
- **Flyway** — controle de versão do banco de dados
- **JWT (Auth0 java-jwt)** — geração e validação de tokens
- **Lombok** — redução de boilerplate
- **SpringDoc / Swagger UI** — documentação da API
- **Maven** — gerenciamento de dependências

---

## 📁 Estrutura do Projeto

```
api/
└── src/main/java/br/com/med/voll/api/
    ├── address/          # Entidade e DTO de endereço (embeddable)
    ├── consultation/     # Entidade, DTOs, serviço e validações de consulta
    │   └── validation/   # Regras de negócio para agendamento
    ├── controller/       # Controllers REST (médicos, pacientes, consultas, auth)
    ├── doctor/           # Entidade, DTOs e enum de especialidade
    ├── infra/
    │   ├── exception/    # Tratamento global de erros
    │   ├── security/     # Filtro JWT, configuração do Spring Security, TokenService
    │   └── springdoc/    # Configuração do Swagger
    ├── patient/          # Entidade e DTOs de paciente
    ├── repository/       # Interfaces JPA
    └── user/             # Entidade de usuário e autenticação
```

---

## ⚙️ Configuração e Execução

### Pré-requisitos

- Java 17+
- Maven 3.8+
- MySQL 8+

### 1. Clone o repositório

```bash
git clone https://github.com/name-All4n/medical_clinic.git
cd medical_clinic/api
```

### 2. Configure o banco de dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE medical_clinic;
```

### 3. Configure as variáveis de ambiente

Defina as variáveis antes de rodar a aplicação:

```bash
export DB_MYSQL_USERNAME=seu_usuario
export DB_MYSQL_PASSEWORD=sua_senha
export JWT_SECRET=sua_chave_secreta_forte
```

> O arquivo `application.properties` já está preparado para ler `DB_MYSQL_USERNAME` e `DB_MYSQL_PASSEWORD` como variáveis de ambiente.

### 4. Execute a aplicação

```bash
./mvnw spring-boot:run
```

O Flyway irá executar as migrations automaticamente e criar todas as tabelas.

---

## 🗄️ Migrations (Flyway)

| Versão | Descrição |
|--------|-----------|
| V1 | Criação da tabela `doctors` |
| V2 | Adição da coluna `telephone` em `doctors` |
| V3 | Criação da tabela `patients` |
| V4 | Adição da coluna `active` em `doctors` |
| V5 | Adição da coluna `active` em `patients` |
| V6 | Criação da tabela `users` |
| V7 | Criação da tabela `consultations` |

---

## 🔐 Autenticação

A API utiliza autenticação stateless com **JWT Bearer Token**.

### Login

```http
POST /login
Content-Type: application/json

{
  "login": "usuario",
  "password": "senha"
}
```

**Resposta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

Todas as demais rotas exigem o header:

```
Authorization: Bearer <token>
```

---

## 📋 Endpoints

### Médicos — `/medicos`

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/medicos` | Cadastrar médico |
| `GET` | `/medicos` | Listar médicos ativos (paginado) |
| `GET` | `/medicos/{id}` | Detalhar médico |
| `PUT` | `/medicos` | Atualizar dados do médico |
| `DELETE` | `/medicos/{id}` | Inativar médico (soft delete) |

### Pacientes — `/patients`

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/patients` | Cadastrar paciente |
| `GET` | `/patients` | Listar pacientes ativos (paginado) |
| `GET` | `/patients/{id}` | Detalhar paciente |
| `PUT` | `/patients` | Atualizar dados do paciente |
| `DELETE` | `/patients/{id}` | Inativar paciente (soft delete) |

### Consultas — `/consultation`

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/consultation` | Agendar consulta |

---

## ✅ Regras de Negócio para Agendamento

Ao agendar uma consulta, as seguintes validações são aplicadas automaticamente:

- **Antecedência mínima:** consultas devem ser agendadas com pelo menos 30 minutos de antecedência.
- **Horário de funcionamento:** segunda a sábado, das 07h às 18h (consultas aos domingos não são permitidas).
- **Médico inativo:** não é possível agendar com médico inativo.
- **Paciente inativo:** não é possível agendar com paciente inativo.
- **Conflito de agenda do médico:** o médico não pode ter duas consultas no mesmo horário.
- **Uma consulta por dia:** o paciente não pode ter mais de uma consulta no mesmo dia.
- **Médico aleatório:** se nenhum médico for informado, a API escolhe automaticamente um disponível com a especialidade solicitada.

### Especialidades disponíveis

`ORTHOPEDICS` · `CARDIOLOGY` · `GYNECOLOGY` · `DERMATOLOGY`

---

## 📄 Documentação Interativa (Swagger)

Com a aplicação em execução, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧱 Modelo de Dados

```
doctors
├── id, name, email, telephone, crm
├── specialty (enum)
├── address (street, neighborhood, cep, city, uf, complement, number)
└── active (soft delete)

patients
├── id, name, email, telephone, cpf
├── address (embedded)
└── active (soft delete)

consultations
├── id, date
├── doctor_id (FK → doctors)
└── patient_id (FK → patients)

users
└── id, login, password (BCrypt)
```
