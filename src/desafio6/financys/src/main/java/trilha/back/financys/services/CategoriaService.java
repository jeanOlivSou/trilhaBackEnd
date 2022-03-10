package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.domains.Categoria;
import trilha.back.financys.repositories.CategoriaRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository catRepo;

    public Categoria create(Categoria categoria){
        return catRepo.save(categoria);
    }

    public Categoria update(Categoria categoria, Long id){

        if (catRepo.findById(id).isPresent()){
            Categoria categoriaObt = catRepo.findById(id).get();

            categoriaObt.setNome(categoria.getNome());
            categoriaObt.setDescricao(categoria.getDescricao());

            catRepo.save(categoriaObt);

            return categoriaObt;
        }

        else {
            throw new NoSuchElementException("Categoria não encontrada");
        }
    }

    public List<Categoria> read(){
        return catRepo.findAll();
    }

    public Categoria readById(Long id){
        return catRepo.findById(id).get();
    }

    public void delete(Long id){
        Categoria categoriaObt = catRepo.findById(id).get();

        catRepo.delete(categoriaObt);
    }

    public String idCategoriaByNome(String nome){
        Categoria categoriaObt = catRepo.findByNome(nome);

        return "O id da categoria " + categoriaObt.getNome() + " é : " + categoriaObt.getId();

    }

}
