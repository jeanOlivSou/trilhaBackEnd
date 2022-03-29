package trilha.back.financys.adapters.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;
import trilha.back.financys.core.domains.Categoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-24T09:27:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaEntityMapperImpl implements CategoriaEntityMapper {

    @Override
    public CategoriaEntity toEntity(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setId( categoria.getId() );
        categoriaEntity.setNome( categoria.getNome() );
        categoriaEntity.setDescricao( categoria.getDescricao() );

        return categoriaEntity;
    }

    @Override
    public Categoria toCoreDomain(CategoriaEntity categoria) {
        if ( categoria == null ) {
            return null;
        }

        Categoria categoria1 = new Categoria();

        categoria1.setId( categoria.getId() );
        categoria1.setNome( categoria.getNome() );
        categoria1.setDescricao( categoria.getDescricao() );

        return categoria1;
    }
}
