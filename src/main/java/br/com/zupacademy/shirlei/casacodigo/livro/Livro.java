package br.com.zupacademy.shirlei.casacodigo.livro;

import br.com.zupacademy.shirlei.casacodigo.autor.Autor;
import br.com.zupacademy.shirlei.casacodigo.categoria.Categoria;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500, message = "Máximo de 500 caracteres")
    private String resumo;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String sumario;

    @NotNull
    @Min(value = 20, message = "O preço mínimo do livro é de 20")
    private BigDecimal preco;

    @NotNull
    @Min(value = 100, message = "O livro deve ter no mínimo 100 páginas")
    private Integer numeroPaginas;

    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    private String isbn;

    @NotNull
    @Future(message = "A data de publicação deve estar no futuro")
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
                 @NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
