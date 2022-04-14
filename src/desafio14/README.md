# Desafio 14 - Desafio Final 

## - Resumo geral de todos os desafios da trilha Cybertron

###  Desafio 1 - Git:

- **Dê 2 exemplos de situações onde é necessário utilizar merge :**

  > R - O Merge pode ser utilizado no momento em que o trabalho em uma branch está concluído
  > e deseja mesclar com o código principal ou quando deseja verificar se o projeto da determinada
  > branch entre em conflito com o código da branch principal.

- **Qual a diferença entre ``` git add -all```, ```git add  -u```, ```git add -A```, ``` git add .``` :**
    
    - ``` git add -all``` - *Coloca todos os arquivos (novos, modificados e removidos) no index/stage.*
    - ```git add -A``` - *Coloca todos os arquivos na árvore de trabalho sendo atualizados seja em diretório ou subdiretório.*
    - ``` git add .``` - *Coloca todos os novos arquivos no index/stage que pertence somente ao diretório atual.*
    - ```git add  -u``` - *Atualiza os arquivos no index/stage (modificados e removidos).*


- **Qual é a ordem dos comandos para subir novas atualizações, verificando se existem alterações a serem recebidas? :**

  > R - Entre no diretório desejado e primeiramente execute *git status* para verificar quais 
  > modificações serão atualizadas e para adcioná-los execute o comando *git add .* para efetivar
  > as alterações e realize um commit *git commit -m "Sua mensagem"* para documentar suas alterações.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 1? Se não, justifique :**

  > R - Sim, pois os questionamentos teóricos me incentivaram a pesquisar mais sobre Git.



### Desafio 2 - POO e Entity:

- **Qual é a finalidade da camada Entity? :**

  > R - A camada de entity é a camada de abstração da aplicação que tem a finalidade representar
  > os dados que serão mapeados e persistido pela camada de persistência.

- **Para você, por que acha que seguimos a programação orientada a objetos? :**

  > R - Porque é o paradigma que nos possibilita abstrair soluções através do mundo real
  > e estruturar o código de forma que o desenvolvedor use boas práticas evitando que tenha
  > código repitido.



- **Qual é o ideal por trás de utilizar os métodos getters e setters? :**

  > R - Para servir ao princípio do encapsulamento que visa esconder a implementação
  > de um objeto que não propriamente contribui para as suas características essenciais
  > logo para ter acesso necessita definir os getters e setters.

- **Qual o propósito de um construtor em uma classe? Podemos criar uma classe sem construtor? :**

  > R - O construtor de uma classe faz parte do instanciamento de um objeto da classe, quando na classe
  > não há construtor, a linguagem se encarrega de criar um construtor padrão(Sem argumentos) implicitamente.
  
- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 2? Se não, justifique :**

  > R - Esse desafio me permitiu revisar os conceitos de POO e seus pilares bem como
  > principios de boas práticas para definição da camada de Entity.



### Desafio 3 - HTTP, REST e Controller:

- **Qual é o objetivo da camada Controller? :**

  > R - Controller é a camada que gerencia e mapeia as requisições
  > enviadas pelo lado cliente.
  
- **No que os padrões REST nos auxiliam? :**

  > R - O REST auxiliam na definição das solicitações HTTP de forma simples.

- **Quais métodos HTTP utilizamos para montar um CRUD?**

  > R - GET, POST, PUT(ou PATCH), DELETE.

- **Qual a diferença entre as annotations @PathVariable, @RequestParam, @RequestBody? E com quais métodos HTTP elas podem ser utilizadas respectivamente?**

  > R - *@Pathvariable* indica que a variável será passada na URI do endpoint geralmente usando com os verbos
  > GET, PUT e DELETE, *@RequestParam* extrai valores através de parâmetros requisitados na URL geralmente 
  > utilizado com o verbo GET para consultas personalizadas, e porfim *@RequestBody* que auxilia no envio de
  > objeto solicitado no corpo das requisições POST, PUT, PATCH.

