package br.com.zupacademy.shirlei.casacodigo.livro;

import br.com.zupacademy.shirlei.casacodigo.autor.DetalheAutorResponse;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalheLivroResponse {

    private String titulo;
    private BigDecimal preco;
    private String dataPublicacao;
    private Integer numeroPaginas;
    private String ISBN;
    private String resumo;
    private String sumario;

    private DetalheAutorResponse autor;


    public DetalheLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        preco = livro.getPreco();
        dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        numeroPaginas = livro.getNumeroPaginas();
        ISBN = livro.getISBN();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        autor = new DetalheAutorResponse(livro.getAutor());
    }

    @Override
    public String toString() {
        return "DetalheLivroResponse{" +
                "titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", dataPublicacao='" + dataPublicacao + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", ISBN='" + ISBN + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", autor=" + autor +
                '}';
    }
}
