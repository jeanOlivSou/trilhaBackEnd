package trilha.back.financys.adapters.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {

        private Long id;

        @NotBlank(message = "{categoria.campo.notblank}")
        @Size(min = 3, max = 15, message = "{categoria.nome.size}")
        private String name;

        @NotBlank(message = "{categoria.campo.notblank}")
        @Size(min = 15, max = 50, message = "{categoria.descricao.size}")
        private String description;


    }
