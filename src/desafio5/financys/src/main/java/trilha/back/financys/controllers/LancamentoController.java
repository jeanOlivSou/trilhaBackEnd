package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.services.LancamentoService;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lService;

    @PostMapping
    public ResponseEntity<Lancamento> create(@RequestBody Lancamento lancamento) {

        Lancamento lcriado = lService.create(lancamento);

        return ResponseEntity
                .created(null)
                .body(lcriado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento>
    update(@RequestBody Lancamento lancamento, @PathVariable Long id) {

        Lancamento lAtualizado = lService.update(lancamento, id);

        return ResponseEntity.ok(lAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> read() {

        return ResponseEntity.ok(lService.read());
    }

    @GetMapping("/pago")
    public ResponseEntity<List<Lancamento>> readByPago(@RequestParam Boolean pago) {
        return ResponseEntity.ok(lService.readByPago(pago));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lService.readByid(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lService.delete(id);
        ResponseEntity.ok();
    }


}
