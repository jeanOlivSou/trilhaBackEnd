package trilha.back.financys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.domains.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
