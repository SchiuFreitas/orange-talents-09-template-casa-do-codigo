package br.com.zupacademy.shirlei.casacodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaNomeCategoria implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaDTO categoriaDTO = (CategoriaDTO) target;
        Optional<Categoria> autorp = categoriaRepository.findByNome(categoriaDTO.getNome());
        if(autorp.isPresent()){
            errors.rejectValue("nome", null, "Já existe");
            System.out.println("Essa categoria já existe");
        }
    }
}
