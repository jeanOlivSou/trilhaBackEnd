# Desafio 14 - Desafio Final 

## - Resumo geral de todos os desafios da trilha Cybertron

###  Desafio 1 - Git:

- **D� 2 exemplos de situa��es onde � necess�rio utilizar merge :**

  > R - O Merge pode ser utilizado no momento em que o trabalho em uma branch est� conclu�do
  > e deseja mesclar com o c�digo principal ou quando deseja verificar se o projeto da determinada
  > branch entre em conflito com o c�digo da branch principal.

- **Qual a diferen�a entre ``` git add -all```, ```git add  -u```, ```git add -A```, ``` git add .``` :**
    
    - ``` git add -all``` - *Coloca todos os arquivos (novos, modificados e removidos) no index/stage.*
    - ```git add -A``` - *Coloca todos os arquivos na �rvore de trabalho sendo atualizados seja em diret�rio ou subdiret�rio.*
    - ``` git add .``` - *Coloca todos os novos arquivos no index/stage que pertence somente ao diret�rio atual.*
    - ```git add  -u``` - *Atualiza os arquivos no index/stage (modificados e removidos).*


- **Qual � a ordem dos comandos para subir novas atualiza��es, verificando se existem altera��es a serem recebidas? :**

  > R - Entre no diret�rio desejado e primeiramente execute *git status* para verificar quais 
  > modifica��es ser�o atualizadas e para adcion�-los execute o comando *git add .* para efetivar
  > as altera��es e realize um commit *git commit -m "Sua mensagem"* para documentar suas altera��es.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 1? Se n�o, justifique :**

  > R - Sim, pois os questionamentos te�ricos me incentivaram a pesquisar mais sobre Git.



### Desafio 2 - POO e Entity:

- **Qual � a finalidade da camada Entity? :**

  > R - A camada de entity � a camada de abstra��o da aplica��o que tem a finalidade representar
  > os dados que ser�o mapeados e persistido pela camada de persist�ncia.

- **Para voc�, por que acha que seguimos a programa��o orientada a objetos? :**

  > R - Porque � o paradigma que nos possibilita abstrair solu��es atrav�s do mundo real
  > e estruturar o c�digo de forma que o desenvolvedor use boas pr�ticas evitando que tenha
  > c�digo repitido.



- **Qual � o ideal por tr�s de utilizar os m�todos getters e setters? :**

  > R - Para servir ao princ�pio do encapsulamento que visa esconder a implementa��o
  > de um objeto que n�o propriamente contribui para as suas caracter�sticas essenciais
  > logo para ter acesso necessita definir os getters e setters.

- **Qual o prop�sito de um construtor em uma classe? Podemos criar uma classe sem construtor? :**

  > R - O construtor de uma classe faz parte do instanciamento de um objeto da classe, quando na classe
  > n�o h� construtor, a linguagem se encarrega de criar um construtor padr�o(Sem argumentos) implicitamente.
  
- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 2? Se n�o, justifique :**

  > R - Esse desafio me permitiu revisar os conceitos de POO e seus pilares bem como
  > principios de boas pr�ticas para defini��o da camada de Entity.



### Desafio 3 - HTTP, REST e Controller:

- **Qual � o objetivo da camada Controller? :**

  > R - Controller � a camada que gerencia e mapeia as requisi��es
  > enviadas pelo lado cliente.
  
- **No que os padr�es REST nos auxiliam? :**

  > R - O REST auxiliam na defini��o das solicita��es HTTP de forma simples.

- **Quais m�todos HTTP utilizamos para montar um CRUD?**

  > R - GET, POST, PUT(ou PATCH), DELETE.

- **Qual a diferen�a entre as annotations @PathVariable, @RequestParam, @RequestBody? E com quais m�todos HTTP elas podem ser utilizadas respectivamente?**

  > R - *@Pathvariable* indica que a vari�vel ser� passada na URI do endpoint geralmente usando com os verbos
  > GET, PUT e DELETE, *@RequestParam* extrai valores atrav�s de par�metros requisitados na URL geralmente 
  > utilizado com o verbo GET para consultas personalizadas, e porfim *@RequestBody* que auxilia no envio de
  > objeto solicitado no corpo das requisi��es POST, PUT, PATCH.

