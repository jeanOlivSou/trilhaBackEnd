package trilha.back.financys.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;

@Repository
public interface JpaCategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
    CategoriaEntity findByNome(String nome);
}
