# cadastro-anuncios
Desafio técnico Capgemini

## Instalação

A aplicação foi configurada pra ser executada com o Maven, portanto será necessário a instalação dessa ferramenta.

> Instalando o Maven: [https://maven.apache.org/install.html](https://maven.apache.org/install.html).

### Clonando o repositório:

```bash
$ git clone https://github.com/EmanuelleBrasil/cadastro-anuncios.git
```

### Compilando e empacotando a aplicação

```bash
$ cd cadastro-anuncios
$ mvn compile
$ mvn package
```

### Executando a aplicação

```bash
$ cd cadastro-anuncios
$ mvn spring-boot:run
```

> Para testar se a aplicação está em execução, acesse o endereço ```http://localhost:8080/ads```.
> A resposta deve ser um JSON com os anúncios já salvos no banco de dados.


## Endpoints

Após executar a aplicação, você pode acessar a documentação da API, contendo os endpoints implementados, no endereço ```http://localhost:8080/swagger-ui.html```.

