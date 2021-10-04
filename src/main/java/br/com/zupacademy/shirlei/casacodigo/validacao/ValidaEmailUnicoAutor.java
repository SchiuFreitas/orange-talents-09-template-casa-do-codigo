package br.com.zupacademy.shirlei.casacodigo.validacao;

import br.com.zupacademy.shirlei.casacodigo.autor.Autor;
import br.com.zupacademy.shirlei.casacodigo.autor.AutorRepository;
import br.com.zupacademy.shirlei.casacodigo.autor.NovoAutorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaEmailUnicoAutor implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoAutorDTO request = (NovoAutorDTO) o;


        System.out.println(autorRepository.findByEmail(request.getEmail()));
        Optional<Autor> autorp = autorRepository.findByEmail(request.getEmail());
        if(autorp.isPresent()){
            errors.rejectValue("email", null, "Este email já existe na base de dados");

        }
    }
}
