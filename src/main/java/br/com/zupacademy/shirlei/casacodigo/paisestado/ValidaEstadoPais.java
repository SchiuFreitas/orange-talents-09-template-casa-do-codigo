package br.com.zupacademy.shirlei.casacodigo.paisestado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EstadoPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEstadoPais {

    String message() default "O estado deve ser único dentro de um país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<Estado> entity();
}