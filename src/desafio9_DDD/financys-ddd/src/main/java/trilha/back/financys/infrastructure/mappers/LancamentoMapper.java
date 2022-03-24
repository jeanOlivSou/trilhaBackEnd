package trilha.back.financys.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.domain.entities.Lancamento;
import trilha.back.financys.domain.dtos.reponses.LancamentoResponse;
import trilha.back.financys.domain.dtos.requests.LancamentoRequest;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {
   LancamentoMapper INSTANCE = Mappers.getMapper(LancamentoMapper.class);

   Lancamento toDomain(LancamentoRequest lancamentoRequest);

   LancamentoResponse toResponse(Lancamento lancamento);

   void update(LancamentoRequest lancamentoRequest, @MappingTarget Lancamento lancamento);
}
