package br.com.zupacademy.shirlei.casacodigo.paisestado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoPaisValidator implements ConstraintValidator<ValidaEstadoPais, EstadoDTO> {

    private Class<Estado> entity;

    @Autowired
    private EntityManager em;

    @Override
    public void initialize(ValidaEstadoPais annotation) {
        entity = annotation.entity();
    }

    @Override
    public boolean isValid(EstadoDTO request, ConstraintValidatorContext context) {
        Query query = em.createQuery("select e from " + entity.getName() + " e where e.nome = :stateName and e.pais.id = :countryId");
        query.setParameter("countryId", request.getPaisId());
        query.setParameter("stateName", request.getNome());
        List<?> list = query.getResultList();

        Assert.isTrue(list.size() <= 1, "Existe mais de um registro no banco com nome" + request.getNome() + "no país de id = " + request.getPaisId());

        return list.isEmpty();
    }
}
