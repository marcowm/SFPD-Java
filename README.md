# SFPD-Java ( Sistema de filas para processamento de dados )

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
* Spring Boot
* Prometheus ( prometheus - version - 2.45.0 )
* ActiveMQ ( apache-activemq - version - 5.16.5 )

### Instalação

1. Clone o repositório
	`git clone https://github.com/marcowm/SFPD-Java.git`

	Você terá a seguinte estrutura de diretórios:

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


2. Execute o script para criação e população do banco de dados Clinica Médica. Cujo diagrama está representado abaixo:
	
	![esquema clínica médica](https://raw.githubusercontent.com/jsvitor/iaad-bsi-ufrpe/main/semana%2005-06/clinica_medica_diagram.png)

3. Após a criação e população do banco de dados clinica médica, é hora de executar a API.
	* Dentro do diretório 'web-service', execute:
		`yarn install`
	* Com as dependências instaladas, execute:
		`yarn dev`
	Agora você tem a API Rest funcionando no endereço `http://localhost:3333`

4. Agora chegou a hora de inicializar a interface web, para tal execute o comando: 
	* npm start 
		``
	* xxxxxxxxxxxx
		``

5. Agora basta acessar no seu navegador o endereço `http://localhost:port`



# Como usar a API

## Medico

### Listar os 10 primeiros registros médicos

````GET```` ``/medico``


### Criar um registro de médico

```POST``` ``/medico``

``BODY``

````json
{
      "name": "Arlindo",
      "gender": "M",
      "phone": "81995374530",
      "email": "arlindo@hr.com",
      "codEspec": 3001
}
````


### Alterar um registro de médico usando o CodMed

```PUT``` ``/medico/:codmed``

#### Body

```json
{
      "name": "José"
}
```


### Deletar um registro de Médico

```DELETE``` ```/medico/:codmed```


## Especialidade

### Listar os 10 primeiros registros  de Especialidade

````GET```` ``/specialty``


### Criar um registro de Especialidade

```POST``` ``/specialty``

``BODY``

````json
{
	"CodEspec":"005410",
	"NomeEspec": "Oftalmologia",
	"Descricao": "Epecialidade que cuida da saude dos olhos."
}
````


### Alterar um registro de Especialidade usando o CodEspec

```PUT``` ``/specialty``

#### Body

```json
{
	"CodEspec":"06791",
	"column": "NomeEspec",
	"value": "Pediatria1"
}
```


### Deletar um registro de Especialidade

```DELETE``` ```/specialty```

#### Body

```json
{
	"CodEspec":"06791"
}
```


### 

## 

## Consultas avançadas

### Receber todas as clinicas que trabalham com uma especialidade

````GET```` ``/advancedquery/clinic``

``BODY``

````json
{
	"NomeEspec":"Ordontologista",
}
````

#### ``Query``

```sql
SELECT NomeCli, clinica.Endereco, clinica.Telefone, clinica.Email 
FROM clinica 
INNER JOIN medico, especialidade, clinicamedico 
WHERE clinica.CodCli = clinicamedico.CodCli AND medico.CodMed = clinicamedico.CodMed AND medico.CodEspec = especialidade.CodEspec and especialidade.NomeEspec = "${NomeEspec}" 
GROUP BY NomeCli, NomeEspec;
```








## Requisitos da aplicação
- [ ] A escolha da linguagem de programação é livre (python, dart, java, php, javascript, entre outras), mas o BD deve ser o MySQL.

- [ ] O sistema deve contemplar as quatro operações básicas de CRUD (Create, Read, Update e Delete).

- [ ] Incluir no sistema pelo menos um trigger e um stored procedure. 

- [ ] Incluir no sistema no mínimo duas consultas, envolvendo junções, funções de agregação e agrupamentos. 

- [ ] O banco de dados deve estar populado.

- [ ] O sistema deve dispor de interface gráfica, seja web, mobile ou desktop.


## Tarefas

### Gravar o vídeo mostrando o funcionamento da aplicação

### Interface
- [x] Protótipo no Figma

### Web service
- [x] CRUD de medico
- [ ] CRUD de clinica
- [x] CRUD de paciente
- [ ] CRUD de agendaConsulta
- [ ] CRUD clinicamedico

- [x] Configuração do ambiente de desenvolvimento
- [x] Criar as rotas para médico
- [x] Fazer a conexão com o banco de dados mysql
- [x] Documentar
