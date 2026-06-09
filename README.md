<h1 align="center">
  TO-DO List
</h1>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) da Simplify.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI](https://springdoc.org/v2/#spring-webflux-support)
- [MySQL](https://dev.mysql.com/downloads/)
- [H2 Database](https://www.h2database.com/html/main.html)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Documentação da API com Swagger (OpenAPI)

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar a aplicação:
```
java -jar target/desafio-todolist-0.0.1-SNAPSHOT.jar
```

A API estará disponível em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
http POST :8080/todos name="Limpar a casa" description="Lembrete para mais tarde" priority=1

[
    {
        "description": "Descrição 5",
        "done": false,
        "id": 5,
        "name": "Tarefa 5",
        "priority": 2
    },
    {
        "description": "Descrição 6",
        "done": false,
        "id": 6,
        "name": "Tarefa 6",
        "priority": 2
    },
    {
        "description": "Lembrete para mais tarde",
        "done": false,
        "id": 7,
        "name": "Limpar a casa",
        "priority": 1
    }
```

- Listar Tarefas
```
http GET :8080/todos

[
    {
        "description": "Descrição 3",
        "done": false,
        "id": 3,
        "name": "Tarefa 3",
        "priority": 1
    },
    {
        "description": "Descrição 4",
        "done": false,
        "id": 4,
        "name": "Tarefa 4",
        "priority": 1
    },
    {
        "description": "Descrição 5",
        "done": false,
        "id": 5,
        "name": "Tarefa 5",
        "priority": 2
    },
    {
        "description": "Descrição 6",
        "done": false,
        "id": 6,
        "name": "Tarefa 6",
        "priority": 2
    },
    {
        "description": "Lembrete para mais tarde",
        "done": false,
        "id": 7,
        "name": "Limpar a casa",
        "priority": 1
    },
]
```

- Atualizar Tarefa
```
http PUT :8080/todos/5 name="Comprar bebidas" description="Hoje 18h" made=false priority=1

{
    "description": "Hoje 18h",
    "done": false,
    "id": 5,
    "name": "Comprar bebidas",
    "priority": 1
}
```

- Remover Tarefa
```
http DELETE :8080/todos/7

[ ]
```
