## Desafio 2:

- **Com suas palavras defina o que é programação orientada a objetos (POO) e cite seus pilares? (máx 10 linhas):**

  > R - Programação Orientada a Objetos é um paradigma de progração no qual consiste em
  aproximar-se de cenários do mundo real, e são estruturados em objetos e classes,
  e seus comportamentos convertidos em métodos atráves da abstração.



- **Exemplifique e explique um cenário de abstração:**

  > R - Pilar da POO que visa a capacidade de enxergar cenários do mundo real
  e convertê-los em componentes do paradigmas da orientação
  a objetos de forma que convenha a cada necessidade ou requisito.\
  Ex: Animal é algo do mundo real e pode ser convertido em classe
  com seus atributos e métodos que irá variar com os requisitos que
  o sistema necessita.



- **Exemplifique e explique um cenário de encapsulamento:**

  > R - Pilar da POO que aplica proteção a implementação
  de uma classe(atributos e métodos) de modo que outro
  desenvolvedor não precisa conhecer a implementação da
  classe encapsulada para poder acessá-la e este acesso
  não se dá diretamente. \
  Ex: Em uma classe hipotética "ContaCorrente" podemos
  ter atributos de dados que não convém deixá-los com a
  visibilidade pública portanto se encapsula os atributo
  com os modificadores de acesso como "private" ou "protected".


- **Exemplifique e explique um cenário de herança:**

  > R - Pilar do POO que permite que tenha existência de subclasses
  que compartilhem entre si atributos e métodos de forma hierárquica.\
  Ex: Voltando com o exemplo da classe "Animal" dependendo da abstração
  pode haver a necessidade de existir subclasses que especifique o tipo
  de animal como "Mamífero" e "Réptil" que herdam caracteríticas da classe
  "Animal", porém possui atributos e metódos próprios em suas classes.


- **Exemplifique e explique um cenário de polimorfismo:**

  > R - Pilar da POO que permite que uma ou mais classes derivadas sejam capazes
  de chamar um determinado metódo de mesma assinatura e identidade mas com
  implementação diferente através da sobrescrita. \
  Ex: Na classe "Animal" as classes derivadas podem compatilhar
  mesmo método "EmitirSom()" porém com implementações diferentes.



- **Cite 5 vantagens da POO:**

1. Possibilidade de Reutilização de código.
2. Permite um nível de abstração que represente melhor o mundo real em um sistema.
3. Facilidade em manter grandes projetos.
4. Legibilidade maior no código.
5. Torna o desenvolvimento do projeto mais ágil.