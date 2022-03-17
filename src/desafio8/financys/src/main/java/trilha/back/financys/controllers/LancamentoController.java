package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dtos.reponses.LancamentoChartResponse;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.dtos.requests.LancamentoRequest;
import trilha.back.financys.services.LancamentoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping
    public ResponseEntity<LancamentoResponse> create(@RequestBody @Valid LancamentoRequest lancamento) {

        return ResponseEntity
                .created(null)
                .body(lancamentoService.create(lancamento));

    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoResponse>
    update(@RequestBody @Valid LancamentoRequest lancamentoRequest, @PathVariable Long id) {

        LancamentoResponse lAtualizado = lancamentoService.update(lancamentoRequest, id);

        return ResponseEntity.ok(lAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoResponse>> read() {

        return ResponseEntity.ok(lancamentoService.read());
    }

    @GetMapping("/pago")
    public ResponseEntity<List<LancamentoResponse>> readByPago(@RequestParam Boolean pago) {
        return ResponseEntity.ok(lancamentoService.readByPago(pago));
    }


    @GetMapping("/{id}")
    public ResponseEntity<LancamentoResponse> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoService.readByid(id));
    }

    @GetMapping("/chart")
    public ResponseEntity<List<LancamentoChartResponse>> chart(){
        return ResponseEntity.ok(lancamentoService.chart());
    }

    @GetMapping("/calcula/{x}/{y}")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y){
        return ResponseEntity.ok(lancamentoService.calculaMedia(x, y));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lancamentoService.delete(id);
        ResponseEntity.ok();
    }




}
