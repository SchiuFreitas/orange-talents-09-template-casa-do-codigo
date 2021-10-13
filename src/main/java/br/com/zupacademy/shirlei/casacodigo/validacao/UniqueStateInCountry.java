package br.com.zupacademy.shirlei.casacodigo.validacao;

import br.com.zupacademy.shirlei.casacodigo.paisestado.Estado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueStateInCountryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStateInCountry {

    String message() default "O estado deve ser único dentro de um país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<Estado> entity();
}
