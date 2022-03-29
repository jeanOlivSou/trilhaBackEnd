package trilha.back.financys.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.adapters.outbound.persistence.entities.LancamentoEntity;
import trilha.back.financys.core.domains.Lancamento;

@Mapper(componentModel = "spring")
public interface LancamentoEntityMapper {
    LancamentoEntityMapper INSTANCE = Mappers.getMapper(LancamentoEntityMapper.class);

    LancamentoEntity toEntity(Lancamento lancamento);
    Lancamento toCoreDomain(LancamentoEntity lancamentoEntity);

}
