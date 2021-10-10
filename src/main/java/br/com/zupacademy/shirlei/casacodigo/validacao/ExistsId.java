package br.com.zupacademy.shirlei.casacodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

    String message() default "O Registro deve existir";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] Payload() default{};
    String fieldName();
    Class<?> entity();

}
