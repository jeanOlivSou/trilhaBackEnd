# Desafio 9 :

- **O que � um padr�o de projeto e por que n�s os utilizamos? :**

    > R - Padr�es de projetos � um conceito na engenharia de software que consistem 
  > em um conjunto de solu��es que visam resolver problemas recorrentes em desenvolvimento
  > de software, e foi inspirado na ideia proposta pelo arquiteto de constru��es civil
  > Christopher Alexander. � amplamente de utilizado como forma de padronizar a l�gica 
  > pensada por uma equipe de desenvolvimento.

- **Cite um dos padr�es de cria��o :**

  > R - Builder � um padr�o de cria��o de utilizado para cria��o de objetos complexos e encapsular a implementa��o
  > de sua l�gica, tamb�m � usado quando h� v�rias representa��es do mesmo objeto na mesma classe. por exemplo:



  ```java
  public class Pizza {
  
      private int tamanho;
      private boolean queijo;
      private boolean tomate;
      private boolean bacon;
  
      Pizza(int tamanho) {
          this.tamanho = tamanho;
      }
  
      Pizza(int tamanho, boolean queijo) { 
          this(tamanho);
          this.queijo = queijo;
      }
  
      Pizza(int tamanho, boolean queijo, boolean tomate) {
          this(tamanho, queijo);
          this.tomate = tomate;
      }
  
      Pizza(int tamanho, boolean queijo, boolean tomate, boolean bacon) {
          this(tamanho, queijo, tomate);
          this.bacon = bacon;
      }
  
  }
  ```
<br/>

  **Abaixo o c�digo aplicando padr�o Builder**
  ```java
  public class Pizza {
  
      private int tamanho;
      private boolean queijo;
      private boolean tomate;
      private boolean bacon;
  
      public static class Builder {
          
          private final int tamanho;
          
          private boolean queijo = false;
          private boolean tomate = false;
          private boolean bacon = false;
  
          public Builder(int tamanho) {
              this.tamanho = tamanho;
          }
  
          public Builder queijo() {
              queijo = true;
              return this;
          }
  
          public Builder tomate() {
              tomate = true;
              return this;
          }
  
          public Builder bacon() {
              bacon = true;
              return this;
          }
  
          public Pizza build() {
              return new Pizza(this);
          }
  
      }
  
      private Pizza(Builder builder) {
          tamanho = builder.tamanho;
          queijo = builder.queijo;
          tomate = builder.tomate;
          bacon = builder.bacon;
      }
      Pizza pizza = new Pizza.Builder(10)
              .queijo()
              .tomate()
              .bacon()
              .build();
  
  }
  ```
  
  
- **Cite Um dos padr�es estruturais :**

   > R - Adapter � um padr�o de projeto estrutural que tem como responsabilidade
  > em converter um interface de uma classe para outra interface que o cliente
  > espera. Ele permite que duas classe incompat�veis trabalhem juntas. Abaixo um exemplo:
  
  ```java
    public interface ImagemTarget {
        void carregarImagem(String nomeDoArquivo);
     
        void desenharImagem(int posX, int posY, int largura, int altura);
    }
    
    public class OpenGLImage {
    
      public void glCarregarImagem(String arquivo) {
        System.out.println("Imagem " + arquivo + " carregada.");
      }
    
      public void glDesenharImagem(int posicaoX, int posicaoY) {
        System.out.println("OpenGL Image desenhada");
      }
    }
    
    public class SDL_Surface {
    
      public void SDL_CarregarSurface(String arquivo) {
        System.out.println("Imagem " + arquivo + " carregada.");
      }
    
      public void SDL_DesenharSurface(int largura, int altura, int posicaoX,
                                      int posicaoY) {
        System.out.println("SDL_Surface desenhada");
      }
    
    }
    
    public class OpenGLImageAdapter extends OpenGLImage implements ImagemTarget {
    
      @Override
      public void carregarImagem(String nomeDoArquivo) {
        glCarregarImagem(nomeDoArquivo);
      }
    
      @Override
      public void desenharImagem(int posX, int posY, int largura, int altura) {
        glDesenharImagem(posX, posY);
      }
    
    }
    
    public class SDLImagemAdapter extends SDL_Surface implements ImagemTarget {
    
      @Override
      public void carregarImagem(String nomeDoArquivo) {
        SDL_CarregarSurface(nomeDoArquivo);
      }
    
      @Override
      public void desenharImagem(int posX, int posY, int largura, int altura) {
        SDL_DesenharSurface(largura, altura, posX, posY);
      }
    }
  ```


