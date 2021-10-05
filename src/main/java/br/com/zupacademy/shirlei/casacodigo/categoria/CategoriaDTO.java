package br.com.zupacademy.shirlei.casacodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
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
