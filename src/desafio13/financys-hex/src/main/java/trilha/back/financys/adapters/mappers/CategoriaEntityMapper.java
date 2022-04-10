package trilha.back.financys.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;
import trilha.back.financys.core.domains.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {
    CategoriaEntityMapper INSTANCE = Mappers.getMapper(CategoriaEntityMapper.class);

    CategoriaEntity toEntity(Categoria categoria);
    Categoria toCoreDomain(CategoriaEntity categoria);
}
