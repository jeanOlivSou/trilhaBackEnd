# Desafio 9 :

- **O que é um padrão de projeto e por que nós os utilizamos? :**

    > R - Padrões de projetos é um conceito na engenharia de software que consistem 
  > em um conjunto de soluções que visam resolver problemas recorrentes em desenvolvimento
  > de software, e foi inspirado na ideia proposta pelo arquiteto de construções civil
  > Christopher Alexander. É amplamente de utilizado como forma de padronizar a lógica 
  > pensada por uma equipe de desenvolvimento.

- **Cite um dos padrões de criação :**

  > R - Builder é um padrão de criação de utilizado para criação de objetos complexos e encapsular a implementação
  > de sua lógica, também é usado quando há várias representações do mesmo objeto na mesma classe. por exemplo:



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

  **Abaixo o código aplicando padrão Builder**
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
  
  
- **Cite Um dos padrões estruturais :**

   > R - Adapter é um padrão de projeto estrutural que tem como responsabilidade
  > em converter um interface de uma classe para outra interface que o cliente
  > espera. Ele permite que duas classe incompatíveis trabalhem juntas. Abaixo um exemplo:
  
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


- **Cite um padrão comportamental :**

   > R - Iterator é um padrão de projetos comportamental que permite acesso
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
  
  **código após a após aplicação do padrão iterator**
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
  

  
- **Explique o conceito de arquitetura de software e seu propósito :**
    
   > R - arquitetura de software de software consiste em definição de um conjunto de processos
  > de forma organizada em um projeto incorparada em seus componentes e tem como objetivo definir
  > uma estrutura padronizada para um projeto de software consequentemente dando uma visão mais
  > ampla ao time de desenvolvimento assim melhor atendendo os requisitos do cliente.
  
- **Qual arquitetura estamos seguindo até o momento? Justifique sua resposta :**

   > R - Até o momento estavámos construindo o projeto em arquitura em camadas onde cada
  > camada desempenha uma responsabilidade mas que interagem entre si para realização de determinada
  > funcionalidade, este tipo de arquitetura ganhou espaço na adoção em projetos com a ascenção da
  > internet nos anos 90.

- **O que significa a sigla SOLID?**
  * **S** - Single Responsability Principle
  <br/> *Princípio da responsabilidade Única* - Uma classe deve ter uma e somente uma responsabilidade. 
  * **O** - Open-Closed Principle
  <br/> *Princípio de aberto-fechado* - Você deve ser capaz de herdar um comportamento de uma classe sem modificá-lo.
  * **L** - Liskov Substitution Principle
  <br/> *Princípio da substituição de Liskov* - As classes derivadas devem ser substituíveis por suas classes bases.
  * **I** - Interface Segregation Principle
  <br/> *Princípio da segregação de interfaces* - Muitas interfaces específicas são melhores do que uma interface única geral.
  * **D** - Dependency Inversion Principle
  <br/> *Princípio da inversão de dependência* - Dependa de abstrações e não de implementações.
  

- **Quais princípios foram utilizados no projeto até o momento? Explique :**
  
  > R - Os princípios mais utilizado são os Princípio da segregação de interfaces e o Princípio da inversão de dependência
  > pelo fato das interfaces do projeto não serem tão generalizadas e após a refatoração do projeto em hexagonal principalmente
  > não há tantas depêndencias de implementação de tecnologia e sim da abstração.


**Referências:**

[https://brizeno.wordpress.com/category/padroes-de-projeto/](https://brizeno.wordpress.com/category/padroes-de-projeto/)
[https://refactoring.guru/pt-br/design-patterns](https://refactoring.guru/pt-br/design-patterns)
[http://luizricardo.org/2013/08/construindo-objetos-de-forma-inteligente-builder-pattern-e-fluent-interfaces/](http://luizricardo.org/2013/08/construindo-objetos-de-forma-inteligente-builder-pattern-e-fluent-interfaces/)
[https://www.devmedia.com.br/padrao-de-projeto-iterator-em-java/26733](https://www.devmedia.com.br/padrao-de-projeto-iterator-em-java/26733)