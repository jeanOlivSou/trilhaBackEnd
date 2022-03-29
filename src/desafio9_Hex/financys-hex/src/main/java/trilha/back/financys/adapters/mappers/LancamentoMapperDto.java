package trilha.back.financys.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.adapters.outbound.persistence.entities.LancamentoEntity;
import trilha.back.financys.adapters.dtos.reponses.LancamentoResponse;
import trilha.back.financys.adapters.dtos.requests.LancamentoRequest;
import trilha.back.financys.core.domains.Lancamento;

@Mapper(componentModel = "spring")
public interface LancamentoMapperDto {
   LancamentoMapperDto INSTANCE = Mappers.getMapper(LancamentoMapperDto.class);

   Lancamento toDomain(LancamentoRequest lancamentoRequest);

   LancamentoResponse toResponse(Lancamento lancamento);

}
