package trilha.back.financys.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import trilha.back.financys.FinancysApplication;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;
import trilha.back.financys.core.services.CategoriaServiceImpl;
import trilha.back.financys.core.services.LancamentoServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = FinancysApplication.class)
public class BeanConfig {
    @Bean
    CategoriaServiceImpl categoriaServiceImpl(CategoriaRepositoryPort repository){
        return new CategoriaServiceImpl(repository);
    }

    @Bean
    LancamentoServiceImpl lancamentoServiceImpl(LancamentoRepositoryPort lancamentoRepository, CategoriaRepositoryPort categoriaRepository){
        return new LancamentoServiceImpl(lancamentoRepository, categoriaRepository);
    }
}
