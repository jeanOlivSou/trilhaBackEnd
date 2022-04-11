package trilha.back.financys.adapters.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoRequest {

    private Long id;

    @NotBlank(message = "{lancamento.campo.notblank}")
    @Size(min = 3, max = 45, message = "{lancamento.nome.size}")
    private String name;

    @NotBlank(message = "{lancamento.campo.notblank}")
    @Size(min = 15, max = 150, message = "{lancamento.descricao.size}")
    private String description;

    @NotBlank(message = "{lancamento.campo.notblank}")
    @Size(min = 3, max = 10, message = "{lancamento.tipo.size}")
    private String type;

    @NotNull(message = "{lancamento.campo.notblank}")
    @Positive
    private Double amount;

    @NotBlank(message = "{lancamento.campo.notblank}")
    private String date;

    @NotNull(message = "{lancamento.campo.notblank}")
    private Boolean paid;

    private CategoriaEntity categoryId;




}


