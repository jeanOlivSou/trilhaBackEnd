package trilha.back.financys.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Lancamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private List<Lancamento> lancamentos = new ArrayList<>();

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Lancamento lancamento){

        lancamentos.add(lancamento);

        return ResponseEntity
                .created(null)
                .body(lancamento.getId());

    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> read(){

        List<Lancamento> listaLancamento = getLancamentos();

        listaLancamento.sort(Comparator.comparing(Lancamento::getData));

        setLancamentos(listaLancamento);

        return ResponseEntity.ok(getLancamentos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento>
    update(@PathVariable Long id, @RequestBody Lancamento lancamento){

        return ResponseEntity.ok(lancamento);
    }


    @DeleteMapping("/{id}")
    public void delete(){
        ResponseEntity.ok();
    }


}
