package trilha.back.financys.adapters.dtos.reponses;

public class CategoriaResponse {
    private String nome;
    private String descricao;

    public CategoriaResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaResponse() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{\n" +
                "nome= '" + nome + "', \n" +
                "descricao= '" + descricao + "' \n" +
                "}";
    }
}
