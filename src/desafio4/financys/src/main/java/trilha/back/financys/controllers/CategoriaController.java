package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.repositories.CategoriaRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository catRepo;


    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){

        catRepo.save(categoria);

        return ResponseEntity
                .created(null)
                .body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, Long id){

        if (catRepo.findById(id).isPresent()){
            Categoria categoriaObt = catRepo.findById(id).get();

            categoriaObt.setNome(categoria.getNome());
            categoriaObt.setDescricao(categoria.getDescricao());

            catRepo.save(categoriaObt);

            return ResponseEntity.ok(categoriaObt);
        }

        else {
            throw new NoSuchElementException("Categoria não encontrada");
        }

    }

    @GetMapping
    public ResponseEntity<List<Categoria>> read(){
        return ResponseEntity.ok(catRepo.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> readById(@PathVariable Long id){
        return ResponseEntity.ok(catRepo.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        Categoria categoriaObt = catRepo.findById(id).get();

        ResponseEntity.ok();
        catRepo.delete(categoriaObt);
    }

}
