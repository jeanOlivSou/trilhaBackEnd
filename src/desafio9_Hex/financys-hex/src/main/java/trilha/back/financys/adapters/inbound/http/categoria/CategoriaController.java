package trilha.back.financys.adapters.inbound.http.categoria;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.adapters.dtos.reponses.CategoriaResponse;
import trilha.back.financys.adapters.dtos.requests.CategoriaRequest;
import trilha.back.financys.adapters.mappers.CategoriaMapperDto;
import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.services.CategoriaServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl categoriaService;

    private final CategoriaMapperDto categoriaMapperDto;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(@RequestBody @Valid CategoriaRequest categoriaRequest){

        Categoria categoria = categoriaMapperDto.toDomain(categoriaRequest);
        categoria = categoriaService.create(categoria);

        CategoriaResponse categoriaResponse = categoriaMapperDto.toResponse(categoria);

        return ResponseEntity
                .created(null )
                .body(categoriaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse>
    update(@RequestBody @Valid CategoriaRequest categoriaRequest, @PathVariable Long id){

        Categoria categoria = categoriaMapperDto.toDomain(categoriaRequest);

        Categoria categoriaAtual =  categoriaService.update(categoria, id);

        CategoriaResponse categoriaResponse = categoriaMapperDto.toResponse(categoriaAtual);

        return ResponseEntity.ok(categoriaResponse);

    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> read(){

        List<Categoria> categoriaLista = categoriaService.read();

        List<CategoriaResponse> categoriaResponse = new ArrayList<>();

        categoriaLista.stream().forEach(
                categoria -> categoriaResponse.add(
                        categoriaMapperDto.toResponse(categoria)
                )
        );

        return ResponseEntity.ok(categoriaResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> readById(@PathVariable Long id){
        Categoria categoria = categoriaService.readById(id);
        CategoriaResponse categoriaResponse = categoriaMapperDto.toResponse(categoria);
        return ResponseEntity.ok(categoriaResponse);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<String> idCategoriaByNome(@PathVariable String nome){
        return  ResponseEntity.ok(categoriaService.idCategoriaByNome(nome));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        categoriaService.delete(id);

        ResponseEntity.ok();

    }



}