- **Para que serve ResponseEntity? :**

  > R - O ResponseEntity auxilia na manipulação e gestão de respostas(Responses) HTTP
  > comportando informações de cabeçalho, código de status e o corpo do objeto retornado
  > na requisição.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 3? Se não, justifique :**

  > R - Esse desafio possibilitou aprender mais sobre o protocolo de aplicação HTTP e suas requisições
  > bem como boas práticas na camada de controller.


### Desafio 4 - JPA e Repository:

- **Qual é o propósito da camada Repository? :**

  > R - A camada de Repository intermedia as camadas de acesso a dados e a camada de negócios.

- **De maneira prática como funciona a injeção do Repository? E qual a sua relação com @Autowired? :**

  > R - O padrão de injeção de dependências visa remover dependências desnecessárias entre as classes,
  > e o *@Autowired* realiza essa injeção de dependências sem precisar injetar via construtor.

- **Quais são as facilidades em utilizar JPA?**
  
  - Definição de interfaces para acesso a dados de forma simples
  - Facilidade em definir consultas personalizadas.
  - Configuração Simples.


- **Quais são os passos para configurar um banco de dados em um projeto Spring? :**

  > R - Primeiro defina as configurações necessárias do JPA e o banco desejado
  > no arquivo *Application.properties* depois defina suas classes repository.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 4? Se não, justifique :**

  > R - Neste desafio foi possível aplicar conceitos a cerca da camada de acesso de uma aplicação.


###  Desafio 5 - Service:

- **Qual é a finalidade da camada Service? :**

  > R - A camada de service serve às requisições enviadas atráves da controller 
  > e possui a implementação de regra de negócio da aplicação.

- **Qual o sentido de um método ter apenas um propósito?**

  > R - Para oferecer uma regra de negócio muito bem definida.

- **Qual a diferença entre um método void e métodos tipados? :**

  > R - Um metódo Void, não tem retorno, já o tipado possui com seu respectivo tipo.
  
- **É normal um serviço chamar outro? :**

  > R - Sim, pois pode ocorrer regras de negócios codependentes.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 5? Se não, justifique :**

  > R - Neste desafio foi possível aplicar conceitos a cerca da camada de service de uma aplicação
  > e suas práticas nas definições de regra de negócio.



### Desafio 6 - DTO:

- **Quais problemas conseguimos resolver utilizando a camada DTO?**

  > R - Com a utilização de DTO é possivel ter mais flexibilidade pois
  > ele permite ter mais representações distintas sobre o mesmo objeto,
  > e a aplicação fica mais segura e menos sucetivel a ataques, pois evita
  > expor dados sensíveis.

- **Qual a diferença de realizarmos o “de para” utilizando constructor ou getters e setters? :**

  > R - Com as conversões De/para no DTO via construtores, getters e setters,
  > a possibilidade das classes de entidades e DTOs ficarem menos enxutas são
  > maiores.

- **No que a utilização do Mapper nos auxilia? Achou fácil a implementação? :**

  > R - Mappers nos ajudam a converter DTOs em objeto de entidade e vice versa 
  > através de implementação simples de interfaces.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 6? Se não, justifique :**

  > R - Neste desafio foi possível aplicar conceitos a cerca do padrão DTO, e reconhecer a sua importância
  > quanto a segurança da informação.

### Desafio 7 - Manipulação de dados:

- **Qual é a forma de validar os dados de uma requisição sem utilizar @Valid? :**

  > R - Através da camada de service com estruturas de decisão ou try/catch.

- **Para que serve um ENUM? Cite exemplos :**

  > R - Enum é um tipo de dado que consiste valores predefinidos em constantes, que não necessariamente precisam
  > de uma especialização por meio de herança. 

- **Como criamos um custom validator? E qual o objetivo de criar um? :**

  > R - é possível fazer validações customizadas através de interfaces para o fim 
  > de fazer validações específicas mais limpas.

