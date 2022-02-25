package trilha.back.financys.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.domains.Categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }


    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Categoria categoria){
        categorias.add(categoria);

        return ResponseEntity
                .created(null)
                .body(categoria.getId());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> read(){

        return ResponseEntity.ok(getCategorias());
    }

}
