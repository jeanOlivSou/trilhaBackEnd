package trilha.back.financys.core.ports.in;

import trilha.back.financys.core.domains.Categoria;

import java.util.List;

public interface CategoriaServicePort {
    Categoria create(Categoria categoria);
    Categoria update(Categoria categoria, Long id);
    List<Categoria> read();
    Categoria readById(Long id);
    void delete(Long id);
    String idCategoriaByNome(String nome);
}
