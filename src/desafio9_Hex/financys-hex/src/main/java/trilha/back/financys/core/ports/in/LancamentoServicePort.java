package trilha.back.financys.core.ports.in;

import trilha.back.financys.core.domains.Lancamento;

import java.util.List;

public interface LancamentoServicePort {
    Lancamento create(Lancamento lancamento);
    Lancamento update(Lancamento lancamento, Long id);
    List<Lancamento> read();
    Lancamento readById(Long id);
    List<Lancamento> readByPago(Boolean pago);
    void delete(Long id);
    Boolean validaCategoriaById(Long id);
    Integer calculaMedia(Integer x, Integer y);
}