- **Para que serve ResponseEntity? :**

  > R - O ResponseEntity auxilia na manipula��o e gest�o de respostas(Responses) HTTP
  > comportando informa��es de cabe�alho, c�digo de status e o corpo do objeto retornado
  > na requisi��o.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 3? Se n�o, justifique :**

  > R - Esse desafio possibilitou aprender mais sobre o protocolo de aplica��o HTTP e suas requisi��es
  > bem como boas pr�ticas na camada de controller.


### Desafio 4 - JPA e Repository:

- **Qual � o prop�sito da camada Repository? :**

  > R - A camada de Repository intermedia as camadas de acesso a dados e a camada de neg�cios.

- **De maneira pr�tica como funciona a inje��o do Repository? E qual a sua rela��o com @Autowired? :**

  > R - O padr�o de inje��o de depend�ncias visa remover depend�ncias desnecess�rias entre as classes,
  > e o *@Autowired* realiza essa inje��o de depend�ncias sem precisar injetar via construtor.

- **Quais s�o as facilidades em utilizar JPA?**
  
  - Defini��o de interfaces para acesso a dados de forma simples
  - Facilidade em definir consultas personalizadas.
  - Configura��o Simples.


- **Quais s�o os passos para configurar um banco de dados em um projeto Spring? :**

  > R - Primeiro defina as configura��es necess�rias do JPA e o banco desejado
  > no arquivo *Application.properties* depois defina suas classes repository.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 4? Se n�o, justifique :**

  > R - Neste desafio foi poss�vel aplicar conceitos a cerca da camada de acesso de uma aplica��o.


###  Desafio 5 - Service:

- **Qual � a finalidade da camada Service? :**

  > R - A camada de service serve �s requisi��es enviadas atr�ves da controller 
  > e possui a implementa��o de regra de neg�cio da aplica��o.

- **Qual o sentido de um m�todo ter apenas um prop�sito?**

  > R - Para oferecer uma regra de neg�cio muito bem definida.

- **Qual a diferen�a entre um m�todo void e m�todos tipados? :**

  > R - Um met�do Void, n�o tem retorno, j� o tipado possui com seu respectivo tipo.
  
- **� normal um servi�o chamar outro? :**

  > R - Sim, pois pode ocorrer regras de neg�cios codependentes.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 5? Se n�o, justifique :**

  > R - Neste desafio foi poss�vel aplicar conceitos a cerca da camada de service de uma aplica��o
  > e suas pr�ticas nas defini��es de regra de neg�cio.



### Desafio 6 - DTO:

- **Quais problemas conseguimos resolver utilizando a camada DTO?**

  > R - Com a utiliza��o de DTO � possivel ter mais flexibilidade pois
  > ele permite ter mais representa��es distintas sobre o mesmo objeto,
  > e a aplica��o fica mais segura e menos sucetivel a ataques, pois evita
  > expor dados sens�veis.

- **Qual a diferen�a de realizarmos o �de para� utilizando constructor ou getters e setters? :**

  > R - Com as convers�es De/para no DTO via construtores, getters e setters,
  > a possibilidade das classes de entidades e DTOs ficarem menos enxutas s�o
  > maiores.

- **No que a utiliza��o do Mapper nos auxilia? Achou f�cil a implementa��o? :**

  > R - Mappers nos ajudam a converter DTOs em objeto de entidade e vice versa 
  > atrav�s de implementa��o simples de interfaces.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 6? Se n�o, justifique :**

  > R - Neste desafio foi poss�vel aplicar conceitos a cerca do padr�o DTO, e reconhecer a sua import�ncia
  > quanto a seguran�a da informa��o.

### Desafio 7 - Manipula��o de dados:

- **Qual � a forma de validar os dados de uma requisi��o sem utilizar @Valid? :**

  > R - Atrav�s da camada de service com estruturas de decis�o ou try/catch.

- **Para que serve um ENUM? Cite exemplos :**

  > R - Enum � um tipo de dado que consiste valores predefinidos em constantes, que n�o necessariamente precisam
  > de uma especializa��o por meio de heran�a. 

