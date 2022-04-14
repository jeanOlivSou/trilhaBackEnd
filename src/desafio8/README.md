# Desafio 8  - Tratamento de Exceptions:

- **O que são exceptions? :**

    > R - Exceptions são eventos que ocorrem durante a execução ou compilação
  > de um sistema causando a interrupção do sistema quando algo inesperado acontece no código.
  > as exceptions indicam em um sistema que aconteceu um erro e contém as devidas informação do
  > que ocorreu.

- **Qual é o funcionamento do try, catch e finally? :**

     > R - try-catch-finally são estruturas de controle utilizadas para tratamento e lançamento de exceções:
     * try - Tenta excutar desejada instrução.
     * catch - Realiza a captura da excessão dando a possibilidade de tratá-la dentro de seu bloco ou somente lançar a exceção.
     * finally - Realiza a próxima instrução após a exceção ser lançada.
  
- **Qual a relação entre “try, catch e finally” e “throws”? :**

   > R - Ao implementar uma exceção checada em um metódo, isto é lançar a exceção no escopo do método utilizando
  > throws, o java torna torna obrigatório o tratamento de exceção consequentemente se utiliza o bloco try-catch-finally.

- **Para que serve a annotation @ExceptionHandler? :**

   > R - @ExceptionHandler é uma annotation do Spring Framework para tratar exceções dentro de classes de tratamento
  > de exceção ou em métodos de tratamento de exceção.
  
- **Para que serve o comando throw? :**
    
   > R - throw é um instrução do java para lançar uma exceção e posteriormente utilizá-la para tratamento da mesma.
  
- **Para que serve a annotation @ControllerAdvice? :**

   > R - @ControllerAdvice é uma annotation especializada da annotation @Component e serve para indicar que determinada
  > classe é utilizada para manipulação e tratamento de exceções de forma centralizada.
