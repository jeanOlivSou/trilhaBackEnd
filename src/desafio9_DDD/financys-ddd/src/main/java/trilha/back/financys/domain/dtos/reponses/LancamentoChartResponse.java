package trilha.back.financys.domain.dtos.reponses;

public class LancamentoChartResponse {
    private String nome;
    private String tipo;
    private Double total;

    public LancamentoChartResponse() {
    }

    public LancamentoChartResponse(String nome, String tipo, Double total) {
        this.nome = nome;
        this.tipo = tipo;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