- **Como criamos um custom validator? E qual o objetivo de criar um? :**

  > R - � poss�vel fazer valida��es customizadas atrav�s de interfaces para o fim 
  > de fazer valida��es espec�ficas mais limpas.

- **Qual foi a diferen�a entre utilizar for e streams no desafio 6?**

  > R - Com o uso de Streams � poss�vel otimizar a perfomance da aplica��o, assim como
  > deixa o c�digo mais limpo.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 7? Se n�o, justifique :**

  > R - Neste desafio foi poss�vel aplicar conceitos a cerca de manipula��o e valida��o de 
  > dados a fim de deixa a aplica��o menos sucest�vel a bugs.


### Desafio 8 - Tratamento de exceptions:

- **Qual a finalidade de trata-las? :**

  > R - Tratar uma exce��o torna um erro mais apresent�vel para que todos
  > possam compreender o que ocorreu de maneira f�cil.

- **Como as descobrimos?**

  > R - A maneira mais f�cil e pr�tica de descobrir uma exce��o � testando sua
  > aplica��o manualmente de forma que gere um erro intencionalmente um erro.

- **Como fazemos para estourar um exception em uma determinada linha? :**

  > R - Definindo um breakpoint na linha desejada e rodar a aplica��o no modo de depura��o(Debug).

- **Qual � a melhor forma de implementarmos nosso controle de exce��es?**

  > R - Defina as suas classes de ControllerAdvicer e dentro da classe programe
  > os metodos Exception Handler que ir�o tratar as tais exce��es.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 8? Se n�o, justifique :**

  > R - Neste desafio foi poss�vel aplicar conceitos a cerca de tratamentos de exce��es
  > de forma que eles fiquem mais compreens�veis caso aconte�a.

### Desafio 9 - Patterns, SOLID e Arquitetura:

- **O que � Singleton Pattern? :**

  > R - O padr�o Singleton define que uma classe tenha apenas uma inst�ncia de si mesma.

- **O que significa a letra D de SOLID e como se aplica na camada de Repository? :**

  > R - O "D" corresponde ao Princ�pio de invers�o de depend�ncias, que visa o desacoplamento
  > em aplica��es e se aplica a camada de repository pois � implementada atrav�s de interfaces.

- **Qual o objetivo das camadas? :**

  > R - Separar uma aplica��o em camadas tem como objetivo ter responsabilidade
  > �nicas bem estruturadas em cada camada.

- **Qual arquitetura � melhor DDD, Hexagonal ou Clean? :**

  > R - Hexagonal porque visa desacoplamento majorit�rio de tecnologias
  > possibilitando mais flexibilidade e manutenibilidade do c�digo da aplica��o.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 9? Se n�o, justifique :**

  > R - Tive um pouco de dificuldade na implementa��o de arquitetura hexagonal por que foi um conceito
  > novo para mim mas conseguir expandir um pouco mais meu conhecimento sobre arquitetura de software.

### Desafio 10 - Spring:

- **Qual a diferen�a entre Java e Spring?**

  > R -  Java � uma linguagem de programa��o e o spring � um framework que utiliza java em sua implementa��o.

- **� poss�vel utilizar Spring Data sozinho? :**

  > R - N�o, pois a camada de acesso a dados necessita do driver
  > de um banco e a uma API de implementa��o de BD.

- **� poss�vel utilizar Spring Boot, Spring Data e Spring Security em apenas um projeto?**

  > R - Sim, isso � definido no projeto atrav�s de suas camadas e inje��o de depend�ncia.
  
- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 10? Se n�o, justifique**

  > R - Nesse desafio possibilitou conhecer mais internamente o Spring Framework e seus componentes.
  

### Desafio 11 - Libs:

- **Cite 5 libs que utilizou durante a trilha e suas respectivas funcionalidades:**

    - Lombok - Define automaticamente contrutores, getters e setters
    - H2 Driver - Driver do banco de dados usado para persist�ncia do projeto.
    - Mapstruct - Defini��o de mappers usado na convers�o de DTOs.
    - Bean Validation - Valida��o de dados.
    - Junit 5 - Testes unit�rios.


- **Qual a diferen�a entre uma lib e um driver? :**

  > R - O driver � uma lib mas com implementa��o de banco de dados enquanto uma lib
  > em geral possui outro tipo de implementa��o.
  
