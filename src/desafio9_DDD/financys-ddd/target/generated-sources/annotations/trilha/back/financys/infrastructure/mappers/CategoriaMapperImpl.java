package trilha.back.financys.infrastructure.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.domain.dtos.reponses.CategoriaResponse;
import trilha.back.financys.domain.dtos.requests.CategoriaRequest;
import trilha.back.financys.domain.entities.Categoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T17:29:38-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toDomain(CategoriaRequest categoriaRequest) {
        if ( categoriaRequest == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaRequest.getId() );
        categoria.setNome( categoriaRequest.getNome() );
        categoria.setDescricao( categoriaRequest.getDescricao() );

        return categoria;
    }

    @Override
    public CategoriaResponse toResponse(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaResponse categoriaResponse = new CategoriaResponse();

        categoriaResponse.setNome( categoria.getNome() );
        categoriaResponse.setDescricao( categoria.getDescricao() );

        return categoriaResponse;
    }

    @Override
    public void update(CategoriaRequest categoriaRequest, Categoria categoria) {
        if ( categoriaRequest == null ) {
            return;
        }

        categoria.setId( categoriaRequest.getId() );
        categoria.setNome( categoriaRequest.getNome() );
        categoria.setDescricao( categoriaRequest.getDescricao() );
    }
}
