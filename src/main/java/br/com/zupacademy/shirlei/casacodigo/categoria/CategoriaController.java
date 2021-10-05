package br.com.zupacademy.shirlei.casacodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

//    @Autowired
//    private ValidaNomeCategoria validaNomeCategoria;
//
//    @InitBinder
//    public void init(WebDataBinder binder){
//        binder.addValidators(validaNomeCategoria);
//    }

    @PostMapping
    @Transactional
    public ResponseEntity created(@RequestBody @Valid CategoriaDTO request){
        Categoria categoria = request.converte();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
