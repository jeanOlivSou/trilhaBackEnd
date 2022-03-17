package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.dtos.requests.LancamentoRequest;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {
   LancamentoMapper INSTANCE = Mappers.getMapper(LancamentoMapper.class);

   Lancamento toDomain(LancamentoRequest lancamentoRequest);

   LancamentoResponse toResponse(Lancamento lancamento);

   void update(LancamentoRequest lancamentoRequest, @MappingTarget Lancamento lancamento);
}
