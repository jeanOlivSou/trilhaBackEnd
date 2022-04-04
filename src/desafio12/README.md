# Desafio 11 :

- **O que são libs quando se trata de código? :**

    > R - Libs são um conjunto de funcionalidades do java organizadas e encapsuladas em classes que
  > podem ser reaproveitadas em partes para solução simplificada de uma aplicação.

- **Cite 2 libs populares no Java e seu objetivo :**

    - Apache commons - Lib que Possui um  conjunto de utilidades para soluções I/O para aplicações.
    - Mockito - Lib que auxiliam na simulação de objetos durante o processo de testes sem interferir na aplicação.
  

- **Qual é o propósito do Maven, e qual é o seu relacionamento com o arquivo pom.xml? :**

   > R - Maven traz funcionalidades de automação de compilação e gerenciamento de dependências
  > e as informações sobre o projeto para compilar o projeto bem como as informações de dependências
  > estão presentes no arquivo **pom.xml**

- **Qual é a diferença do Maven para o Gradle? :**

   > R - O Maven é uma ferramenta de gerenciamento e compreensão de projeto de software
  > enquanto o Gradle é um sistema de automação baseado nos conceitos do Ant e Maven,
  > o Maven faz uso de XML para gerenciar as informações para a construção do projeto
  > e suas dependências enquanto o Gradle faz isso por meio de scripts.

  
- **Qual a relação entre os termos lib, driver e JDBC?  :**
    
   > R - JDBC é uma API utilizada para persistência de bancos de dados no Java
  > que se utiliza de código de terceiro(Lib externa) que são drivers para fazer
  > a conectividade com determinado banco de dados.


- **Como é adicionado uma lib no projeto?  :**

   > R - Quando se trata de um projeto comum Java tem que adicionar manualmente,
  > onde você adciona o arquivo .jar da biblioteca desejada e a adiciona através
  > das configurações de sua IDE, já em um projeto Spring é adicionado através do 
  > seu gerenciador de dependências seja Maven ou Gradle, no caso do Maven você
  > adciona o código XML da dependência e ao recarregar o Maven, o próprio Maven
  > se encarrega de baixar a libs externas definidas no **pom.xml**


- **Escolha um banco de dados (menos o H2) e explique como utilizar o driver de comunicação :**

  - Primeiramente a declare as dependências do driver JDBC do PostgreSQL e do JPA no arquivo **pom.xml**:
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
  
  - Agora é preciso especificar as informações de conexão ao banco no arquivo de configuração do Spring **application.properties**:
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/nomedeseuDB
  spring.datasource.username=postgres
  spring.datasource.password=password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect
  ```
  
  - E por fim declare sua interface repository necessária para fazer a interligação com a camada de persitência através do JPA:
  
  ```java
  import org.springframework.data.jpa.repository.JpaRepository;

  public interface ClasseRepository extends JpaRepository<Classe, Long> {

  }
  
  ```
  
  



- **Referências :**

[https://opensource.com/article/20/2/external-libraries-java](https://opensource.com/article/20/2/external-libraries-java) \
[https://www.javatpoint.com/java-top-10-libraries](https://www.javatpoint.com/java-top-10-libraries) \
[https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) \
[https://pt.strephonsays.com/what-is-the-difference-between-maven-and-gradle](https://pt.strephonsays.com/what-is-the-difference-between-maven-and-gradle) \
[https://docs.oracle.com/cd/E11882_01/java.112/e16548/toc.htm](https://docs.oracle.com/cd/E11882_01/java.112/e16548/toc.htm) \
[https://opensource.com/article/20/2/external-libraries-java](https://opensource.com/article/20/2/external-libraries-java) \
[https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples](https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples) 
