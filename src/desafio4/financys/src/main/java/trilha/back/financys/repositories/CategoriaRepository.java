package trilha.back.financys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.domains.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
