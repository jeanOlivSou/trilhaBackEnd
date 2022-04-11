package trilha.back.financys.adapters.dtos.reponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
    private Long id;
    private String name;
    private String description;
}
