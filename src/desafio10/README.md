# Desafio 10 - Spring :

- **O que você entende por Spring Framework? :**

    > R - Spring é um framework Java com a finalidade de facilitar o desenvolvimento de aplicações
  > sobre os padrões de projetos injeção de dependências e inversão de controle e possui um conjunto
  > amplo de recursos bem como oferece um conceito a seguir para um desenvolvimento mais coeso.

- **Cite 3 exemplos de ferramentas Spring e suas respectivas finalidades :**
    * Spring Web - *Fornece todo apoio na configuração para o desenvolvimento web além de não necessitar de um servidor web*
    * Spring Data JPA - *Torna possível realizar a integração do Spring com o JPA sem implementar manualmente classes DAO*
    * Spring Cloud - *Provê aos desenvolvedores uma série de utilidades que facilitam o desenvolvimento de aplicação distribuídas e escaláveis em nuvem*
  

- **Quais ferramentas do Spring foram utilizadas na trilha até o momento? :**

   > R - Spring Boot, Spring Data JPA e Spring Web.

- **Cite 5 vantagens em utilizar Spring :**
    1) Facilidade em desenvolvimento de aplicações em qualquer complexidade.
    2) Servidor Built-in.
    3) Redução de tempo de desenvolvimento.
    4) Redução na complexidade de configuração.
    5) Redução de acoplamento através de injeção de dependência.
  
- **Descreva os passos de criação de uma Web API Spring boot, com conexão com SQL Server :**
    
   > R - Primeiramente verifique se a dependência do Spring data JPA e Spring web está adcionada, se não estiver
  > adcione e em seguida adcione a depedência do SQL Server, logo após especifique as propriedades do
  > banco de dados no arquivo ***application.properties***, após isso defina a camada de persistencia
  > com o mapeamento de suas classe de entidade com as annotations do JPA e para camada de acesso aos
  > dados com as operações de banco de dado defina as interfaces repositories necessárias, dependendo
  > da aplicação adcione e programe as classe de services interagindo com os repositories e as classes
  > de controllers com seus respectivos endpoints tendo conexão com a camada de service.


- **Qual a funcionalidade do pom.xml? :**

   > R - é um arquivo XML do Maven onde há informações do projeto e configurações necessárias para 
  > construir o sistemas.

- **Qual a funcionalidades do applications.properties? :**

  > R - É um arquivo de configuração em que é possível definir propriedades de banco de dados, testes, web, segurança, etc.


- **Qual o propósito das Annotations? :**

  > R - Annotations são um tipo de interface que fornece informações(metadados) para o sistema que em si não 
  > fazem parte dele, sendo estas informações passadas para o compilador ou em tempo de compilação, em tempo
  > de desenvolvimento ou processo de execução.

- **Cite 10 annotations, com suas respectivas finalidades e descreva ou desenhe um cenário exemplificando a sua utilização :**

    * **@Component** - *Define em tempo de execução da aplicação que determinada classe é um componente do Spring.*
       <br/> Definido antes da declaração da classe do componente.  
    * **@Service** - *Annotation especializada da @component que serve especificar que determinada classe será um serviço do spring.*
       <br/> Definido também antes da declaração da classe de serviço.
    * **@RestController** - *Annotation especializada da @component que serve especificar que determinada classe será um Controller do spring.*
       <br/> Definido também antes da declaração da classe de controllers.
    * **@SpringBootApplication** - *Especifica que a classe anotada é uma aplicação gerenciada pelo Spring Boot.*
       <br/> Definido antes da declaração da classe principal da aplicação.
    * **@RequestMapping** - *Usada nas classes de controllers para mapear as requisições definidas no controller*
       <br/> Definido juntamente com a @RestController ou antes da declaração do método que define a requisição HTTP.
    * **@Override** - *Especifica que a declaração do metódo é uma sobreescrita de método*
       <br/> Utilizado antes da implementação de uma sobreescrita de método.
    * **@Entity** - *Define que a classe anotada será  mapeada e persistida através do JPA como uma entidade.*
       <br/> Utilizado antes da declaração de uma classe de entidade.
    * **@Id** - *Obrigatoriamente utilizada juntamente com a @Entity, diz ao JPA que determinado atributo será mapeado como chave prímária da entidade.*
      <br/> Utilizado antes da declaração do atributo escolhido.
    * **@Requestbody** - *Usado para interligar uma requisição HTTP a um objeto passado por parâmetro de um método do controller*
       <br/> Utilizado antes da declaração do parâmetro do método.
    * **@Size** - Annotation do Java Bean Validation que determina o tamanho de uma string de um atributo e posteriormente será validado.
       <br/> Utilizado antes da declaração do atributo String escolhido.


