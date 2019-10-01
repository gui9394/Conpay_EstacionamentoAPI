# Estacionamento de Carros  
Conpay - Desafio processo seletivo  
Repositório: [GitHub](https://github.com/dangellys-conpay/desafio-estacionamento)  

## Descrição  
API para gerenciamento de carros de em um estacionamento.

## Endpoints  

### GET [/vagas](https://conpay-estacionamentoapi.herokuapp.com/vagas)
JSON Lista com todas as vagas  
método:  
retorno:
```json
[
    {
        "id": 1,
        "nome": "1",
        "estado": "LIVRE"
    },
    {
        "id": 2,
        "nome": "2",
        "estado": "LIVRE"
    }
]
```
### [/vagas](https://conpay-estacionamentoapi.herokuapp.com/vagas?id=2)