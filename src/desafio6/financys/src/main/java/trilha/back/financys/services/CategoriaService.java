package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.dtos.reponses.CategoriaResponse;
import trilha.back.financys.dtos.requests.CategoriaRequest;
import trilha.back.financys.mappers.CategoriaMapper;
import trilha.back.financys.repositories.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository catRepo;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public CategoriaResponse create(CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaMapper.toDomain(categoriaRequest);

        CategoriaResponse categoriaResponse = categoriaMapper.toResponse(categoria);

        catRepo.save(categoria);

        return categoriaResponse;
    }

    public CategoriaResponse update(CategoriaRequest categoriaRequest, Long id) {

        if (catRepo.findById(id).isPresent()) {

            Categoria categoriaObt = catRepo.findById(id).get();

            categoriaMapper.update(categoriaRequest, categoriaObt);
            catRepo.save(categoriaObt);

            return categoriaMapper.toResponse(categoriaObt);
        } else {
            throw new NoSuchElementException("Categoria não encontrada");
        }
    }

    public List<CategoriaResponse> read() {

        List<CategoriaResponse> categoriaResponseLista = new ArrayList<>();

        catRepo.findAll().stream().forEach(
                categoria ->
                        categoriaResponseLista
                                .add(categoriaMapper.toResponse(categoria))
        );

        return categoriaResponseLista;
    }

    public CategoriaResponse readById(Long id) {

        Categoria categoriaObt = catRepo.findById(id).get();

        return categoriaMapper.toResponse(categoriaObt);
    }

    public void delete(Long id) {

        Categoria categoriaObt = catRepo.findById(id).get();

        catRepo.delete(categoriaObt);
    }

    public String idCategoriaByNome(String nome) {
        Categoria categoriaObt = catRepo.findByNome(nome);

        return "O id da categoria " + categoriaObt.getNome() + " é : " + categoriaObt.getId();

    }

}
