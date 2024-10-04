# Gerenciador de Jogos 🎮

Este projeto é uma aplicação web para o cadastro e gerenciamento de jogos. Ele permite adicionar informações como nome, gênero, valor, descrição, data de lançamento e plataforma dos jogos. A aplicação foi desenvolvida utilizando Spring Boot com integração ao Thymeleaf para a parte de front-end e segue uma estrutura organizada para facilitar a manutenção e o crescimento do sistema.

## 📋 Funcionalidades

- **Cadastro de Jogos**: Preencha um formulário para cadastrar um novo jogo no sistema.
- **Listagem de Jogos**: Visualize a lista de todos os jogos cadastrados.
- **Atualização de Jogos**: Edite os dados de um jogo existente.
- **Exclusão de Jogos**: Remova um jogo da lista.
- **Detalhes do Jogo**: Visualize informações detalhadas sobre cada jogo.

## 🛠️ Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Framework**: Spring Boot
- **Template Engine**: Thymeleaf
- **Banco de Dados**: H2 (em memória)
- **Front-End**: Bootstrap 5, HTML, CSS
- **Controle de Versão**: Git e GitHub

## 🚀 Como Executar o Projeto

### Pré-requisitos
- JDK 11+
- Maven 3.6+
- IDE com suporte a Java (IntelliJ IDEA, Eclipse, etc.)

### Passo a Passo para Executar

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/thiagogilcamargo/gerenciador-jogos.git
    ```

2. **Navegue até a pasta do projeto:**

    ```bash
    cd gerenciador-jogos
    ```

3. **Compile o projeto utilizando Maven:**

    ```bash
    mvn clean install
    ```

4. **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

5. **Acesse a aplicação no navegador:**

    ```
    http://localhost:8080
    ```

## 🗄️ Endpoints da Aplicação

A aplicação possui os seguintes endpoints:

- **GET /jogo/listar**  
  Exibe a lista de todos os jogos cadastrados.

- **GET /jogo/cadastrar**  
  Exibe o formulário de cadastro de um novo jogo.

- **POST /jogo/cadastrar**  
  Salva um novo jogo no banco de dados.

- **GET /jogo/editar/{id}**  
  Exibe o formulário para editar um jogo existente.  
  Exemplo: `GET /jogo/editar/3`

- **POST /jogo/editar**  
  Salva as alterações de um jogo já editado.

- **GET /jogo/excluir/{id}**  
  Exclui um jogo da lista com base no seu ID.  
  Exemplo: `GET /jogo/excluir/3`

- **GET /jogo/pesquisar?nome={nome}**  
  Pesquisa jogos pelo nome e exibe a lista filtrada.  
  Exemplo: `GET /jogo/pesquisar?nome=Mario`



## 👥 Contribuidores

- **Thiago Gil Camargo**

## 📄 Licença

Este projeto está sob a licença MIT.

## 📧 Contato

Para dúvidas ou sugestões, entre em contato:

- **E-mail**: [thiagogilcmargo@gmail.com](mailto:thiagogilcmargo@gmail.com)  
- **LinkedIn**: [Thiago Gil Camargo](https://www.linkedin.com/in/thiago-gil-camargo-513584268/)
