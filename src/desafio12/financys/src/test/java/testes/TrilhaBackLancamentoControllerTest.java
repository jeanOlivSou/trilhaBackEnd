package testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import trilha.back.financys.controllers.LancamentoController;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.exceptions.ListaVaziaException;
import trilha.back.financys.services.LancamentoService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TrilhaBackLancamentoControllerTest {

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    LancamentoService lancamentoService;

    @InjectMocks
    LancamentoController lancamentoController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(lancamentoController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void deveRetornarOkSeRetornaLancamentos() throws Exception{
        mockMvc.perform(get("/lancamentos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("Application/Json"));
    }


    @Test
    void DeveFalharSeRetornarListaVazia() throws Exception{
        when(lancamentoService.filter(null, null, false)).thenThrow(ListaVaziaException.class);

        mockMvc.perform(get("/lancamentos/filter")
                .param("data", "null")
                .param("montante", "null")
                .param("pago", "false").contentType("Application/Json"))
                .andExpect(status().isNoContent());

    }


}
