package br.com.zupacademy.shirlei.casacodigo.paisestado;

import br.com.zupacademy.shirlei.casacodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisDTO {

    @NotBlank(message = "O campo nome não pode ser vazio")
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais convertePais() {
        return new Pais(this.nome);
    }
}