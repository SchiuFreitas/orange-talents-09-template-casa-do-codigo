package br.com.zupacademy.shirlei.casacodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livroDetalhe")
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value= "/{id}")
    public ResponseEntity<?> detalhaLivro(@PathVariable("id") Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            DetalheLivroResponse detalheSiteLivroResponse = new DetalheLivroResponse(livroOptional.get());
            return ResponseEntity.ok(detalheSiteLivroResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
