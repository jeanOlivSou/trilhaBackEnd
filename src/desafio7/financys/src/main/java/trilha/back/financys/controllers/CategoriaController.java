package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dtos.reponses.CategoriaResponse;
import trilha.back.financys.dtos.requests.CategoriaRequest;
import trilha.back.financys.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService catService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(@RequestBody CategoriaRequest categoriaRequest){

        return ResponseEntity
                .created(null)
                .body(catService.create(categoriaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse>
    update(@RequestBody CategoriaRequest categoriaRequest, @PathVariable Long id){

        return ResponseEntity.ok(catService.update(categoriaRequest, id));

    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> read(){
        return ResponseEntity.ok(catService.read());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> readById(@PathVariable Long id){
        return ResponseEntity.ok(catService.readById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<String> idCategoriaByNome(@PathVariable String nome){
        return ResponseEntity.ok(catService.idCategoriaByNome(nome.trim()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        catService.delete(id);

        ResponseEntity.ok();

    }



}
