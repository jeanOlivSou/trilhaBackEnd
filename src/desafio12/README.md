# Desafio 12 :

- **Explique o conceito de teste unitário :**

    > R - Testes unitários são teste que verificam uma parte específica do código
  > afim de examinar o funcionamento de tais métodos.

- **Descreva como fazer um código de teste :**

   > R - assegure que as dependencias para testes estão incluídas,
  > escolha um método para testar, se necessário utilize o Mockito
  > para simular o cenário necessário para teste e faça uso das afirmativas(assertions) para
  > assegurar o resultado esperado.

- **Qual o intuito do teste unitário? :**

   > R - objetivo dos testes unitários é assegurar para equipe de desenvolvimento que
  > que os métodos estão funcionando conforme os requisitos do cliente.

  - **Quais  são  as  ferramentas  que  utilizamos  para  realizar  testes  unitários(2  pelo  menos) :**
    
      * Junit 5
      * AssertJ
      * Mockito

- **Pilha de Erros dos testes (StackTracer) :**

    | Texto Stack Track  |                                                                     Explicação |
    |-------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------|
    | org.opentest4j.AssertionFailedError: Expected java.lang.RuntimeException to be thrown, but nothing was thrown. |                   Ao desenvolver o método filter não havia a exceção esperada. |
    | java.lang.AssertionError: Status expected:<204> but was:<404> |  Erro de afirmativa, era esperado status No Content mas foi lançado Not Found. |
    | java.lang.AssertionError: Status expected:<200> but was:<204>|         Erro de afirmativa, era esperado status OK mas foi lançado No content. |



- **Referências :**

[https://www.devmedia.com.br/e-ai-como-voce-testa-seus-codigos/39478](https://www.devmedia.com.br/e-ai-como-voce-testa-seus-codigos/39478) 
