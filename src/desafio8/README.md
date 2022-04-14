# Desafio 8  - Tratamento de Exceptions:

- **O que s�o exceptions? :**

    > R - Exceptions s�o eventos que ocorrem durante a execu��o ou compila��o
  > de um sistema causando a interrup��o do sistema quando algo inesperado acontece no c�digo.
  > as exceptions indicam em um sistema que aconteceu um erro e cont�m as devidas informa��o do
  > que ocorreu.

- **Qual � o funcionamento do try, catch e finally? :**

     > R - try-catch-finally s�o estruturas de controle utilizadas para tratamento e lan�amento de exce��es:
     * try - Tenta excutar desejada instru��o.
     * catch - Realiza a captura da excess�o dando a possibilidade de trat�-la dentro de seu bloco ou somente lan�ar a exce��o.
     * finally - Realiza a pr�xima instru��o ap�s a exce��o ser lan�ada.
  
- **Qual a rela��o entre �try, catch e finally� e �throws�? :**

   > R - Ao implementar uma exce��o checada em um met�do, isto � lan�ar a exce��o no escopo do m�todo utilizando
  > throws, o java torna torna obrigat�rio o tratamento de exce��o consequentemente se utiliza o bloco try-catch-finally.

- **Para que serve a annotation @ExceptionHandler? :**

   > R - @ExceptionHandler � uma annotation do Spring Framework para tratar exce��es dentro de classes de tratamento
  > de exce��o ou em m�todos de tratamento de exce��o.
  
- **Para que serve o comando throw? :**
    
   > R - throw � um instru��o do java para lan�ar uma exce��o e posteriormente utiliz�-la para tratamento da mesma.
  
- **Para que serve a annotation @ControllerAdvice? :**

   > R - @ControllerAdvice � uma annotation especializada da annotation @Component e serve para indicar que determinada
  > classe � utilizada para manipula��o e tratamento de exce��es de forma centralizada.
