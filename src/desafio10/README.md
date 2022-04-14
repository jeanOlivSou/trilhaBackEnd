# Desafio 10 - Spring :

- **O que voc� entende por Spring Framework? :**

    > R - Spring � um framework Java com a finalidade de facilitar o desenvolvimento de aplica��es
  > sobre os padr�es de projetos inje��o de depend�ncias e invers�o de controle e possui um conjunto
  > amplo de recursos bem como oferece um conceito a seguir para um desenvolvimento mais coeso.

- **Cite 3 exemplos de ferramentas Spring e suas respectivas finalidades :**
    * Spring Web - *Fornece todo apoio na configura��o para o desenvolvimento web al�m de n�o necessitar de um servidor web*
    * Spring Data JPA - *Torna poss�vel realizar a integra��o do Spring com o JPA sem implementar manualmente classes DAO*
    * Spring Cloud - *Prov� aos desenvolvedores uma s�rie de utilidades que facilitam o desenvolvimento de aplica��o distribu�das e escal�veis em nuvem*
  

- **Quais ferramentas do Spring foram utilizadas na trilha at� o momento? :**

   > R - Spring Boot, Spring Data JPA e Spring Web.

- **Cite 5 vantagens em utilizar Spring :**
    1) Facilidade em desenvolvimento de aplica��es em qualquer complexidade.
    2) Servidor Built-in.
    3) Redu��o de tempo de desenvolvimento.
    4) Redu��o na complexidade de configura��o.
    5) Redu��o de acoplamento atrav�s de inje��o de depend�ncia.
  
- **Descreva os passos de cria��o de uma Web API Spring boot, com conex�o com SQL Server :**
    
   > R - Primeiramente verifique se a depend�ncia do Spring data JPA e Spring web est� adcionada, se n�o estiver
  > adcione e em seguida adcione a deped�ncia do SQL Server, logo ap�s especifique as propriedades do
  > banco de dados no arquivo ***application.properties***, ap�s isso defina a camada de persistencia
  > com o mapeamento de suas classe de entidade com as annotations do JPA e para camada de acesso aos
  > dados com as opera��es de banco de dado defina as interfaces repositories necess�rias, dependendo
  > da aplica��o adcione e programe as classe de services interagindo com os repositories e as classes
  > de controllers com seus respectivos endpoints tendo conex�o com a camada de service.


- **Qual a funcionalidade do pom.xml? :**

   > R - � um arquivo XML do Maven onde h� informa��es do projeto e configura��es necess�rias para 
  > construir o sistemas.

- **Qual a funcionalidades do applications.properties? :**

  > R - � um arquivo de configura��o em que � poss�vel definir propriedades de banco de dados, testes, web, seguran�a, etc.


- **Qual o prop�sito das Annotations? :**

  > R - Annotations s�o um tipo de interface que fornece informa��es(metadados) para o sistema que em si n�o 
  > fazem parte dele, sendo estas informa��es passadas para o compilador ou em tempo de compila��o, em tempo
  > de desenvolvimento ou processo de execu��o.

- **Cite 10 annotations, com suas respectivas finalidades e descreva ou desenhe um cen�rio exemplificando a sua utiliza��o :**

    * **@Component** - *Define em tempo de execu��o da aplica��o que determinada classe � um componente do Spring.*
       <br/> Definido antes da declara��o da classe do componente.  
    * **@Service** - *Annotation especializada da @component que serve especificar que determinada classe ser� um servi�o do spring.*
       <br/> Definido tamb�m antes da declara��o da classe de servi�o.
    * **@RestController** - *Annotation especializada da @component que serve especificar que determinada classe ser� um Controller do spring.*
       <br/> Definido tamb�m antes da declara��o da classe de controllers.
    * **@SpringBootApplication** - *Especifica que a classe anotada � uma aplica��o gerenciada pelo Spring Boot.*
       <br/> Definido antes da declara��o da classe principal da aplica��o.
    * **@RequestMapping** - *Usada nas classes de controllers para mapear as requisi��es definidas no controller*
       <br/> Definido juntamente com a @RestController ou antes da declara��o do m�todo que define a requisi��o HTTP.
    * **@Override** - *Especifica que a declara��o do met�do � uma sobreescrita de m�todo*
       <br/> Utilizado antes da implementa��o de uma sobreescrita de m�todo.
    * **@Entity** - *Define que a classe anotada ser�  mapeada e persistida atrav�s do JPA como uma entidade.*
       <br/> Utilizado antes da declara��o de uma classe de entidade.
    * **@Id** - *Obrigatoriamente utilizada juntamente com a @Entity, diz ao JPA que determinado atributo ser� mapeado como chave pr�m�ria da entidade.*
      <br/> Utilizado antes da declara��o do atributo escolhido.
    * **@Requestbody** - *Usado para interligar uma requisi��o HTTP a um objeto passado por par�metro de um m�todo do controller*
       <br/> Utilizado antes da declara��o do par�metro do m�todo.
    * **@Size** - Annotation do Java Bean Validation que determina o tamanho de uma string de um atributo e posteriormente ser� validado.
       <br/> Utilizado antes da declara��o do atributo String escolhido.


- **O que � um advice em Spring? Quais os tipos de advice para o Spring?**

  > R - � a a��o executada por um aspecto em um join point particular, seu principal objetivo � fornecer apoio a preocupa��es adversas,
  > como gerenciamento de transa��es, logs, regitro, etc. Seus tipos s�o Before, After, Around.

  
- **O que � Spring IoC Container?**

  > R - Spring IoC Container � o Core do Spring Framework, ele cria objetos, configura e monta depend�ncias,
  > gerencia todo o seu ciclo de vida, o container usa inje��o de deped�ncia para gerencia os componente da
  > aplica��o, obt�m informa��es sobre os objetos de um arquivo de configura��o(Geralmente XML).


- **Como adicionamos seguran�a � nossa aplica��o Spring? :**

  > R - Para adcionar uma camada de seguran�as �s aplica��es Spring � utilizado o Spring Security
  > que prov� configura��o para apoio � camada de seguran�a do Spring, como estrutura de autentica��o
  > e controle de acesso e autoriza��o.


- **Qual � o pacote Spring respons�vel pelas conex�es com os bancos de dados?**

  > R - O processo feito pela camada de acesso a dados � realizado pelo Spring Data 
  > cujo objetivo � prover configura��es que facilitam o acesso � base de dados
  > seja atrav�s do JPA ou JDBC.


- **Explique e exemplifique como criar um agendamento de execu��o de m�todos Spring; Cite exemplos de usabilidade :**

  > R - Para criar um agendamento de execu��o de m�todo Spring � necess�rio defini-lo via annotation @Scheduled e para
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
  
- **Refer�ncias :**

[https://www.devmedia.com.br/spring-boot-simplificando-o-spring/31979](https://www.devmedia.com.br/spring-boot-simplificando-o-spring/31979)
[https://maven.apache.org/guides/introduction/introduction-to-the-pom.html](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)
[https://docs.oracle.com/javase/tutorial/java/annotations/](https://docs.oracle.com/javase/tutorial/java/annotations/)
[https://www.javatpoint.com/spring-boot-annotations](https://www.javatpoint.com/spring-boot-annotations)
[https://www.geeksforgeeks.org/spring-ioc-container/](https://www.geeksforgeeks.org/spring-ioc-container/)
[https://www.baeldung.com/spring-aop-advice-tutorial](https://www.baeldung.com/spring-aop-advice-tutorial)
[https://www.baeldung.com/spring-scheduled-tasks](https://www.baeldung.com/spring-scheduled-tasks)
