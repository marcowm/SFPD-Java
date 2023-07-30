# [SFPD-Java](Sistema de filas para processamento de dados)
# [SFPD-Java]()
> Backend em java desenvolvido como atividade avaliativa da disciplina de TCC.
> Pós Graduação em Arquitetura de sistemas distribuídos.
> Pontifícia Universidade Católica de Minas Gerais (PUC - MG).
> 
> O processo de desenvolvimento utilizou ferramentas de organização de projetos, teorias de arquitetura de software e conhecimentos de sistemas de banco de dados e filas de mensagens.

## Sobre o projeto
> Este repositório conta com o script SQL para criação e população do esquema relacional do banco de dados SFPD, assim como o código fonte da API para interação com o banco de dados e demais serviços.

### Ferramentas utilizadas
* VSCODE
* IntelliJ IDEA
* ActiveMQ
* Prometheus

## Como usar esse projeto

### Pré-requisitos

#### Para a execução do MySQL
* MySQL Database

#### Para execução dos serviços em Java

* Java 8
* Maven
* Spring Boot ( version 2.4.3 utilizada no exemplo )
* Prometheus ( prometheus - version - 2.45.0 )
* ActiveMQ ( apache-activemq - version - 5.16.5 )

### Instalação

1. Clone o repositório
	`git clone https://github.com/marcowm/SFPD-Java.git`

	> Você terá a seguinte estrutura de diretórios:

```
      .
      ├── database
      │   ├── script.sql
      │
      ├── src
      │   ├── main
      |   |    ├── java/sfpd
      |   │    │    ├── configs
      |   │    │    ├── controller
      |   │    │    ├── dto
      │   │    |    ├── enums
      │   │    |    ├── exceptions
      |   │    │    ├── listener
      │   │    │    ├── modelo
      │   │    │    ├── pojo
      │   │    │    ├── repository
      |   |    │    ├── service
      |   |    │    ├── utils
      │   |    ├── resources
      │   ├── pom.xml
      │   ├── README.md
      │   └── ...
      │
```


2. Execute o script para criação e população do banco de dados de exemplo do sistema.

3. Após a criação e população do banco de dados, é hora de executar a API.
	* Execute o serviço do mysql:
		`mysql start via linha de comando ou podendo também fazer uso de uma interface gráfica como o Mysql Workbench`
	* Execute o serviço do ActiveMq para gerenciar a criação e uso de filas:
		`para o exemplo demonstrado foram criadas 2 filas com o nome "fila1" e "fila2" `
	* Execute o serviço do Prometheus(Opcional) para gerenciar as métricas estipuladas

	Agora basta executar o projeto java em uma IDE como o Intellij idea ou Eclipse para ter a API Rest funcionando no endereço `http://localhost:8080`

4. Agora chegou a hora de inicializar a interface web, para tal execute o comando: 
	* npm start ou fazer uso do angular cli conforme já mencionado no projeto sfpd angular.
		``
5. Agora basta acessar no seu navegador o endereço `http://localhost:port`
   
