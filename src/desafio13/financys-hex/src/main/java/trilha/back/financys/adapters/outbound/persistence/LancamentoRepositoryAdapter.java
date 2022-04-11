package trilha.back.financys.adapters.outbound.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.mappers.LancamentoEntityMapper;
import trilha.back.financys.adapters.outbound.persistence.entities.LancamentoEntity;
import trilha.back.financys.core.domains.Lancamento;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class LancamentoRepositoryAdapter implements LancamentoRepositoryPort {

    private final JpaLancamentoRepository lancamentoRepository;
    private final LancamentoEntityMapper lancamentoEntityMapper;

    public LancamentoRepositoryAdapter(JpaLancamentoRepository lancamentoRepository, LancamentoEntityMapper lancamentoEntityMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.lancamentoEntityMapper = lancamentoEntityMapper;
    }


    @Override
    public Lancamento save(Lancamento lancamento) {
        LancamentoEntity lancamentoSalvo = lancamentoRepository.save(lancamentoEntityMapper.toEntity(lancamento));
        return lancamentoEntityMapper.toCoreDomain(lancamentoSalvo);
    }

    @Override
    public List<Lancamento> findAll() {
        List<Lancamento> lancamentoLista = new ArrayList<>();

        lancamentoRepository.findAll().stream().forEach(
                lancamentoEntity -> lancamentoLista.add(
                        lancamentoEntityMapper.toCoreDomain(lancamentoEntity)
                )
        );

        return lancamentoLista;
    }

    @Override
    public Optional<Lancamento> findById(Long id) {

        Optional<LancamentoEntity> lancamentoEntity = lancamentoRepository.findById(id);

        if (lancamentoEntity.isPresent()){
            return Optional.of(lancamentoEntityMapper.toCoreDomain(lancamentoEntity.get()));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<Lancamento> findByPago(Boolean paid) {
        List<Lancamento> lancamentoLista = new ArrayList<>();

        lancamentoRepository.findByPaid(paid).stream().forEach(
                lancamentoEntity -> lancamentoLista.add(
                        lancamentoEntityMapper.toCoreDomain(lancamentoEntity)
                )
        );


        return lancamentoLista;
    }

    @Override
    public void delete(Lancamento lancamento) {
        lancamentoRepository.delete(lancamentoEntityMapper.toEntity(lancamento));
    }
}
