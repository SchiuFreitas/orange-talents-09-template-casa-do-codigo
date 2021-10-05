package br.com.zupacademy.shirlei.casacodigo.autor;

import br.com.zupacademy.shirlei.casacodigo.validacao.UniqueValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Esse email já existe")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorDTO(@NotBlank String nome,
                        @NotBlank @Email String email,
                        @NotBlank @Size(max = 400) String descricao) {

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {

        return email;
    }

    public Autor toModel() {
        return new Autor(
                this.nome = nome,
                this.email = email,
                this.descricao = descricao);
    }
}

