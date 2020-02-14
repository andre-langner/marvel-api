# MARVEL API
## OBJETIVO
Desenvolver uma api que imite o comportamento da api original. <br>
[https://developer.marvel.com/docs](https://developer.marvel.com/docs)
## REQUISITOS PARA EXECUÇÃO
- [Docker](https://www.docker.com)
## TECNOLOGIA
* Linguagem
    * [Java Spring Boot](https://spring.io/projects/spring-boot)  

* Base de dados
    * [H2 Database](https://www.h2database.com/html/main.html)

* Build tool 
    * [Gradle](https://gradle.org) 
## DESCRIÇÃO
O aplicativo disponibiliza um serviço HTTP, que possui os endpoints:<br>

* :ballot_box_with_check: GET /v1/public/characters
    * Funcional
    * Necessária melhoria nos testes unitários
    * Pendente melhoria na validação dos parametros da uri  
* :ballot_box_with_check: GET /v1/public/characters/{characterId}
    * Funcional
    * Necessária melhoria nos testes unitários
    * Pendente melhoria na validação dos parametros da uri
* :black_square_button: GET /v1/public/characters/{characterId}/comics
    * Realizada implementação para recuperar as informações básicas
    * Implementação pendente: recuperar as coleções relacionadas 
    * Pendente melhoria na validação dos parametros da uri
* :black_square_button: GET /v1/public/characters/{characterId}/events
    * Implementação pendente
* :black_square_button: GET /v1/public/characters/{characterId}/series
    * Implementação pendente
* :black_square_button: GET /v1/public/characters/{characterId}/stories
    * Implementação pendente  
## BUILD
> **Necessária disponibilidade de conexão com a internet**

Na pasta raiz do projeto execute em um terminal:<br>
>
> docker build . -t arl-marvel-api<br>
>
Será realizado o download de dependências, build e testes unitários do projeto <br>
Em caso de sucesso será disponibilizada uma imagem docker com o nome de **arl-marvel-api**
## EXECUÇÃO 
> **Não é necessária conexão com a internet**

Após o processo de build, execute em um terminal: <br>
>
>docker run -d -p {$PORTA}:8080 arl-marvel-api
>
***{$PORTA} = Porta disponivel para execução do serviço***<br>

## TESTES
É possível executar testes na api utilizando qualquer ferramenta que possa realizar uma requisição http GET. <BR>
A API utiliza as regras disponíveis no descritas no link da API original.