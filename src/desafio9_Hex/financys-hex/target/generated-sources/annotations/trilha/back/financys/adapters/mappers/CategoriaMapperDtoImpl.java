package trilha.back.financys.adapters.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.dtos.reponses.CategoriaResponse;
import trilha.back.financys.adapters.dtos.requests.CategoriaRequest;
import trilha.back.financys.core.domains.Categoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-24T09:27:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaMapperDtoImpl implements CategoriaMapperDto {

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
}
