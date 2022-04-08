package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.dtos.reponses.CategoriaResponse;
import trilha.back.financys.dtos.requests.CategoriaRequest;
import trilha.back.financys.exceptions.NotFoundException;
import trilha.back.financys.mappers.CategoriaMapper;
import trilha.back.financys.repositories.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public CategoriaResponse create(CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaMapper.toDomain(categoriaRequest);

        CategoriaResponse categoriaResponse = categoriaMapper.toResponse(categoria);

        categoriaRepository.save(categoria);

        return categoriaResponse;
    }

    public CategoriaResponse update(CategoriaRequest categoriaRequest, Long id) {

        if (categoriaRepository.findById(id).isPresent()) {

            Categoria categoriaObt = categoriaRepository.findById(id).get();

            categoriaMapper.update(categoriaRequest, categoriaObt);
            categoriaRepository.save(categoriaObt);

            return categoriaMapper.toResponse(categoriaObt);
        } else {
            throw new NoSuchElementException("Categoria não encontrada");
        }
    }

    public List<CategoriaResponse> read() {

        List<CategoriaResponse> categoriaResponseLista = new ArrayList<>();

        categoriaRepository.findAll().stream().forEach(
                categoria ->
                        categoriaResponseLista
                                .add(categoriaMapper.toResponse(categoria))
        );

        return categoriaResponseLista;
    }

    public CategoriaResponse readById(Long id) {

        Categoria categoriaObt = categoriaRepository.findById(id).get();

        return categoriaMapper.toResponse(categoriaObt);
    }

    public void delete(Long id) {

        Categoria categoriaObt = categoriaRepository.findById(id).get();

        categoriaRepository.delete(categoriaObt);
    }

    public String idCategoriaByNome(String nome) {
        try {
            Categoria categoriaObt = categoriaRepository.findByNome(nome);

            return "O id da categoria " + categoriaObt.getNome() + " é : " + categoriaObt.getId();
        }
        catch (NullPointerException e){
            throw new NotFoundException("Não foi possível encontrar a categoria pelo nome");
        }


    }

}