- **O que é um advice em Spring? Quais os tipos de advice para o Spring?**

  > R - É a ação executada por um aspecto em um join point particular, seu principal objetivo é fornecer apoio a preocupações adversas,
  > como gerenciamento de transações, logs, regitro, etc. Seus tipos são Before, After, Around.

  
- **O que é Spring IoC Container?**

  > R - Spring IoC Container é o Core do Spring Framework, ele cria objetos, configura e monta dependências,
  > gerencia todo o seu ciclo de vida, o container usa injeção de depedência para gerencia os componente da
  > aplicação, obtém informações sobre os objetos de um arquivo de configuração(Geralmente XML).


- **Como adicionamos segurança à nossa aplicação Spring? :**

  > R - Para adcionar uma camada de seguranças às aplicações Spring é utilizado o Spring Security
  > que provê configuração para apoio à camada de segurança do Spring, como estrutura de autenticação
  > e controle de acesso e autorização.


- **Qual é o pacote Spring responsável pelas conexões com os bancos de dados?**

  > R - O processo feito pela camada de acesso a dados é realizado pelo Spring Data 
  > cujo objetivo é prover configurações que facilitam o acesso à base de dados
  > seja através do JPA ou JDBC.


- **Explique e exemplifique como criar um agendamento de execução de métodos Spring; Cite exemplos de usabilidade :**

  > R - Para criar um agendamento de execução de método Spring é necessário defini-lo via annotation @Scheduled e para
  > ativa-lo @EnableScheduling. Exemplo:
  
  ```java
  @Configuration
  @EnableScheduling
  public class SpringConfig {
      
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
      System.out.println(
              "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }
  }
  
  ```
  **Se quisermos suporte a comportamento paralelo em tarefas agendadas adcionamos a annotation @Async :**

  ```java
  
  @EnableAsync
  public class ScheduledFixedRateExample {
      @Async
      @Scheduled(fixedRate = 1000)
      public void scheduleFixedRateTaskAsync() throws InterruptedException {
          System.out.println(
            "Fixed rate task async - " + System.currentTimeMillis() / 1000);
          Thread.sleep(2000);
      }
  
  }
  ```
  
- **Referências :**

[https://www.devmedia.com.br/spring-boot-simplificando-o-spring/31979](https://www.devmedia.com.br/spring-boot-simplificando-o-spring/31979)
[https://maven.apache.org/guides/introduction/introduction-to-the-pom.html](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)
[https://docs.oracle.com/javase/tutorial/java/annotations/](https://docs.oracle.com/javase/tutorial/java/annotations/)
[https://www.javatpoint.com/spring-boot-annotations](https://www.javatpoint.com/spring-boot-annotations)
[https://www.geeksforgeeks.org/spring-ioc-container/](https://www.geeksforgeeks.org/spring-ioc-container/)
[https://www.baeldung.com/spring-aop-advice-tutorial](https://www.baeldung.com/spring-aop-advice-tutorial)
[https://www.baeldung.com/spring-scheduled-tasks](https://www.baeldung.com/spring-scheduled-tasks)
