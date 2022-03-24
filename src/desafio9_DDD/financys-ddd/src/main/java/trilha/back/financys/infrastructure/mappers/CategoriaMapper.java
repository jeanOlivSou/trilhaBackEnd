package trilha.back.financys.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.domain.entities.Categoria;
import trilha.back.financys.domain.dtos.reponses.CategoriaResponse;
import trilha.back.financys.domain.dtos.requests.CategoriaRequest;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toDomain(CategoriaRequest categoriaRequest);

    CategoriaResponse toResponse(Categoria categoria);

    void update(CategoriaRequest categoriaRequest, @MappingTarget Categoria categoria);
}