- **Qual foi a diferença entre utilizar for e streams no desafio 6?**

  > R - Com o uso de Streams é possível otimizar a perfomance da aplicação, assim como
  > deixa o código mais limpo.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 7? Se não, justifique :**

  > R - Neste desafio foi possível aplicar conceitos a cerca de manipulação e validação de 
  > dados a fim de deixa a aplicação menos sucestível a bugs.


### Desafio 8 - Tratamento de exceptions:

- **Qual a finalidade de trata-las? :**

  > R - Tratar uma exceção torna um erro mais apresentável para que todos
  > possam compreender o que ocorreu de maneira fácil.

- **Como as descobrimos?**

  > R - A maneira mais fácil e prática de descobrir uma exceção é testando sua
  > aplicação manualmente de forma que gere um erro intencionalmente um erro.

- **Como fazemos para estourar um exception em uma determinada linha? :**

  > R - Definindo um breakpoint na linha desejada e rodar a aplicação no modo de depuração(Debug).

- **Qual é a melhor forma de implementarmos nosso controle de exceções?**

  > R - Defina as suas classes de ControllerAdvicer e dentro da classe programe
  > os metodos Exception Handler que irão tratar as tais exceções.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 8? Se não, justifique :**

  > R - Neste desafio foi possível aplicar conceitos a cerca de tratamentos de exceções
  > de forma que eles fiquem mais compreensíveis caso aconteça.

### Desafio 9 - Patterns, SOLID e Arquitetura:

- **O que é Singleton Pattern? :**

  > R - O padrão Singleton define que uma classe tenha apenas uma instância de si mesma.

- **O que significa a letra D de SOLID e como se aplica na camada de Repository? :**

  > R - O "D" corresponde ao Princípio de inversão de dependências, que visa o desacoplamento
  > em aplicações e se aplica a camada de repository pois é implementada através de interfaces.

- **Qual o objetivo das camadas? :**

  > R - Separar uma aplicação em camadas tem como objetivo ter responsabilidade
  > únicas bem estruturadas em cada camada.

- **Qual arquitetura é melhor DDD, Hexagonal ou Clean? :**

  > R - Hexagonal porque visa desacoplamento majoritário de tecnologias
  > possibilitando mais flexibilidade e manutenibilidade do código da aplicação.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 9? Se não, justifique :**

  > R - Tive um pouco de dificuldade na implementação de arquitetura hexagonal por que foi um conceito
  > novo para mim mas conseguir expandir um pouco mais meu conhecimento sobre arquitetura de software.

### Desafio 10 - Spring:

- **Qual a diferença entre Java e Spring?**

  > R -  Java é uma linguagem de programação e o spring é um framework que utiliza java em sua implementação.

- **É possível utilizar Spring Data sozinho? :**

  > R - Não, pois a camada de acesso a dados necessita do driver
  > de um banco e a uma API de implementação de BD.

- **É possível utilizar Spring Boot, Spring Data e Spring Security em apenas um projeto?**

  > R - Sim, isso é definido no projeto através de suas camadas e injeção de dependência.
  
- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 10? Se não, justifique**

  > R - Nesse desafio possibilitou conhecer mais internamente o Spring Framework e seus componentes.
  

### Desafio 11 - Libs:

- **Cite 5 libs que utilizou durante a trilha e suas respectivas funcionalidades:**

    - Lombok - Define automaticamente contrutores, getters e setters
    - H2 Driver - Driver do banco de dados usado para persistência do projeto.
    - Mapstruct - Definição de mappers usado na conversão de DTOs.
    - Bean Validation - Validação de dados.
    - Junit 5 - Testes unitários.


- **Qual a diferença entre uma lib e um driver? :**

  > R - O driver é uma lib mas com implementação de banco de dados enquanto uma lib
  > em geral possui outro tipo de implementação.
  
