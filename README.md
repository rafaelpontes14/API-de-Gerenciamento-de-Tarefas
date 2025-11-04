# API de Gerenciamento de Tarefas - Spring Boot

## 👨‍🎓 Aluno
**Rafael Fernandes Pontes**  
**RU: 4893230**

## 📋 Descrição
API RESTful para gerenciamento de tarefas desenvolvida em Java Spring Boot como trabalho acadêmico.

## 🚀 Tecnologias
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Maven

## 📚 Endpoints
- `POST /api/tarefas` - Criar tarefa
- `GET /api/tarefas` - Listar todas as tarefas
- `GET /api/tarefas/{id}` - Buscar tarefa por ID  
- `PUT /api/tarefas/{id}` - Atualizar tarefa
- `DELETE /api/tarefas/{id}` - Remover tarefa

## ⚙️ Configuração
1. Configure o banco MySQL no application.properties
2. Execute: `mvn spring-boot:run`
3. Acesse: http://localhost:8080
