package br.com.zupacademy.shirlei.casacodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity //Informa ao spring que essa é uma classe de entidade
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera automaticamente um id do tipo id em ordem de inserção
    private Long id;

    @NotBlank //uma string restrita é válida desde que não seja nula e o comprimento aparado seja maior que zero
    private String nome;

    @NotBlank
    @Email //Valida o campo email. Não permite cadastrar um email fora do padrão
    private String email;

    @NotBlank @Size(max = 400) //@Size passa o valor maximo ou mínimo da string
    private String descricao;

    @Deprecated
    public Autor() {
    }

    private LocalDateTime horaDaCriacao = LocalDateTime.now(); // método now () de uma classe LocalDateTime usado para obter a data e hora atual do relógio do sistema no fuso horário padrão. Este método retornará LocalDateTime com base no relógio do sistema com fuso horário padrão para obter a data e hora atual.

    public Autor(String nome, String email, String descricao){
        this.nome=nome;
        this.email=email;
        this.descricao=descricao;
    }

    @Override //garante que estou sobrescrevendo um método e não criando um novo.
    public String toString(){
        return "Autor: " +
                "id = " + id +
                ", nome = '" + nome +
                ", email = '" + email +
                ", descricao = '" + descricao +
                ", horaDaCriacao = " + horaDaCriacao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
