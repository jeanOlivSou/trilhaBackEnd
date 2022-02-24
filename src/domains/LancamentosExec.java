package domains;

import java.util.*;
import java.util.stream.Collectors;

public class LancamentosExec {
    public static void main(String[] args) {


        Categoria c1 = new Categoria(1L, "Vestuário", "Aquisição de roupas");

        Categoria c2 = new Categoria();
        c2.setId(2L);
        c2.setNome("Salário");
        c2.setDescricao("Salário mensal referente ao mês de maio");

        System.out.println("Categorias: ");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println();

        Lancamento l1 = new Lancamento(
                1L,
                "Salário NTT DATA",
                "Salário mensal",
                "Receita",
                "5233,60",
                "05/05/2022",
                true,
                2L);

        Lancamento l2 = new Lancamento();
        l2.setId(2L);
        l2.setNome("Compras");
        l2.setDescricao("compras de roupa");
        l2.setTipo("Despesa");
        l2.setMontante("480,90");
        l2.setData("13/05/2022");
        l2.setPago(false);
        l2.setCategoriaId(1L);

        System.out.println("Lançamento: ");
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println();


        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1L, "Caderno", "Caderno 10 Matérias", 25.70));
        produtos.add(new Produto(2L, "Lâmpada", "Lampada WiFi Positivo", 63.90));
        produtos.add(new Produto(3L, "Smart Speaker", "Amazon Echo Dot 4° geração",379.80));
        produtos.add(new Produto(4L, "Marcardor", "Pincel Marcardor BIC", 5.00));
        produtos.add(new Produto(5L, "Lápis", "cx. Lápis 2B 8 Un.", 6.95));


        System.out.println();
        System.out.println("adcionando 10 reais aos precos:");
        for (Produto p : produtos){
            p.setPreco(p.getPreco() + 10.0);
            System.out.println(p.toString());
        }

        System.out.println();
        System.out.println("Lista de Todos os produtos: ");

        for (Produto p: produtos) {
            System.out.println(p.toString());
        }

        System.out.println();
        System.out.println("Lista dos 3 produtos mais caros: ");

        produtos.sort(Comparator.comparing(Produto::getPreco).reversed());

        List<Produto>
                produtosCaros =
                produtos
                        .stream()
                        .limit(3)
                        .collect(Collectors.toList());

        for (Produto p :  produtosCaros){
            System.out.println(p.toString());
        }


    }
}
