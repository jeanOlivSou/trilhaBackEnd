package trilha.back.financys.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoriaRequest {

        private Long id;

        @NotBlank(message = "")
        @Size(min = 3, max = 15, message = "")
        private String nome;

        @NotBlank(message = "")
        @Size(min = 15, max = 50, message = "")
        private String descricao;

        public CategoriaRequest() {
        }


        public CategoriaRequest(Long id, String nome, String descricao) {
            this.id = id;
            this.nome = nome;
            this.descricao = descricao;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return "{\n" +
                    "id= " + id + ",\n" +
                    "nome= '" + nome + "', \n" +
                    "descricao= '" + descricao + "' \n" +
                    "}";
        }
    }
