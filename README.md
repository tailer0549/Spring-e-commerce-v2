E-commerce API

API REST de um sistema de e-commerce desenvolvida com Java e Spring Boot.

Sobre

Projeto criado com foco em prática de desenvolvimento backend utilizando Spring.
A aplicação simula um sistema de e-commerce, permitindo o gerenciamento de usuários, produtos e pedidos através de endpoints REST.

Com a evolução do projeto, foram adicionadas melhorias estruturais e de segurança, aproximando mais de um cenário real de mercado, como uso de DTOs, autenticação com JWT e melhor separação de responsabilidades.

 - Funcionalidades
 - CRUD de produtos
 - CRUD de usuários
 - CRUD de pedidos
 - Autenticação e autorização com JWT
 - Uso de DTOs para transferência de dados
 - Estrutura em camadas (controller, service, repository)
 - Tratamento de exceções personalizado
 - Banco de dados em memória com H2
 - Interface simples em HTML/JavaScript consumindo a API
 - Tecnologias
 - Java 17+
 - Spring Boot
 - Spring Security
 - JWT (JSON Web Token)
 - Spring Data JPA
 - Hibernate
 - H2 Database
 - Maven
 - HTML / JavaScript
 - Segurança

A aplicação utiliza autenticação baseada em JWT.
Após realizar o login, um token é gerado e deve ser enviado nas requisições protegidas.

Login retorna um token JWT
Rotas protegidas exigem autenticação
Controle básico de acesso implementado
.Como rodar o projeto
Pré-requisitos
Java 17 ou superior
Maven
Clonando o repositório
git clone https://github.com/tailer0549/Spring-e-commerce-v2.git
cd Spring-e-commerce-v2

Executando a aplicação
./mvnw spring-boot:run


A aplicação estará disponível em:

http://localhost:8080

Acessando o H2 Console
http://localhost:8080/h2-console

Observações

Esse projeto foi desenvolvido com fins de estudo e prática.
Ao longo do tempo, novas melhorias podem ser adicionadas, como:

- Integração com banco de dados real (PostgreSQL, MySQL)
- Deploy em nuvem
- Testes automatizados
- Documentação com Swagger
