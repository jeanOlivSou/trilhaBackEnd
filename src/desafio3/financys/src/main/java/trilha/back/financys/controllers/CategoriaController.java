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
        categoria.setId(categoria.getId());

        return ResponseEntity
                .created(null)
                .body(categoria.getId());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> read(){
        Categoria c1 =
                new Categoria(
                        1L,
                        "Vestuário",
                        "Aquisição de roupas");

        Categoria c2 = new Categoria();
        c2.setId(2L);
        c2.setNome("Salário");
        c2.setDescricao("Salário mensal referente ao mês de maio");


        setCategorias(Arrays.asList(c1, c2));
        return ResponseEntity.ok(getCategorias());
    }

}
