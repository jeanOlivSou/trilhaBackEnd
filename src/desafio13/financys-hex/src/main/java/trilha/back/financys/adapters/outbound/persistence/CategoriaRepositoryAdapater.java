package trilha.back.financys.adapters.outbound.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.mappers.CategoriaEntityMapper;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;
import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class CategoriaRepositoryAdapater implements CategoriaRepositoryPort {

    private final JpaCategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    public CategoriaRepositoryAdapater(JpaCategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaEntityMapper = categoriaEntityMapper;
    }


    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity categoriasalva = categoriaRepository.save(categoriaEntityMapper.toEntity(categoria));
        return  categoriaEntityMapper.toCoreDomain(categoriasalva);
    }

    @Override
    public List<Categoria> findAll() {

        List<Categoria> categoriaLista = new ArrayList<>();

        categoriaRepository.findAll().stream().forEach(
                categoria -> categoriaLista.add(
                        categoriaEntityMapper.toCoreDomain(categoria)
                )
        );

        return categoriaLista;
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
        if (categoriaEntity.isPresent()){
            return Optional.of(categoriaEntityMapper.toCoreDomain(categoriaEntity.get()));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Categoria findByName(String name) {
        CategoriaEntity categoriaobt = categoriaRepository.findByName(name);

        return categoriaEntityMapper.toCoreDomain(categoriaobt);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoriaEntityMapper.toEntity(categoria));
    }
}
