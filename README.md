# Estacionamento de Carros  
[![Build Status](https://travis-ci.com/gui9394/Conpay_EstacionamentoAPI.svg?token=fMHHHqYdW4ReoMi1bebP&branch=development)](https://travis-ci.com/gui9394/Conpay_EstacionamentoAPI)

Conpay - Desafio processo seletivo  
Repositório: [GitHub](https://github.com/dangellys-conpay/desafio-estacionamento)  

## Descrição  
API para gerenciamento de carros de em um estacionamento.  

Documentação da API: [GitHub](https://github.com/gui9394/Conpay_EstacionamentoAPI/blob/development/ENDPOINTS.md)

## Tecnologias  
- JDK  
- Maven  
- Banco de dados H2  
- Spring  
- Lombok  

## Execução  
Utilizando a ferramenta [Travis CI](https://travis-ci.com/) para integração contínua e implantação contínua, disponibilizei a aplicação no [Heroku](https://www.heroku.com/) na seguinte URL: conpay-estacionamentoapi.herokuapp.com

Caso queira executar o projeto localmente as instruções a seguir:

### Linux
Entre no diretorio do projeto execute o seguinte comando no terminal:  
```shell script
./mvnw spring-boot:run
```

### Windows
Entre no diretorio do projeto execute o seguinte comando no CMD:    
```
START > RUN mvnw.cmd spring-boot:run
```