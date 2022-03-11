package trilha.back.financys.dtos.requests;

import trilha.back.financys.domains.Categoria;

public class LancamentoRequest {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private String montante;
    private String data;
    private Boolean pago;
    private CategoriaRequest categoria;

    public LancamentoRequest() {
    }

    public LancamentoRequest(Long id, String nome, String descricao, String tipo, String montante, String data, Boolean pago, CategoriaRequest categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.montante = montante;
        this.data = data;
        this.pago = pago;
        this.categoria = categoria;
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

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public CategoriaRequest getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRequest categoria) {
        this.categoria = categoria;
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
                "categoria=" + categoria + "\n" +
                "}";
    }


}


