package trilha.back.financys.adapters.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.adapters.outbound.persistence.entities.CategoriaEntity;
import trilha.back.financys.adapters.outbound.persistence.entities.LancamentoEntity;
import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.domains.Lancamento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-10T13:36:04-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LancamentoEntityMapperImpl implements LancamentoEntityMapper {

    @Override
    public LancamentoEntity toEntity(Lancamento lancamento) {
        if ( lancamento == null ) {
            return null;
        }

        LancamentoEntity lancamentoEntity = new LancamentoEntity();

        lancamentoEntity.setId( lancamento.getId() );
        lancamentoEntity.setNome( lancamento.getNome() );
        lancamentoEntity.setDescricao( lancamento.getDescricao() );
        lancamentoEntity.setTipo( lancamento.getTipo() );
        lancamentoEntity.setMontante( lancamento.getMontante() );
        lancamentoEntity.setData( lancamento.getData() );
        lancamentoEntity.setPago( lancamento.getPago() );
        lancamentoEntity.setCategoria( categoriaToCategoriaEntity( lancamento.getCategoria() ) );

        return lancamentoEntity;
    }

    @Override
    public Lancamento toCoreDomain(LancamentoEntity lancamentoEntity) {
        if ( lancamentoEntity == null ) {
            return null;
        }

        Lancamento lancamento = new Lancamento();

        lancamento.setId( lancamentoEntity.getId() );
        lancamento.setNome( lancamentoEntity.getNome() );
        lancamento.setDescricao( lancamentoEntity.getDescricao() );
        lancamento.setTipo( lancamentoEntity.getTipo() );
        lancamento.setMontante( lancamentoEntity.getMontante() );
        lancamento.setData( lancamentoEntity.getData() );
        lancamento.setPago( lancamentoEntity.isPago() );
        lancamento.setCategoria( categoriaEntityToCategoria( lancamentoEntity.getCategoria() ) );

        return lancamento;
    }

    protected CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setId( categoria.getId() );
        categoriaEntity.setNome( categoria.getNome() );
        categoriaEntity.setDescricao( categoria.getDescricao() );

        return categoriaEntity;
    }

    protected Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaEntity.getId() );
        categoria.setNome( categoriaEntity.getNome() );
        categoria.setDescricao( categoriaEntity.getDescricao() );

        return categoria;
    }
}
