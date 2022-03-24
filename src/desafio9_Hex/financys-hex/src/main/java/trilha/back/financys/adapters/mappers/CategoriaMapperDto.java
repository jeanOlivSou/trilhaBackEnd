package trilha.back.financys.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.adapters.dtos.reponses.CategoriaResponse;
import trilha.back.financys.adapters.dtos.requests.CategoriaRequest;
import trilha.back.financys.core.domains.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapperDto {
    CategoriaMapperDto INSTANCE = Mappers.getMapper(CategoriaMapperDto.class);

    Categoria toDomain(CategoriaRequest categoriaRequest);

    CategoriaResponse toResponse(Categoria categoria);
}
