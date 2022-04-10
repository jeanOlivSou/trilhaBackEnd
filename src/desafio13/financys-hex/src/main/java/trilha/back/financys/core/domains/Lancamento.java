package trilha.back.financys.core.domains;


public class Lancamento {
    private Long id;
    private String name;
    private String description;
    private String type;
    private Double amount;
    private String date;
    private Boolean paid;
    private Categoria categoryId;

    public Lancamento() {
    }

    public Lancamento(Long id, String name, String description, String type, Double amount, String date, Boolean paid, Categoria categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Categoria getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categoria categoryId) {
        this.categoryId = categoryId;
    }
}
