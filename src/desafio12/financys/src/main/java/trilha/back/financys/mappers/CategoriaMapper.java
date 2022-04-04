package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.dtos.reponses.CategoriaResponse;
import trilha.back.financys.dtos.requests.CategoriaRequest;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toDomain(CategoriaRequest categoriaRequest);

    CategoriaResponse toResponse(Categoria categoria);

    void update(CategoriaRequest categoriaRequest, @MappingTarget Categoria categoria);
}
