package br.com.zupacademy.shirlei.casacodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livroDetalhe")
public class DetalheLivroController {

    @Autowired
    private final LivroRepository livroRepository;

    public DetalheLivroController(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    public List<LivroResponse> listaTodosLivrosCadastrados() {
        List<Livro> livros = (List<Livro>) livroRepository.findAll();
        return LivroResponse.converte(livros);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<?> detalhaLivro(@PathVariable("id") Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            return ResponseEntity.ok(new DetalheLivroResponse(livroOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
