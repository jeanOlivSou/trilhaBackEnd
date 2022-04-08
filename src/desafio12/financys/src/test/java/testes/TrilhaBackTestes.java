package testes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.exceptions.NotFoundException;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.repositories.LancamentoRepository;
import trilha.back.financys.services.LancamentoService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
public class TrilhaBackTestes {

    @Mock
    private LancamentoRepository lancamentoRepository;

    @Mock
    LancamentoMapper lancamentoMapper;

    @InjectMocks
    private LancamentoService lancamentoService;

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
        lancamentoResponse.setPago( lancamento.isPago() );
        lancamentoResponse.setCategoria(null);

        return lancamentoResponse;
    }


    @Test
    void lancamentoServiceRead(){
        //When
        lancamentoService.read();

        //Then
        Mockito.verify(lancamentoRepository).findAll();
    }

    @Test
    void deve_FalhaSeMontanteForNull(){
        assertThrows(NotFoundException.class, () -> lancamentoService.filter("06/07/2022", null, true));
    }

    @Test
    void deve_FalhaSeDataForNull(){
        assertThrows(NotFoundException.class, () -> lancamentoService.filter(null, "500,52", true));
    }

    @Test
    void lancamentoServiceFilterTest(){

        String data = "15/05/2022";
        String montante = "4800,00";
        Boolean pago = true;

        Categoria categoria = new Categoria(1L, "Salário", "Lorem ipsum");

        List<Lancamento> lancamentoListaMock = new ArrayList<>();
        lancamentoListaMock.add(new Lancamento(1L, "Lançamento 1", "Lorem ipsum", "Receita", montante, data, pago, categoria));
        lancamentoListaMock.add(new Lancamento(2L, "Lançamento 2", "Lorem ipsum", "Despesa", "522,62", "15/04/2022", false, categoria));

        when(lancamentoMapper.toResponse(any(Lancamento.class))).thenAnswer((args) -> toResponse(args.getArgument(0)) );

        when(lancamentoRepository.findByDataAndMontanteAndPago(data, montante, pago)).thenReturn(lancamentoListaMock);

        List<LancamentoResponse> lancamentoResponseLista = lancamentoService.filter(data, montante, pago);

        assertThat(lancamentoResponseLista).isNotNull();
        assertThat(lancamentoResponseLista.isEmpty()).isFalse();
        assertThat(lancamentoResponseLista.get(0).getTipo()).isEqualTo("Receita");
        assertThat(lancamentoResponseLista.get(1).getTipo()).isEqualTo("Despesa");

    }



}
