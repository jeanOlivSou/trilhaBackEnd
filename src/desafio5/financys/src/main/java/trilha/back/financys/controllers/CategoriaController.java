package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.repositories.CategoriaRepository;
import trilha.back.financys.services.CategoriaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService catService;


    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){

        Categoria categoriaCriada = catService.create(categoria);

        return ResponseEntity
                .created(null)
                .body(categoriaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Long id){

        Categoria categoriaAtual = catService.update(categoria, id);

        return ResponseEntity.ok(categoriaAtual);

    }

    @GetMapping
    public ResponseEntity<List<Categoria>> read(){
        return ResponseEntity.ok(catService.read());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> readById(@PathVariable Long id){
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
