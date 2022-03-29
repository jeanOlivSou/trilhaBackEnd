package trilha.back.financys.adapters.inbound.http.lancamento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.adapters.dtos.reponses.LancamentoChartResponse;
import trilha.back.financys.adapters.dtos.reponses.LancamentoResponse;
import trilha.back.financys.adapters.dtos.requests.LancamentoRequest;
import trilha.back.financys.adapters.mappers.LancamentoMapperDto;
import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.domains.Lancamento;
import trilha.back.financys.core.services.CategoriaServiceImpl;
import trilha.back.financys.core.services.LancamentoServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {
    private final CategoriaServiceImpl categoriaService;
    private final LancamentoServiceImpl lancamentoService;
    private final LancamentoMapperDto lancamentoMapperDto;

    @PostMapping
    public ResponseEntity<LancamentoResponse>create(@RequestBody @Valid LancamentoRequest lancamentoRequest){
        Lancamento lancamento = lancamentoMapperDto.toDomain(lancamentoRequest);
        lancamento = lancamentoService.create(lancamento);

        LancamentoResponse lancamentoResponse = lancamentoMapperDto.toResponse(lancamento);

        return ResponseEntity.created(null).body(lancamentoResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoResponse>
    update(@RequestBody @Valid LancamentoRequest lancamentoRequest, @PathVariable Long id){
        Lancamento lancamento = lancamentoMapperDto.toDomain(lancamentoRequest);

        Lancamento lancamentoAtual = lancamentoService.update(lancamento, id);

        LancamentoResponse lancamentoResponse = lancamentoMapperDto.toResponse(lancamentoAtual);

        return ResponseEntity.ok(lancamentoResponse);

    }

    @GetMapping
    public ResponseEntity<List<LancamentoResponse>> read(){
        List<Lancamento> lancamentoLista = lancamentoService.read();

        List<LancamentoResponse> lancamentoResponseLista = new ArrayList<>();

        lancamentoLista.stream().forEach(
                lancamento -> lancamentoResponseLista.add(
                                lancamentoMapperDto.toResponse(lancamento)
                        )
        );

        lancamentoResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return ResponseEntity.ok(lancamentoResponseLista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LancamentoResponse> readById(Long id){

        Lancamento lancamento = lancamentoService.readById(id);

        LancamentoResponse lancamentoResponse = lancamentoMapperDto.toResponse(lancamento);

        return ResponseEntity.ok(lancamentoResponse);
    }

    @GetMapping("/pago")
    public ResponseEntity<List<LancamentoResponse>>
    readBypago(@RequestParam Boolean pago){
        List<Lancamento> lancamentoLista = lancamentoService.readByPago(pago);

        List<LancamentoResponse> lancamentoResponseLista = new ArrayList<>();

        lancamentoLista.stream().forEach(
                lancamento -> lancamentoResponseLista.add(
                        lancamentoMapperDto.toResponse(lancamento)
                )
        );

        lancamentoResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return ResponseEntity.ok(lancamentoResponseLista);

    }

    @GetMapping("/calcula/{x}/{y}")
    ResponseEntity<Integer> calcula(@PathVariable Integer x, @PathVariable Integer y){
        return ResponseEntity.ok(lancamentoService.calculaMedia(x, y));
    }


    @GetMapping("/chart")
    ResponseEntity<List<LancamentoChartResponse>> chart(){
        List<Categoria> categoriaLista = categoriaService.read();
        List<Lancamento> lancamentoLista = lancamentoService.read();
        List<LancamentoChartResponse> chartLista = new ArrayList<>();

        categoriaLista.stream()
                .forEach(
                        categoria -> {
                            AtomicReference<Double> total = new AtomicReference<>(0.0);
                            LancamentoChartResponse lancamentoChart = new LancamentoChartResponse();
                            lancamentoChart.setNome(categoria.getNome());

                            lancamentoLista
                                    .stream()
                                    .filter(lancamento -> lancamento.getCategoria().getId() == categoria.getId())
                                    .forEach(
                                            lancamento -> {
                                                String montante = lancamento.getMontante().replace(",",".");
                                                Double somaMontante = Double.parseDouble(montante);

                                                total.updateAndGet(valor -> valor + somaMontante);

                                                lancamentoChart.setTipo(lancamento.getTipo());
                                                lancamentoChart.setTotal(total.get());

                                            }
                                    );
                            chartLista.add(lancamentoChart);
                        }

                );
        return ResponseEntity.ok(chartLista);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        lancamentoService.delete(id);

        ResponseEntity.ok();

    }




}
