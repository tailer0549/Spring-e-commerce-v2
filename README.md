# E-commerce API

API REST de um sistema de e-commerce feita com Java e Spring Boot.

## Sobre

Projeto criado para praticar desenvolvimento backend com Spring.  
A aplicação permite gerenciar pedidos, usuários e produtos através de endpoints REST.

Com o tempo, o projeto foi evoluído com melhorias como uso de DTOs e melhor organização em camadas.

## Funcionalidades

- CRUD de produtos
- CRUD de usuários
- CRUD de pedidos
- Uso de DTOs
- Estrutura em camadas (controller, service, repository)
- Banco em memória com H2
- Interface simples em HTML/JavaScript consumindo a API

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- HTML / JavaScript

## Como rodar

Pré-requisitos:
- Java 17+
- Maven

```bash
git clone https://github.com/tailer0549/Spring-e-commerce-v2.git
cd Spring-e-commerce-v2
./mvnw spring-boot:run
