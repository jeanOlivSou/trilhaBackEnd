package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.repositories.LancamentoRepository;


import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    LancamentoRepository lRepo;

    @PostMapping
    public ResponseEntity<Lancamento> create(@RequestBody Lancamento lancamento){

        lRepo.save(lancamento);

        return ResponseEntity
                .created(null)
                .body(lancamento);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento>
    update(@PathVariable Long id, @RequestBody Lancamento lancamento){

        if (lRepo.findById(id).isPresent()){

            Lancamento lancamentoObt = lRepo.findById(id).get();

            lancamentoObt.setNome(lancamento.getNome());
            lancamentoObt.setDescricao(lancamento.getDescricao());
            lancamentoObt.setTipo(lancamento.getTipo());
            lancamentoObt.setMontante(lancamento.getMontante());
            lancamentoObt.setData(lancamento.getData());
            lancamentoObt.setPago(lancamento.isPago());
            lancamentoObt.setCategoria(lancamento.getCategoria());

            lRepo.save(lancamentoObt);

            return ResponseEntity.ok(lancamentoObt);
        }

        else {
            throw new NoSuchElementException("Lançamento não encontrado");
        }

    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> read(){

        List<Lancamento> listaLancamento = lRepo.findAll();

        listaLancamento.sort(Comparator.comparing(Lancamento::getData));

        return ResponseEntity.ok(listaLancamento);
    }

    @GetMapping("/pago")
    public ResponseEntity<List<Lancamento>> readByPago(@RequestParam Boolean pago){

        List<Lancamento> lancamentoLista = lRepo.findByPago(pago);

        lancamentoLista.sort(Comparator.comparing(Lancamento::getData));

        return ResponseEntity.ok(lancamentoLista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> readById(@PathVariable Long id){
        return ResponseEntity.ok(lRepo.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Lancamento lancamentoObt = lRepo.findById(id).get();

        lRepo.delete(lancamentoObt);

        ResponseEntity.ok();
    }


}
