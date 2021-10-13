package br.com.zupacademy.shirlei.casacodigo.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    private String entityAttribute;
    private Class<?> entity;

    @Autowired
    private EntityManager em;

    @Override
    public void initialize(ExistsId annotation) {
        //ConstraintValidator.super.initialize(annotation);
        entityAttribute = annotation.fieldName();
        entity = annotation.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }
        Query query = em.createQuery("select 1 from " + entity.getName() + "WHERE" + entityAttribute + "=:fieldName");
        query.setParameter("fieldName", value);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <= 1, "Existe mais de um registro com " + entityAttribute + "=" + value);

        return !list.isEmpty();

    }
}
