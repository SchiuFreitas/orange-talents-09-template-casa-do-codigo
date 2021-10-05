package br.com.zupacademy.shirlei.casacodigo.categoria;

import br.com.zupacademy.shirlei.casacodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já existe")
    private String nome;

    public Categoria converte(){
        return new Categoria(
                this.nome
        );
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
