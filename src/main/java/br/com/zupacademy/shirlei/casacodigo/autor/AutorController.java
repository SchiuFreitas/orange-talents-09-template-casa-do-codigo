package br.com.zupacademy.shirlei.casacodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
//Controller
//Seu principal objetivo é direcionar o fluxo da aplicação mapeando e direcionado as ações
// recebidas (request) pela camada da apresentação para os respectivos serviços da aplicação.

@RestController // define que essa classe será um controlador do serviço rest.
@RequestMapping("/autores")//definimos aqui a rota de acesso aos métodos que irão manipular os verbos http.
public class AutorController {

    @Autowired// acima do repository, injetamos todos os métodos necessários para fazer a persistência de dados que estão na JpaRepository.
    private final AutorRepository autorRepository;// instancio a interface e em seguida completo a injeção.

    public AutorController(AutorRepository autorRepository){

        this.autorRepository = autorRepository;
    }

    //@Transactional essa anotação não é necessária quando usamos o .save do repository. Seria necessária caso utilizasse outro método que não buscasse no repository
    @PostMapping //informa ao Rest o método responsável por atender ao verbo Http do tipo Post
    public String created(@RequestBody @Valid NovoAutorDTO request){//@RequestBody interpreta o que está sendo passado no body em json e retorna um objeto java por padrão.
        //E a @Valid que garante que as informações passadas para o objeto estão de acordo com as regras passadas na entidade.
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return autor.toString();
    }
}
