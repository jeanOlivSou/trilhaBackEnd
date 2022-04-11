package trilha.back.financys.core.ports.out;

import trilha.back.financys.core.domains.Lancamento;

import java.util.List;
import java.util.Optional;

public interface LancamentoRepositoryPort {
    Lancamento save(Lancamento lancamento);

    List<Lancamento> findAll();

    Optional<Lancamento> findById(Long id);

    List<Lancamento> findByPago(Boolean pago);

    void delete(Lancamento lancamento);

}
