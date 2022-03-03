package trilha.back.financys.domains;

public class Lancamento {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private String montante;
    private String data;
    private Boolean pago;
    private Long categoriaId;

    public Lancamento() {
    }

    public Lancamento(Long id, String nome, String descricao,
                      String tipo, String montante, String data,
                      Boolean pago, Long categoriaId) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.montante = montante;
        this.data = data;
        this.pago = pago;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontante() {
        return montante;
    }

    public void setMontante(String montante) {
        this.montante = montante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean isPago(){
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "{ \n " +
                "id= " + id + ", \n" +
                "nome= '" + nome + "', \n" +
                "descricao= '" + descricao + "', \n" +
                "tipo= '" + tipo + "', " +
                "montante= '" + montante + "', \n" +
                "data= '" + data + "', \n" +
                "pago= " + pago + ", \n" +
                "categoriaId=" + categoriaId + "\n" +
                "}";
    }
}