- **Existe limite de libs por projeto? :**

  > R - Não, mas como boa prática inclua no seu projeto somente libs que você tenha
  > certeza que vai utilizar.

- **Por que utilizar um gerenciador de dependências? :**

  > R - O gerenciador de dependências facilita a inclusão de libs no projeto.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 11? Se não, justifique :**

  > R - Nesse desafio foi possível conhecer mais a respeito das libs Java.

### Desafio 12 - Testes unitários:

- **Por que DEVOPS exige uma porcentagem de cobertura mínima nos projetos?**

  > R - Porque no devops há testes de qualidade de testes.

- **Qual o objetivo de utilizar Mockito? Dê um exemplo :**

  > R - O mockito é utilizado para simular dados sem interferir 
  > na aplicação principal bem como montar cenários para preparar
  > o teste baseado no mantra When ... then.

- **O que é o Sonar? E qual é o seu papel?**

  > R - Sonar é uma ferramenta de qualidade de software que
  > faz a medição através de relatórios.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 12? Se não, justifique :**

  > R - Tive um pouco de dificuldade ao implementar testes unitários por conhecer mais em teoria, mas com
  > ajuda do tutor da trilha consegui ter um entendimento maior.

### Desafio 13 - Integração:

- **Como foi o processo de integração?**

  > R - Em geral foi uma boa experiência integrar o back com o front-end
  > e ver o sistema funcionando completo, a ferramenta do desenvolvedor
  > foi fundamental na integração.

- **Quais foram as principais dificuldades?**

  > R - a principal dificuldade foi o front-end não se adequar
  > corretamente com o back-end, tanto que necessitou de algumas
  > altereções com ajuda do tutor.

- **Obteve algum erro de CORS?**

  > R - Ao tentar realizar a integração me deparei com um erro como:
  > "A requisição foi bloqueada pelas políticas do CORS."

- **O que é CORS?**

  > R - É um mecanismo usado para adicionar cabeçalhos HTTP que informam aos navegadores para permitir que uma aplicação Web 
  > seja executada em uma origem e acesse recursos de outra origem diferente.

- **Você conseguiu adquirir os conhecimentos transmitidos durante o desafio 13? Se não, justifique :**

  > R - Apesar de ter feito a integração pela primeira, adquiri muito conhecimento a respeito.


#### Referências: 

[https://git-scm.com/book/pt-pt/v2/Ferramentas-do-Git-Advanced-Merging](https://git-scm.com/book/pt-pt/v2/Ferramentas-do-Git-Advanced-Merging) \
[https://pt.stackoverflow.com/questions/326160/diferen%C3%A7a-entre-git-add-all-git-add-e-git-add-u](https://pt.stackoverflow.com/questions/326160/diferen%C3%A7a-entre-git-add-all-git-add-e-git-add-u) \
[https://git-scm.com/docs/git-add](https://git-scm.com/docs/git-add) \
[https://www.guj.com.br/t/construtor-e-obrigatorio-numa-classe/83771/4](https://www.guj.com.br/t/construtor-e-obrigatorio-numa-classe/83771/4) \
[https://www.portalgsti.com.br/2017/08/padrao-mvc-arquitetura-model-view-controller.html](https://www.portalgsti.com.br/2017/08/padrao-mvc-arquitetura-model-view-controller.html) \
[https://www.baeldung.com/spring-response-entity](https://www.baeldung.com/spring-response-entity) \
[https://www.guj.com.br/t/dto-usar-ou-nao-usar/141688](https://www.guj.com.br/t/dto-usar-ou-nao-usar/141688) \
[https://www.dtidigital.com.br/blog/principios-solid-o-principio-de-inversao-de-dependencia/](https://www.dtidigital.com.br/blog/principios-solid-o-principio-de-inversao-de-dependencia/) \
[https://www.alura.com.br/artigos/como-resolver-erro-de-cross-origin-resource-sharing](https://www.alura.com.br/artigos/como-resolver-erro-de-cross-origin-resource-sharing) 





