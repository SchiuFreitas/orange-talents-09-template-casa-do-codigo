package br.com.zupacademy.shirlei.casacodigo.livro;

import br.com.zupacademy.shirlei.casacodigo.autor.AutorRepository;
import br.com.zupacademy.shirlei.casacodigo.categoria.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    @PostMapping
    public String create(@RequestBody @Valid LivroDTO request){
        Livro livro = request.converte(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return livro.toString();
    }
}
