<div align="center">

# 🚗 fabricaAutomotiva

**Sistema em Java para cadastrar e gerenciar a frota de uma fábrica de veículos: carros, motos e muito mais.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)

</div>

---

## 📖 Sobre o projeto

O **fabricaAutomotiva** é um projeto em Java, rodando no terminal, que simula o controle de uma frota de veículos. Dá pra cadastrar carros e motos, validar placas, consultar os veículos e colocá-los em movimento, tudo seguindo os conceitos de **Programação Orientada a Objetos**.

Ele nasceu como projeto de estudo e vem sendo melhorado aos poucos, com foco em código limpo, validações seguras e testes automatizados.

## ✨ Funcionalidades

- [x] Cadastro de veículos (carro e moto)
- [x] Validação de placas (formato antigo `ABC1234` e Mercosul `ABC1D23`)
- [x] Controle de placas duplicadas na frota
- [x] Menu interativo no terminal
- [x] Encerramento da entrada sem mostrar *stack trace*
- [x] Testes automatizados

## 🧠 Conceitos aplicados

- **Herança**: `Automovel` como classe base de `Carro` e `Moto`
- **Polimorfismo**: cada veículo mostra seus próprios detalhes
- **Encapsulamento**: atributos protegidos e acesso por métodos
- **Validação de dados**: placas e campos de entrada
- **Testes unitários**: regras da frota e fluxo interativo

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal |
| Gradle | Build e gerenciamento de dependências |
| JUnit | Testes automatizados |
| IntelliJ IDEA | IDE de desenvolvimento |

## 🚀 Como executar

**Pré-requisitos:** JDK instalado (versão 17 ou superior) e Git.

```bash
# 1. Clone o repositório
git clone https://github.com/Suiany-Xavier/fabricaAutomotiva.git

# 2. Entre na pasta do projeto Gradle
cd fabricaAutomotiva/fabricaAuto

# 3. Compile e rode os testes
./gradlew build

# 4. Execute o programa
# (abra o projeto no IntelliJ e rode a classe Principal.java)
```

## 🧪 Testes

```bash
./gradlew test
```

## 📂 Estrutura do projeto

```
fabricaAutomotiva/
├── README.md
├── .gitignore
└── fabricaAuto/
    ├── gradle/
    ├── src/
    │   ├── main/java/fabricaAuto/
    │   │   ├── Automovel.java          # Classe base dos veículos
    │   │   ├── Carro.java
    │   │   ├── Moto.java
    │   │   ├── Frota.java              # Gerencia a frota e as placas
    │   │   ├── FormatadorVeiculo.java  # Formatação dos detalhes
    │   │   ├── MenuConsole.java        # Menu interativo no terminal
    │   │   └── Principal.java          # Ponto de entrada
    │   └── test/java/                  # Testes automatizados
    ├── build.gradle
    ├── settings.gradle
    ├── gradlew
    └── gradlew.bat
```


## 👩‍💻 Autoria

Desenvolvido por **Suiany Xavier de Oliveira**
Estudante de Análise e Desenvolvimento de Sistemas

[![GitHub](https://img.shields.io/badge/GitHub-Suiany--Xavier-181717?style=flat&logo=github)](https://github.com/Suiany-Xavier)

---

