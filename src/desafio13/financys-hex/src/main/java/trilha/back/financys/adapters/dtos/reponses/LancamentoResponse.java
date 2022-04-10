package trilha.back.financys.adapters.dtos.reponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.core.domains.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoResponse {
    private Long id;
    private String name;
    private String description;
    private String type;
    private Double amount;
    private String date;
    private Boolean paid;
    private Categoria categoryId;
}
