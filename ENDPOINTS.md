# Endpoints

## Vagas

### GET Buscar uma vaga  
```
conpay-estacionamentoapi.herokuapp.com/vagas?id=1  
```

Parâmetros  
- id - Id da vaga para consulta

### GET Listar vagas
```
conpay-estacionamentoapi.herokuapp.com/vagas
```

### GET Listar vagas disponíveis
```
conpay-estacionamentoapi.herokuapp.com/vagas/disponiveis
```

### GET Quantidade de vagas disponíveis
```
conpay-estacionamentoapi.herokuapp.com/vagas/disponiveis/quantidade
```

## Tickets

### GET Buscar ticket
```
conpay-estacionamentoapi.herokuapp.com/tickets/?id=17
```

Parâmetros  
- id - Id do ticket para consulta

### GET Listar tickets
```
conpay-estacionamentoapi.herokuapp.com/tickets
```

### GET Listar tickets em aberto
```
conpay-estacionamentoapi.herokuapp.com/tickets/abertos
```

### POST Emitir novo ticket
```
conpay-estacionamentoapi.herokuapp.com/tickets/emitir?vaga_id=8
```

Parâmetros  
- vaga_id - Id da vaga livre para emitir o ticket

### PUT Finalizar ticket
```
conpay-estacionamentoapi.herokuapp.com/tickets/finalizar?id=17
```

Parâmetros  
- id - Id do ticket a ser finalizado

## Relatórios

### GET Histórico
```
conpay-estacionamentoapi.herokuapp.com/relatorios/historico
```
