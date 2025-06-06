SOS-Clima 🌍
API REST para Monitoramento de Eventos Climáticos Extremos

- 📌 Descrição
O SOS-Clima é uma API REST que monitora, registra e fornece dados sobre eventos climáticos extremos ocorrendo ao redor do mundo. Desenvolvida em Java com Spring Boot, a aplicação permite:

Cadastro de eventos climáticos (furacões, enchentes, secas, incêndios, etc.)

Consulta de eventos por localização, tipo ou período

Análise de impacto e gravidade

Integração com sistemas de alerta ambiental

- 🛠️ Tecnologias
Linguagem: Java 17

Framework: Spring Boot 3.x

Banco de Dados: MySQL (padrão) ou Oracle

Persistência: Spring Data JPA + Hibernate

Gerenciamento de Dependências: Maven

Testes: JUnit 5, Mockito

Documentação: Swagger/OpenAPI

⚙️ Configuração do Ambiente
Pré-requisitos
JDK 17+

Maven 3.8+

Banco de Dados (MySQL 8+ ou Oracle 12c+)

Docker (opcional para containers)

- 🔧 Configuração do Banco de Dados
1. MySQL (Recomendado)
No arquivo src/main/resources/application.properties:

properties
# Configuração do MySQL  
spring.datasource.url=jdbc:mysql://localhost:3306/sosclima_db?createDatabaseIfNotExist=true  
spring.datasource.username=root  
spring.datasource.password=senha_segura  
spring.jpa.hibernate.ddl-auto=update  

# Configurações avançadas  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql=true  
2. Oracle
properties
# Configuração do Oracle  
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XE  
spring.datasource.username=admin  
spring.datasource.password=oracle_password  
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver  

# Hibernate  
spring.jpa.hibernate.ddl-auto=none  
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect  

- 🚀 Executando a Aplicação
Via Maven:
bash
mvn spring-boot:run  
Via Docker:
bash
docker build -t sosclima-api .  
docker run -p 8080:8080 sosclima-api  

- 📚 Endpoints da API
Método	Endpoint	Descrição
POST	/api/eventos	Cadastra novo evento climático
GET	/api/eventos	Lista todos os eventos
GET	/api/eventos/{id}	Busca evento por ID
GET	/api/eventos?tipo={tipo}	Filtra eventos por tipo
GET	/api/eventos?pais={pais}	Filtra eventos por país
PUT	/api/eventos/{id}	Atualiza um evento existente
DELETE	/api/eventos/{id}	Remove um evento (admin apenas)

- 📊 Documentação Interativa
Acesse a documentação completa após iniciar a aplicação:
🔗 http://localhost:8080/swagger-ui.html

🌐 Modelo de Dados
Diagram
Code


🤝 Como Contribuir
Faça um fork do projeto

Crie uma branch: git checkout -b feature/nova-feature

Commit suas alterações: git commit -m 'Adiciona nova funcionalidade'

Push para a branch: git push origin feature/nova-feature

Abra um Pull Request

🌦️ Aviso Climático: Esta API pode salvar vidas! Contribua com dados precisos para ajudar comunidades em risco.
Desenvolvido com ❤️ por Enrico do Nascimento Ferreira Galdino RM552082