- **Cite um padr�o comportamental :**

   > R - Iterator � um padr�o de projetos comportamental que permite acesso
  > sequencial a elementos de um objeto sem expor detalhes, utilizado bastante
  > em projetos para fornecer uma forma de percorrer collections. por exemplo:

  ```java
  ArrayList<Canal> arrayListDeCanais = new ArrayList<Canal>();
  Canal[] matrizDeCanais = new Canal[5];
  
  for (Canal canal : arrayListDeCanais) {
  System.out.println(canal.nome);
  }
  
  for (int i = 0; i < matrizDeCanais.length; i++) {
  System.out.println(matrizDeCanais[i].nome);
  }
  ```
  
  **c�digo ap�s a ap�s aplica��o do padr�o iterator**
  ```java
     public interface AgregadoDeCanais {
      IteradorInterface criarIterator();
    }
    
    public class CanaisEsportes implements AgregadoDeCanais {
   
      protected ArrayList<Canal> canais;
   
      public CanaisEsportes() {
          canais = new ArrayList<Canal>();
          canais.add(new Canal("Esporte ao vivo"));
          canais.add(new Canal("Basquete 2011"));
          canais.add(new Canal("Campeonato Italiano"));
          canais.add(new Canal("Campeonato Espanhol"));
          canais.add(new Canal("Campeonato Brasileiro"));
      }
   
      @Override
      public IteradorInterface criarIterator() {
          return new IteradorListaDeCanais(canais);
      }
  }
  
  public interface IteradorInterface {
    void first();
  
    void next();
  
    boolean isDone();
  
    Canal currentItem();
  }
  public class IteradorMatrizDeCanais implements IteradorInterface {
    protected Canal[] lista;
    protected int contador;
  
    public IteradorMatrizDeCanais(Canal[] lista) {
      this.lista = lista;
    }
  
    @Override
    public void first() {
      contador = 0;
    }
  
    @Override
    public void next() {
      contador++;
    }
  
    @Override
    public boolean isDone() {
      return contador == lista.length;
    }
  
    @Override
    public Canal currentItem() {
      if (isDone()) {
        contador = lista.length - 1;
      } else if (contador < 0) {
        contador = 0;
      }
      return lista[contador];
    }
  }
  
    public static void main(String[] args) {
      AgregadoDeCanais canaisDeEsportes = new CanaisEsportes();
      System.out.println("Canais de Esporte:");
      for (IteradorInterface it = canaisDeEsportes.criarIterator(); !it
              .isDone(); it.next()) {
        System.out.println(it.currentItem().nome);
      }
  
      AgregadoDeCanais canaisDeFilmes = new CanaisFilmes();
      System.out.println("\nCanais de Filmes:");
      for (IteradorInterface it = canaisDeFilmes.criarIterator(); !it
              .isDone(); it.next()) {
        System.out.println(it.currentItem().nome);
      }
    }
  ```
  

  
- **Explique o conceito de arquitetura de software e seu prop�sito :**
    
   > R - arquitetura de software de software consiste em defini��o de um conjunto de processos
  > de forma organizada em um projeto incorparada em seus componentes e tem como objetivo definir
  > uma estrutura padronizada para um projeto de software consequentemente dando uma vis�o mais
  > ampla ao time de desenvolvimento assim melhor atendendo os requisitos do cliente.
  
- **Qual arquitetura estamos seguindo at� o momento? Justifique sua resposta :**

   > R - At� o momento estav�mos construindo o projeto em arquitura em camadas onde cada
  > camada desempenha uma responsabilidade mas que interagem entre si para realiza��o de determinada
  > funcionalidade, este tipo de arquitetura ganhou espa�o na ado��o em projetos com a ascen��o da
  > internet nos anos 90.

- **O que significa a sigla SOLID?**
  * **S** - Single Responsability Principle
  <br/> *Princ�pio da responsabilidade �nica* - Uma classe deve ter uma e somente uma responsabilidade. 
  * **O** - Open-Closed Principle
  <br/> *Princ�pio de aberto-fechado* - Voc� deve ser capaz de herdar um comportamento de uma classe sem modific�-lo.
  * **L** - Liskov Substitution Principle
  <br/> *Princ�pio da substitui��o de Liskov* - As classes derivadas devem ser substitu�veis por suas classes bases.
  * **I** - Interface Segregation Principle
  <br/> *Princ�pio da segrega��o de interfaces* - Muitas interfaces espec�ficas s�o melhores do que uma interface �nica geral.
  * **D** - Dependency Inversion Principle
  <br/> *Princ�pio da invers�o de depend�ncia* - Dependa de abstra��es e n�o de implementa��es.
  

- **Quais princ�pios foram utilizados no projeto at� o momento? Explique :**
  
  > R - Os princ�pios mais utilizado s�o os Princ�pio da segrega��o de interfaces e o Princ�pio da invers�o de depend�ncia
  > pelo fato das interfaces do projeto n�o serem t�o generalizadas e ap�s a refatora��o do projeto em hexagonal principalmente
  > n�o h� tantas dep�ndencias de implementa��o de tecnologia e sim da abstra��o.


**Refer�ncias:**

[https://brizeno.wordpress.com/category/padroes-de-projeto/](https://brizeno.wordpress.com/category/padroes-de-projeto/)
[https://refactoring.guru/pt-br/design-patterns](https://refactoring.guru/pt-br/design-patterns)
[http://luizricardo.org/2013/08/construindo-objetos-de-forma-inteligente-builder-pattern-e-fluent-interfaces/](http://luizricardo.org/2013/08/construindo-objetos-de-forma-inteligente-builder-pattern-e-fluent-interfaces/)
[https://www.devmedia.com.br/padrao-de-projeto-iterator-em-java/26733](https://www.devmedia.com.br/padrao-de-projeto-iterator-em-java/26733)