package trilha.back.financys.adapters.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.dtos.reponses.CategoriaResponse;
import trilha.back.financys.adapters.dtos.reponses.LancamentoResponse;
import trilha.back.financys.adapters.dtos.requests.CategoriaRequest;
import trilha.back.financys.adapters.dtos.requests.LancamentoRequest;
import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.domains.Lancamento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-24T09:27:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LancamentoMapperDtoImpl implements LancamentoMapperDto {

    @Override
    public Lancamento toDomain(LancamentoRequest lancamentoRequest) {
        if ( lancamentoRequest == null ) {
            return null;
        }

        Lancamento lancamento = new Lancamento();

        lancamento.setId( lancamentoRequest.getId() );
        lancamento.setNome( lancamentoRequest.getNome() );
        lancamento.setDescricao( lancamentoRequest.getDescricao() );
        lancamento.setTipo( lancamentoRequest.getTipo() );
        lancamento.setMontante( lancamentoRequest.getMontante() );
        lancamento.setData( lancamentoRequest.getData() );
        lancamento.setPago( lancamentoRequest.getPago() );
        lancamento.setCategoria( categoriaRequestToCategoria( lancamentoRequest.getCategoria() ) );

        return lancamento;
    }

    @Override
    public LancamentoResponse toResponse(Lancamento lancamento) {
        if ( lancamento == null ) {
            return null;
        }

        LancamentoResponse lancamentoResponse = new LancamentoResponse();

        lancamentoResponse.setNome( lancamento.getNome() );
        lancamentoResponse.setDescricao( lancamento.getDescricao() );
        lancamentoResponse.setTipo( lancamento.getTipo() );
        lancamentoResponse.setMontante( lancamento.getMontante() );
        lancamentoResponse.setData( lancamento.getData() );
        lancamentoResponse.setPago( lancamento.getPago() );
        lancamentoResponse.setCategoria( categoriaToCategoriaResponse( lancamento.getCategoria() ) );

        return lancamentoResponse;
    }

    protected Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest) {
        if ( categoriaRequest == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaRequest.getId() );
        categoria.setNome( categoriaRequest.getNome() );
        categoria.setDescricao( categoriaRequest.getDescricao() );

        return categoria;
    }

    protected CategoriaResponse categoriaToCategoriaResponse(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaResponse categoriaResponse = new CategoriaResponse();

        categoriaResponse.setNome( categoria.getNome() );
        categoriaResponse.setDescricao( categoria.getDescricao() );

        return categoriaResponse;
    }
}
