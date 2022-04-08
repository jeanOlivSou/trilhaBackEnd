package trilha.back.financys.controllers;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.exceptions.ListaVaziaException;
import trilha.back.financys.exceptions.NotFoundException;
import trilha.back.financys.services.LancamentoService;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LancamentoController.class)
public class TrilhaBackLancamentoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LancamentoService lancamentoService;



    @Test
    void deveRetornarOkSeRetornaLancamentos() throws Exception{
        mockMvc.perform(get("/lancamentos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    void deveRetornarOkSeRetornaLancamentoPorId() throws Exception{
        Long lancamentoIdMock = 1L;
        given(lancamentoService.readByid(lancamentoIdMock)).willReturn(any(LancamentoResponse.class));

        mockMvc.perform(get("/lancamentos/{id}", lancamentoIdMock))
                .andExpect(status().isOk());

    }
    @Test
    void DeveFalharSeNaoEncontrarId() throws Exception{
        Long lancamentoIdMock = 1L;

        given(lancamentoService.readByid(lancamentoIdMock)).willThrow(NotFoundException.class);

        mockMvc.perform(get("/lancamentos/{id}", lancamentoIdMock))
                .andExpect(status().isNotFound());
    }

    @Test
    void DeveFalharSeRetornarComParametrosInvalidos() throws Exception{
        when(lancamentoService.filter(null, null, true)).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/lancamentos/filter")
                .param("pago", "true").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    void DeveFalharSeNaoEncontraLancamento() throws Exception{
        when(lancamentoService.filter("05/05/2022", "295,50", false)).thenThrow(ListaVaziaException.class);

        mockMvc.perform(get("/lancamentos/filter")
                .param("data", "05/05/2022")
                .param("montante", "295,50")
                .param("pago", "false").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    void DeveRetornarOkSeRetonaFiltro() throws Exception{

        mockMvc.perform(get("/lancamentos/filter")
                        .param("data", "05/05/2022")
                        .param("montante", "295,50")
                        .param("pago", "false").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
