package trilha.back.financys.core.ports.out;

import trilha.back.financys.core.domains.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositoryPort {
    Categoria save(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria findByNome(String nome);

    void delete(Categoria categoria);
}
