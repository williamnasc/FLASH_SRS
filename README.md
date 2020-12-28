# FLASH_SRS

CRUD feito através de JSF, JPA, Hibernate, PostgreSQL e Primefaces

A página permitie ao usuário cadastrar flashcards para memorização inspirados no método de memorização por repetição espaçada (SRS).Os flashcards são compostos principalmente por um termo e sua definição. É possível também revisar os cards, e a depender do seu desenpenho o tempo em que você precisará revisar cada cartão é alterado.

## Itens Implementados

Os itens do desafio implementados no projeto foram:

* A. Criar uma aplicação java web utilizando JavaServer Faces (JSF)
* B. Utilizar persistência em um banco de dados (qualquer banco desejado)
* C. Utilizar Hibernate e JPA
* F. Utilizar Bootstrap 4
* G. Utilizar Primefaces

## Instruções Para Execução Do Projeto

A aplicação foi desenvolvida na plataforma Eclipse IDE com o servidor Apache Tomcat v8.5. Portanto para rodar a aplicação é necessário possuir essas duas tecnologias, adicionar o projeto ao ambiente e rodar com esse servidor. O banco de dados está online, portanto não há muitas preocupações para configurar-lo.

## Lentidão ao executar o projeto

Para facilitar a o uso do projeto, o banco de dados utilizado está hospedado no Heroku. Porém, por esse motivo a execução do projeto acaba se tornando lenta. Caso queria contornar esse problema basta configurar e utilizar um banco de dados localmente.   

Caso queria utilizar o banco localmente, deverá ser utilizado o PostgreSQL e criar uma database de nome "flash_srs", além disso é necessário configurar o arquivo persistense.xml localizado na pasta /src/main/java/META-INF/.

No arquivo deveram ser alteradas as propriedades url, user e password subistituindo os dados do atribuito "value" para as informações do banco de dados local.
