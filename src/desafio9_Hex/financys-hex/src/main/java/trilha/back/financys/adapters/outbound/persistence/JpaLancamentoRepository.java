package trilha.back.financys.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.adapters.outbound.persistence.entities.LancamentoEntity;

import java.util.List;

@Repository
public interface JpaLancamentoRepository extends JpaRepository<LancamentoEntity, Long> {
    List<LancamentoEntity> findByPago(Boolean pago);
}
