# Desafio 12 :

- **Explique o conceito de teste unit�rio :**

    > R - Testes unit�rios s�o teste que verificam uma parte espec�fica do c�digo
  > afim de examinar o funcionamento de tais m�todos.

- **Descreva como fazer um c�digo de teste :**

   > R - assegure que as dependencias para testes est�o inclu�das,
  > escolha um m�todo para testar, se necess�rio utilize o Mockito
  > para simular o cen�rio necess�rio para teste e fa�a uso das afirmativas(assertions) para
  > assegurar o resultado esperado.

- **Qual o intuito do teste unit�rio? :**

   > R - objetivo dos testes unit�rios � assegurar para equipe de desenvolvimento que
  > que os m�todos est�o funcionando conforme os requisitos do cliente.

  - **Quais  s�o  as  ferramentas  que  utilizamos  para  realizar  testes  unit�rios(2  pelo  menos) :**
    
      * Junit 5
      * AssertJ
      * Mockito

- **Pilha de Erros dos testes (StackTracer) :**

    | Texto Stack Track  |                                                                     Explica��o |
    |-------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------|
    | org.opentest4j.AssertionFailedError: Expected java.lang.RuntimeException to be thrown, but nothing was thrown. |                   Ao desenvolver o m�todo filter n�o havia a exce��o esperada. |
    | java.lang.AssertionError: Status expected:<204> but was:<404> |  Erro de afirmativa, era esperado status No Content mas foi lan�ado Not Found. |
    | java.lang.AssertionError: Status expected:<200> but was:<204>|         Erro de afirmativa, era esperado status OK mas foi lan�ado No content. |



- **Refer�ncias :**

[https://www.devmedia.com.br/e-ai-como-voce-testa-seus-codigos/39478](https://www.devmedia.com.br/e-ai-como-voce-testa-seus-codigos/39478) 
