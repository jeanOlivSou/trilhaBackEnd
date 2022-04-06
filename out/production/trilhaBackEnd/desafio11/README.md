# Desafio 11 :

- **O que s�o libs quando se trata de c�digo? :**

    > R - Libs s�o um conjunto de funcionalidades do java organizadas e encapsuladas em classes que
  > podem ser reaproveitadas em partes para solu��o simplificada de uma aplica��o.

- **Cite 2 libs populares no Java e seu objetivo :**

    - Apache commons - Lib que Possui um  conjunto de utilidades para solu��es I/O para aplica��es.
    - Mockito - Lib que auxiliam na simula��o de objetos durante o processo de testes sem interferir na aplica��o.
  

- **Qual � o prop�sito do Maven, e qual � o seu relacionamento com o arquivo pom.xml? :**

   > R - Maven traz funcionalidades de automa��o de compila��o e gerenciamento de depend�ncias
  > e as informa��es sobre o projeto para compilar o projeto bem como as informa��es de depend�ncias
  > est�o presentes no arquivo **pom.xml**

- **Qual � a diferen�a do Maven para o Gradle? :**

   > R - O Maven � uma ferramenta de gerenciamento e compreens�o de projeto de software
  > enquanto o Gradle � um sistema de automa��o baseado nos conceitos do Ant e Maven,
  > o Maven faz uso de XML para gerenciar as informa��es para a constru��o do projeto
  > e suas depend�ncias enquanto o Gradle faz isso por meio de scripts.

  
- **Qual a rela��o entre os termos lib, driver e JDBC?  :**
    
   > R - JDBC � uma API utilizada para persist�ncia de bancos de dados no Java
  > que se utiliza de c�digo de terceiro(Lib externa) que s�o drivers para fazer
  > a conectividade com determinado banco de dados.


- **Como � adicionado uma lib no projeto?  :**

   > R - Quando se trata de um projeto comum Java tem que adicionar manualmente,
  > onde voc� adciona o arquivo .jar da biblioteca desejada e a adiciona atrav�s
  > das configura��es de sua IDE, j� em um projeto Spring � adicionado atrav�s do 
  > seu gerenciador de depend�ncias seja Maven ou Gradle, no caso do Maven voc�
  > adciona o c�digo XML da depend�ncia e ao recarregar o Maven, o pr�prio Maven
  > se encarrega de baixar a libs externas definidas no **pom.xml**


- **Escolha um banco de dados (menos o H2) e explique como utilizar o driver de comunica��o :**

  - Primeiramente a declare as depend�ncias do driver JDBC do PostgreSQL e do JPA no arquivo **pom.xml**:
  ```xml
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
  </dependency>
  
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  
  ```
  
  - Agora � preciso especificar as informa��es de conex�o ao banco no arquivo de configura��o do Spring **application.properties**:
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/nomedeseuDB
  spring.datasource.username=postgres
  spring.datasource.password=password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect
  ```
  
  - E por fim declare sua interface repository necess�ria para fazer a interliga��o com a camada de persit�ncia atrav�s do JPA:
  
  ```java
  import org.springframework.data.jpa.repository.JpaRepository;

  public interface ClasseRepository extends JpaRepository<Classe, Long> {

  }
  
  ```
  
  



- **Refer�ncias :**

[https://opensource.com/article/20/2/external-libraries-java](https://opensource.com/article/20/2/external-libraries-java) \
[https://www.javatpoint.com/java-top-10-libraries](https://www.javatpoint.com/java-top-10-libraries) \
[https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) \
[https://pt.strephonsays.com/what-is-the-difference-between-maven-and-gradle](https://pt.strephonsays.com/what-is-the-difference-between-maven-and-gradle) \
[https://docs.oracle.com/cd/E11882_01/java.112/e16548/toc.htm](https://docs.oracle.com/cd/E11882_01/java.112/e16548/toc.htm) \
[https://opensource.com/article/20/2/external-libraries-java](https://opensource.com/article/20/2/external-libraries-java) \
[https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples](https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples) 
