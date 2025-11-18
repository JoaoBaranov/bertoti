# Biblioteca de Livros - API com Banco de Dados

## Pré-requisitos
- MySQL instalado e em execução (porta 3306)
- JDK 21 instalado (necessário para compilar/rodar)

## Criar o banco `db_library`
No MySQL, execute:
```sql
CREATE DATABASE db_library CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
```

Opcionalmente, criar um usuário dedicado:
```sql
CREATE USER 'library_user'@'localhost' IDENTIFIED BY 'senha_segura';
GRANT ALL PRIVILEGES ON db_library.* TO 'library_user'@'localhost';
FLUSH PRIVILEGES;
```

Depois, ajuste `src/main/resources/application.properties` conforme seu usuário/senha:
```
spring.datasource.url=jdbc:mysql://localhost:3306/db_library
spring.datasource.username=root
spring.datasource.password=
```

A tabela `books` é criada automaticamente via `schema.sql` ao iniciar a aplicação.

## Configurar JAVA_HOME (Windows PowerShell)
Substitua o caminho abaixo pelo diretório do seu JDK 21:
```powershell
$env:JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"
$env:Path = "$env:JAVA_HOME\\bin;$env:Path"
```

## Build e execução
Dentro desta pasta:
```powershell
.\mvnw.cmd spring-boot:run
```

## Endpoints (exemplos)
- GET todos: `GET http://localhost:8080/books`
- GET por id: `GET http://localhost:8080/books/{id}`
- POST criar:
```json
{
  "title": "Dom Casmurro",
  "author": "Machado de Assis",
  "publisher": "Editora XYZ",
  "year": 1899
}
```
- PUT atualizar por id:
```json
{
  "title": "Memórias Póstumas de Brás Cubas",
  "author": "Machado de Assis",
  "publisher": "Editora ABC",
  "year": 1881
}
```
- DELETE por id: `DELETE http://localhost:8080/books/{id}`


