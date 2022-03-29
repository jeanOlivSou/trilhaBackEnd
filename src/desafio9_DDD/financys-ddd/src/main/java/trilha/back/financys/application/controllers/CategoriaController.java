package trilha.back.financys.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domain.dtos.reponses.CategoriaResponse;
import trilha.back.financys.domain.dtos.requests.CategoriaRequest;
import trilha.back.financys.domain.services.CategoriaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(@RequestBody @Valid CategoriaRequest categoriaRequest){

        return ResponseEntity
                .created(null)
                .body(categoriaService.create(categoriaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse>
    update(@RequestBody @Valid CategoriaRequest categoriaRequest, @PathVariable Long id){

        return ResponseEntity.ok(categoriaService.update(categoriaRequest, id));

    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> read(){
        return ResponseEntity.ok(categoriaService.read());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> readById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.readById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<String> idCategoriaByNome(@PathVariable String nome){
        return ResponseEntity.ok(categoriaService.idCategoriaByNome(nome.trim()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        categoriaService.delete(id);

        ResponseEntity.ok();

    }



}
