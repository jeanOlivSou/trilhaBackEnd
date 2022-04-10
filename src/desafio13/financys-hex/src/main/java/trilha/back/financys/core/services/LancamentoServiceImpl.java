package trilha.back.financys.core.services;

import trilha.back.financys.adapters.exceptions.DivideByZeroException;
import trilha.back.financys.core.domains.Lancamento;
import trilha.back.financys.core.exceptions.NotFoundException;
import trilha.back.financys.core.ports.in.LancamentoServicePort;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;

import java.util.List;

public class LancamentoServiceImpl implements LancamentoServicePort {

    private final LancamentoRepositoryPort lancamentoRepositoryPort;
    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public LancamentoServiceImpl(LancamentoRepositoryPort lancamentoRepositoryPort, CategoriaRepositoryPort categoriaRepositoryPort) {
        this.lancamentoRepositoryPort = lancamentoRepositoryPort;
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Lancamento create(Lancamento lancamento) {
        if (validaCategoriaById(lancamento.getCategoryId().getId()) == false){
            throw new NotFoundException("Não foi possível criar lançamento," +
                    " categoria informada não encontrada");
        }
        else {
            return lancamentoRepositoryPort.save(lancamento);
        }
    }

    @Override
    public Lancamento update(Lancamento lancamento, Long id) {

        Lancamento lancamentoObt = lancamentoRepositoryPort.findById(id).get();

        lancamentoObt.setName(lancamento.getName());
        lancamentoObt.setDescription(lancamento.getDescription());
        lancamentoObt.setType(lancamento.getType());
        lancamentoObt.setAmount(lancamento.getAmount());
        lancamentoObt.setPaid(lancamento.getPaid());
        lancamentoObt.setCategoryId(lancamento.getCategoryId());


        return lancamentoRepositoryPort.save(lancamentoObt);
    }

    @Override
    public List<Lancamento> read() {
        return lancamentoRepositoryPort.findAll();
    }

    @Override
    public Lancamento readById(Long id) {
        if(lancamentoRepositoryPort.findById(id).isPresent()) {
            Lancamento lancamento = lancamentoRepositoryPort.findById(id).get();
            return lancamento;
        }
        else {
            throw new NotFoundException("Não foi possível encontrar o lancamento com o ID informado");
        }

    }

    @Override
    public List<Lancamento> readByPago(Boolean pago) {
        return lancamentoRepositoryPort.findByPago(pago);
    }

    @Override
    public void delete(Long id) {
        Lancamento lancamentoObt = lancamentoRepositoryPort.findById(id).get();

        lancamentoRepositoryPort.delete(lancamentoObt);
    }

    @Override
    public Boolean validaCategoriaById(Long id) {
        if (categoriaRepositoryPort.findById(id).isPresent()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Integer calculaMedia(Integer x, Integer y) {
        try {
            return (x/y);
        }
        catch (ArithmeticException e){
            throw new DivideByZeroException("Não é possível dividir por zero");
        }
    }
}
