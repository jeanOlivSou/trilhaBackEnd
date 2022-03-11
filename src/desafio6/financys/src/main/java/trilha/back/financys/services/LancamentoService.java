package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.dtos.reponses.LancamentoChartResponse;
import trilha.back.financys.dtos.reponses.LancamentoResponse;
import trilha.back.financys.dtos.requests.LancamentoRequest;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.repositories.CategoriaRepository;
import trilha.back.financys.repositories.LancamentoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lRepo;

    @Autowired
    CategoriaRepository catRepo;

    @Autowired
    LancamentoMapper lancamentoMapper;

    public LancamentoResponse create(LancamentoRequest lancamentoRequest) {
        if (validaCategoriaById(lancamentoRequest.getCategoria().getId()) == false){
            throw new RuntimeException("Não foi possível criar lançamento," +
                    " categoria informada não encontrada");
        }

        else {

            Lancamento lancamento = lancamentoMapper.toDomain(lancamentoRequest);

            LancamentoResponse lancamentoResponse = lancamentoMapper.toResponse(lancamento);

            lRepo.save(lancamento);

            return lancamentoResponse;
        }
    }


    public LancamentoResponse update(LancamentoRequest lancamentoRequest, Long id) {
        if (lRepo.findById(id).isPresent()) {

            Lancamento lancamento = lRepo.findById(id).get();

            lancamentoMapper.update(lancamentoRequest, lancamento);

            lRepo.save(lancamento);

            return lancamentoMapper.toResponse(lancamento);
        }

        else {
            throw new NoSuchElementException("Lançamento não encontrado");
        }
    }

    public List<LancamentoResponse> read() {
        List<LancamentoResponse> lResponseLista = new ArrayList<>();

        lRepo.findAll().stream().forEach(
                lancamento ->
                        lResponseLista
                                .add(lancamentoMapper.toResponse(lancamento))
        );

        lResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return lResponseLista;
    }

    public List<LancamentoResponse> readByPago(Boolean pago) {

        List<LancamentoResponse> lResponseLista =  new ArrayList<>();

                lRepo.findByPago(pago).stream().forEach(
                        lancamento ->
                                lResponseLista
                                        .add(lancamentoMapper.toResponse(lancamento))
                );

        lResponseLista.sort(Comparator.comparing(LancamentoResponse::getData));

        return lResponseLista;
    }

    public LancamentoResponse readByid(Long id) {

        Lancamento lancamentoObt = lRepo.findById(id).get();

        return lancamentoMapper.toResponse(lancamentoObt);
    }

    public void delete(Long id) {

        Lancamento lancamentoObt = lRepo.findById(id).get();

        lRepo.delete(lancamentoObt);

    }

    public Boolean validaCategoriaById(Long id){

        if (catRepo.findById(id).isPresent()){
            return true;
        }
        else {
            return false;
        }
    }

    public List<LancamentoChartResponse> chart(){
        List<Categoria> categoriaLista = catRepo.findAll();
        List<Lancamento> lancamentoLista = lRepo.findAll();

        List<LancamentoChartResponse> listaChart = new ArrayList<>();

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

}
