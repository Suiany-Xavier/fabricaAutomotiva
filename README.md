# Fábrica Auto

Aplicação de linha de comando para cadastrar e consultar carros e motos em uma frota. O sistema valida os dados dos veículos, impede placas duplicadas e exibe informações gerais ou detalhes por categoria.

## Requisitos

- Java 17 ou superior

O projeto usa Gradle Wrapper, então não é necessário instalar o Gradle separadamente.

## Executar

Na raiz do projeto:

```bash
./gradlew run
```

No Windows:

```bat
gradlew.bat run
```

No menu, é possível cadastrar carros e motos, consultar detalhes dos veículos cadastrados e listar a frota completa. Os dados permanecem em memória durante a execução.

## Testes

Execute os testes automatizados com:

```bash
./gradlew test
```

No Windows:

```bat
gradlew.bat test
```

## Estrutura

- `src/main/java/fabricaAuto/`: código-fonte da aplicação.
- `src/test/java/fabricaAuto/`: testes automatizados.
- `gradlew` e `gradlew.bat`: scripts do Gradle Wrapper.
