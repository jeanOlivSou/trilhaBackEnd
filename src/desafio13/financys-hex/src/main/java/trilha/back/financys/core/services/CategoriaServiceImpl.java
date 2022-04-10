package trilha.back.financys.core.services;

import trilha.back.financys.core.domains.Categoria;
import trilha.back.financys.core.exceptions.NotFoundException;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.core.ports.in.CategoriaServicePort;

import java.util.List;



public class CategoriaServiceImpl implements CategoriaServicePort {

    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaServiceImpl(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Categoria create(Categoria categoria) {
        return categoriaRepositoryPort.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria, Long id) {

        Categoria categoriaObt = categoriaRepositoryPort.findById(id).get();

        if(categoriaObt == null){
            throw new NotFoundException("Não foi possivel encontrar a categoria informada");
        }
        else {
            categoriaObt.setDescription(categoria.getName());
            categoriaObt.setDescription(categoria.getDescription());

            return categoriaRepositoryPort.save(categoriaObt);
        }
    }

    @Override
    public List<Categoria> read() {
        return categoriaRepositoryPort.findAll();
    }

    @Override
    public Categoria readById(Long id) {
        if (categoriaRepositoryPort.findById(id).get() == null){
            throw new NotFoundException("Não foi possível encontrar a categoria");
        }
        else {
            return categoriaRepositoryPort.findById(id).get();
        }
    }

    @Override
    public void delete(Long id) {
        Categoria categoriaObt = categoriaRepositoryPort.findById(id).get();
        categoriaRepositoryPort.delete(categoriaObt);
    }

    @Override
    public String idCategoriaByNome(String name) {
        try {
            Categoria categoriaObt = categoriaRepositoryPort.findByName(name);

            return "O id da categoria " + categoriaObt.getName() + " é : " + categoriaObt.getId();
        }

        catch (NullPointerException e){
            throw new NotFoundException("Nome de Categoria não encontrado");
        }


    }
}
