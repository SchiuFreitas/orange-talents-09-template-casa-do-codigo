package br.com.zupacademy.shirlei.casacodigo.cliente;

import br.com.zupacademy.shirlei.casacodigo.paisestado.Estado;
import br.com.zupacademy.shirlei.casacodigo.paisestado.EstadoRepository;
import br.com.zupacademy.shirlei.casacodigo.paisestado.Pais;
import br.com.zupacademy.shirlei.casacodigo.paisestado.PaisRepository;
import br.com.zupacademy.shirlei.casacodigo.validacao.CPFCNPJ;
import br.com.zupacademy.shirlei.casacodigo.validacao.ExistsId;
import br.com.zupacademy.shirlei.casacodigo.validacao.UniqueValue;
import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class ClienteDTO {

    @NotBlank
    @Email(message = "O e-mail deve ter um formato válido")
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPFCNPJ
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(entity = Pais.class, fieldName = "id")
    private Long paisId;

    @ExistsId(entity = Estado.class, fieldName = "id")
    private Long estadoId;

    public ClienteDTO(
            String email,
            String nome,
            String sobrenome,
            String documento,
            String endereco,
            String complemento,
            String telefone,
            String cep,
            String cidade,
            Long paisId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.paisId = paisId;
    }


    public Cliente map(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        @NotNull Optional<Pais> pais = paisRepository.findById(this.paisId);
        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, this.telefone, this.cep,
                pais.get());

        if (estadoId != null) {
            @NotNull Optional<Estado> estado = estadoRepository.findById(this.estadoId);
            cliente.setEstado(estado.get());
        }

        return cliente;
    }

    public Long getPaisId() {

        return paisId;
    }

    public Long getEstadoId() {

        return estadoId;
    }

    public void setEstadoId(Long estadoId) {

        this.estadoId = estadoId;
    }

}

