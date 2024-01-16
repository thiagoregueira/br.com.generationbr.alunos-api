# Alunos API

Este é um projeto Spring Boot que fornece uma API para gerenciar alunos.

## Recursos

- Gerenciamento de alunos: O projeto inclui classes para modelar alunos ([Aluno.java](src/main/java/br/com/generationbr/alunosapi/model/Aluno.java)),
- Um repositório para persistir os dados dos alunos ([AlunoRepository.java](src/main/java/br/com/generationbr/alunosapi/repository/AlunoRepository.java)), 
- Serviço para lógica de negócios relacionada aos alunos ([AlunoService.java](src/main/java/br/com/generationbr/alunosapi/service/AlunoService.java)),
- Controladores: O projeto inclui um controlador para lidar com solicitações HTTP relacionadas aos alunos ([AlunoController.java](src/main/java/br/com/generationbr/alunosapi/controller/AlunoController.java)).
- Testes: Existem testes para a aplicação ([AlunosApiApplicationTests.java](src/test/java/br/com/generationbr/alunosapi/AlunosApiApplicationTests.java)).

## Como executar

Para construir e executar o projeto, você pode usar o Maven Wrapper incluído:

./mvnw spring-boot:run

## Docker
Um Dockerfile está incluído para construir uma imagem Docker do projeto. Você pode construir a imagem usando:

docker build -t alunos-api .
