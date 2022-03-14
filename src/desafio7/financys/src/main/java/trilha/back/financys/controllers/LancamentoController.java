package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.dtos.reponses.LancamentoChartResponse;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.dtos.requests.LancamentoRequest;
import trilha.back.financys.services.LancamentoService;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lService;

    @PostMapping
    public ResponseEntity<LancamentoResponse> create(@RequestBody LancamentoRequest lancamento) {

        return ResponseEntity
                .created(null)
                .body(lService.create(lancamento));

    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoResponse>
    update(@RequestBody LancamentoRequest lancamentoRequest, @PathVariable Long id) {

        LancamentoResponse lAtualizado = lService.update(lancamentoRequest, id);

        return ResponseEntity.ok(lAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoResponse>> read() {

        return ResponseEntity.ok(lService.read());
    }

    @GetMapping("/pago")
    public ResponseEntity<List<LancamentoResponse>> readByPago(@RequestParam Boolean pago) {
        return ResponseEntity.ok(lService.readByPago(pago));
    }


    @GetMapping("/{id}")
    public ResponseEntity<LancamentoResponse> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lService.readByid(id));
    }

    @GetMapping("/chart")
    public ResponseEntity<List<LancamentoChartResponse>> chart(){
        return ResponseEntity.ok(lService.chart());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lService.delete(id);
        ResponseEntity.ok();
    }




}
