package br.com.zupacademy.shirlei.casacodigo.livro;

import br.com.zupacademy.shirlei.casacodigo.autor.Autor;
import br.com.zupacademy.shirlei.casacodigo.autor.AutorRepository;
import br.com.zupacademy.shirlei.casacodigo.categoria.Categoria;
import br.com.zupacademy.shirlei.casacodigo.categoria.CategoriaRepository;
import br.com.zupacademy.shirlei.casacodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.util.Assert;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroDTO {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O título informado já existe")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "ISBN", message = "O ISBN informado já existe")
    private String ISBN;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;


    public LivroDTO(@NotBlank String titulo,  @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @Min(20) BigDecimal preco,
                    @NotBlank  @Min(100) Integer numeroPaginas, @NotBlank String ISBN,@NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.ISBN = ISBN;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }


    public Livro converte(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
        @NotNull Optional<Autor> autor = autorRepository.findById(this.idAutor);
        @NotNull Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);

        Assert.state(autor.isPresent(),"Você esta querendo cadastrar um livro para um autor que nao existe no banco " + this.idAutor);
        Assert.state(categoria.isPresent(),"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco " + this.idCategoria);

        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroPaginas,
                this.ISBN,
                this.dataPublicacao,
                categoria.get(),
                autor.get());
    }
}
