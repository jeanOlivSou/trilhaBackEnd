package trilha.back.financys.adapters.dtos.reponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoChartResponse {
    private String name;
    private String type;
    private Double total;


}
