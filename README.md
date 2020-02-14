# MARVEL API
## OBJETIVO
Desenvolver uma api que imite o comportamento da api original. <br>
[https://developer.marvel.com/docs](https://developer.marvel.com/docs)
## REQUISITOS
- [Docker](https://www.docker.com)
## DESCRIÇÃO
O aplicativo disponibiliza um serviço HTTP na porta padrão **8080**, que possui os endpoints<br>

* :ballot_box_with_check: GET /v1/public/characters
    * Funcional, necessária melhoria nos testes unitários
    * Melhoria na validação dos parametros da uri  
* :ballot_box_with_check: GET /v1/public/characters/{characterId}
    * Funcional, necessária melhoria nos testes unitários
    * Melhoria na validação dos parametros da uri
* :black_square_button: GET /v1/public/characters/{characterId}/comics
    * Implementação pendente
* :black_square_button: GET /v1/public/characters/{characterId}/events
    * Implementação pendente
* :black_square_button: GET /v1/public/characters/{characterId}/series
    * Implementação pendente
* :black_square_button: GET /v1/public/characters/{characterId}/stories
    * Implementação pendente 

## TECNOLOGIA
* Linguagem
    * [Java Spring Boot](https://spring.io/projects/spring-boot)  

* Base de dados
    * [H2 Database](https://www.h2database.com/html/main.html)

* Build tool 
    * [Gradle](https://gradle.org)  
## BUILD
Na pasta raiz do projeto execute em um terminal:<br>
>
> docker build . -t arl-marvel-api<br>
>
Será realizado o download de dependências, build e testes unitários do projeto <br>
Em caso de sucesso será disponibilizada uma imagem docker com o nome de **arl-marvel-api**
## EXECUÇÃO
Após o processo de build, execute em um terminal: <br>
>
>docker run -d -p {$PORTA}:8080 arl-marvel-api
>
{$PORTA} = Porta disponivel para execução do serviço