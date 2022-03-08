package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Lancamento;
import trilha.back.financys.repositories.CategoriaRepository;
import trilha.back.financys.repositories.LancamentoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lRepo;

    @Autowired
    CategoriaRepository catRepo;

    public Lancamento create(Lancamento lancamento) {

        return lRepo.save(lancamento);

    }


    public Lancamento update(Lancamento lancamento, Long id) {
        if (lRepo.findById(id).isPresent()) {

            Lancamento lancamentoObt = lRepo.findById(id).get();

            lancamentoObt.setNome(lancamento.getNome());
            lancamentoObt.setDescricao(lancamento.getDescricao());
            lancamentoObt.setTipo(lancamento.getTipo());
            lancamentoObt.setMontante(lancamento.getMontante());
            lancamentoObt.setData(lancamento.getData());
            lancamentoObt.setPago(lancamento.isPago());
            lancamentoObt.setCategoria(lancamento.getCategoria());

            return lRepo.save(lancamentoObt);
        }
        else {
            throw new NoSuchElementException("Lançamento não encontrado");
        }
    }

    public List<Lancamento> read() {
        List<Lancamento> listaLancamento = lRepo.findAll();

        listaLancamento.sort(Comparator.comparing(Lancamento::getData));

        return listaLancamento;
    }

    public List<Lancamento> readByPago(Boolean pago) {
        List<Lancamento> listaLancamento = lRepo.findByPago(pago);

        listaLancamento.sort(Comparator.comparing(Lancamento::getData));

        return listaLancamento;
    }

    public Lancamento readByid(Long id) {
        return lRepo.findById(id).get();
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

}
