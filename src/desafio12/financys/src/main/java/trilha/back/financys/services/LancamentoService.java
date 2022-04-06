package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.dtos.reponses.LancamentoChartResponse;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.dtos.requests.LancamentoRequest;
import trilha.back.financys.exceptions.DivideByZeroException;
import trilha.back.financys.exceptions.ListaVaziaException;
import trilha.back.financys.exceptions.NotFoundException;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.repositories.CategoriaRepository;
import trilha.back.financys.repositories.LancamentoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoMapper lancamentoMapper;


    public LancamentoResponse create(LancamentoRequest lancamentoRequest) {
        if (validaCategoriaById(lancamentoRequest.getCategoria().getId()) == false) {
            throw new NotFoundException("Não foi possível criar lançamento," +
                    " categoria informada não encontrada");
        } else {

            Lancamento lancamento = lancamentoMapper.toDomain(lancamentoRequest);

            LancamentoResponse lancamentoResponse = lancamentoMapper.toResponse(lancamento);

            lancamentoRepository.save(lancamento);

            return lancamentoResponse;
        }
    }


    public LancamentoResponse update(LancamentoRequest lancamentoRequest, Long id) {
        if (lancamentoRepository.findById(id).isPresent()) {

            Lancamento lancamento = lancamentoRepository.findById(id).get();

            lancamentoMapper.update(lancamentoRequest, lancamento);

            lancamentoRepository.save(lancamento);

            return lancamentoMapper.toResponse(lancamento);
        } else {
            throw new NoSuchElementException("Lançamento não encontrado");
        }
    }

    public List<LancamentoResponse> read() {
        List<LancamentoResponse> lResponseLista = new ArrayList<>();

        lancamentoRepository.findAll().stream().forEach(
                lancamento ->
                        lResponseLista
                                .add(lancamentoMapper.toResponse(lancamento))
        );

        lResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return lResponseLista;
    }

    public List<LancamentoResponse> readByPago(Boolean pago) {

        List<LancamentoResponse> lResponseLista = new ArrayList<>();

        lancamentoRepository.findByPago(pago).stream().forEach(
                lancamento ->
                        lResponseLista
                                .add(lancamentoMapper.toResponse(lancamento))
        );

        lResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return lResponseLista;
    }

    public LancamentoResponse readByid(Long id) {

        Lancamento lancamentoObt = lancamentoRepository.findById(id).get();

        return lancamentoMapper.toResponse(lancamentoObt);
    }

    public void delete(Long id) {

        Lancamento lancamentoObt = lancamentoRepository.findById(id).get();

        lancamentoRepository.delete(lancamentoObt);

    }

    public Boolean validaCategoriaById(Long id) {

        if (categoriaRepository.findById(id).isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public List<LancamentoChartResponse> chartv1() {
        List<LancamentoChartResponse> listaChart = new ArrayList<>();
        List<Lancamento> lancamentoLista = lancamentoRepository.findAll();
        List<Categoria> categoriaLista = categoriaRepository.findAll();

        for (Categoria categoria : categoriaLista){
            Double total = 0.0;

            LancamentoChartResponse lancamentoChartResponse = new LancamentoChartResponse();

            lancamentoChartResponse.setNome(categoria.getNome());

            for (Lancamento lancamento : lancamentoLista){
                if(lancamento.getCategoria().getId() == categoria.getId()){

                    String montante = lancamento.getMontante().replace(",", ".");

                    Double somaMontante = Double.parseDouble(montante);

                    total += somaMontante;

                    lancamentoChartResponse.setTotal(total);
                    lancamentoChartResponse.setTipo(lancamento.getTipo());

                }

            }

            listaChart.add(lancamentoChartResponse);

        }

        return listaChart;
    }



    public List<LancamentoChartResponse> chart() {

        List<LancamentoChartResponse> listaChart = new ArrayList<>();

        categoriaRepository.findAll().stream().forEach(
                categoria -> {
                    AtomicReference<Double> total = new AtomicReference<>(0.0);
                    LancamentoChartResponse lancamentoChartResponse = new LancamentoChartResponse();
                    lancamentoChartResponse.setNome(categoria.getNome());

                    lancamentoRepository.findAll().stream()
                            .filter(lancamento -> lancamento.getCategoria().getId() == categoria.getId())
                            .forEach(
                                    lancamento -> {
                                        String montante = lancamento.getMontante().replace(",", ".");

                                        Double somaMontante = Double.parseDouble(montante);

                                        total.updateAndGet(valor -> valor + somaMontante);

                                        lancamentoChartResponse.setTipo(lancamento.getTipo());
                                        lancamentoChartResponse.setTotal(total.get());
                                    }
                            );

                    listaChart.add(lancamentoChartResponse);
                }
        );

        return listaChart;
    }

    public Integer calculaMedia(Integer x, Integer y){

        try {
            return (x/y);
        }
        catch (ArithmeticException e){
            throw new DivideByZeroException("Não é permitido divisão por zero");
        }

    }

    public List<LancamentoResponse> filter(String data, String montante, Boolean pago){

        if (data == null || montante == null){
            throw new NotFoundException("Parâmetros com valores errados");
        }

            List<LancamentoResponse> lResponseLista = new ArrayList<>();

            lancamentoRepository.findByDataAndMontanteAndPago(data, montante, pago).stream()
                    .forEach(
                            lancamento ->
                                    lResponseLista
                                            .add(lancamentoMapper.toResponse(lancamento)));

            if (lResponseLista.size() == 0){
                throw new ListaVaziaException("Não existe os dados pelo parâmetro passado");
            }

            return lResponseLista;
    }

}
