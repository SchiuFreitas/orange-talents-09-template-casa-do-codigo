package br.com.zupacademy.shirlei.casacodigo.paisestado;

import br.com.zupacademy.shirlei.casacodigo.validacao.ExistsId;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class EstadoDTO {

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @ExistsId(entity = Pais.class, fieldName = "id")
    @NotNull
    private Long paisId;

    public EstadoDTO(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado converte(PaisRepository repository) {
        @NotNull Optional<Pais> pais = repository.findById(this.paisId);
        return new Estado(this.nome, pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    @Override
    public String toString() {
        return "EstadoRequest{" +
                "nome='" + nome + '\'' +
                ", paisId=" + paisId +
                '}';
    }
}