- **Existe limite de libs por projeto? :**

  > R - N�o, mas como boa pr�tica inclua no seu projeto somente libs que voc� tenha
  > certeza que vai utilizar.

- **Por que utilizar um gerenciador de depend�ncias? :**

  > R - O gerenciador de depend�ncias facilita a inclus�o de libs no projeto.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 11? Se n�o, justifique :**

  > R - Nesse desafio foi poss�vel conhecer mais a respeito das libs Java.

### Desafio 12 - Testes unit�rios:

- **Por que DEVOPS exige uma porcentagem de cobertura m�nima nos projetos?**

  > R - Porque no devops h� testes de qualidade de testes.

- **Qual o objetivo de utilizar Mockito? D� um exemplo :**

  > R - O mockito � utilizado para simular dados sem interferir 
  > na aplica��o principal bem como montar cen�rios para preparar
  > o teste baseado no mantra When ... then.

- **O que � o Sonar? E qual � o seu papel?**

  > R - Sonar � uma ferramenta de qualidade de software que
  > faz a medi��o atrav�s de relat�rios.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 12? Se n�o, justifique :**

  > R - Tive um pouco de dificuldade ao implementar testes unit�rios por conhecer mais em teoria, mas com
  > ajuda do tutor da trilha consegui ter um entendimento maior.

### Desafio 13 - Integra��o:

- **Como foi o processo de integra��o?**

  > R - Em geral foi uma boa experi�ncia integrar o back com o front-end
  > e ver o sistema funcionando completo, a ferramenta do desenvolvedor
  > foi fundamental na integra��o.

- **Quais foram as principais dificuldades?**

  > R - a principal dificuldade foi o front-end n�o se adequar
  > corretamente com o back-end, tanto que necessitou de algumas
  > altere��es com ajuda do tutor.

- **Obteve algum erro de CORS?**

  > R - Ao tentar realizar a integra��o me deparei com um erro como:
  > "A requisi��o foi bloqueada pelas pol�ticas do CORS."

- **O que � CORS?**

  > R - � um mecanismo usado para adicionar cabe�alhos HTTP que informam aos navegadores para permitir que uma aplica��o Web 
  > seja executada em uma origem e acesse recursos de outra origem diferente.

- **Voc� conseguiu adquirir os conhecimentos transmitidos durante o desafio 13? Se n�o, justifique :**

  > R - Apesar de ter feito a integra��o pela primeira, adquiri muito conhecimento a respeito.


#### Refer�ncias: 

[https://git-scm.com/book/pt-pt/v2/Ferramentas-do-Git-Advanced-Merging](https://git-scm.com/book/pt-pt/v2/Ferramentas-do-Git-Advanced-Merging) \
[https://pt.stackoverflow.com/questions/326160/diferen%C3%A7a-entre-git-add-all-git-add-e-git-add-u](https://pt.stackoverflow.com/questions/326160/diferen%C3%A7a-entre-git-add-all-git-add-e-git-add-u) \
[https://git-scm.com/docs/git-add](https://git-scm.com/docs/git-add) \
[https://www.guj.com.br/t/construtor-e-obrigatorio-numa-classe/83771/4](https://www.guj.com.br/t/construtor-e-obrigatorio-numa-classe/83771/4) \
[https://www.portalgsti.com.br/2017/08/padrao-mvc-arquitetura-model-view-controller.html](https://www.portalgsti.com.br/2017/08/padrao-mvc-arquitetura-model-view-controller.html) \
[https://www.baeldung.com/spring-response-entity](https://www.baeldung.com/spring-response-entity) \
[https://www.guj.com.br/t/dto-usar-ou-nao-usar/141688](https://www.guj.com.br/t/dto-usar-ou-nao-usar/141688) \
[https://www.dtidigital.com.br/blog/principios-solid-o-principio-de-inversao-de-dependencia/](https://www.dtidigital.com.br/blog/principios-solid-o-principio-de-inversao-de-dependencia/) \
[https://www.alura.com.br/artigos/como-resolver-erro-de-cross-origin-resource-sharing](https://www.alura.com.br/artigos/como-resolver-erro-de-cross-origin-resource-sharing) 





