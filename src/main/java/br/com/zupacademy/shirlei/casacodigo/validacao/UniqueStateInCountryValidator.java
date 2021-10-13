package br.com.zupacademy.shirlei.casacodigo.validacao;

import br.com.zupacademy.shirlei.casacodigo.paisestado.Estado;
import br.com.zupacademy.shirlei.casacodigo.paisestado.EstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateInCountryValidator  implements ConstraintValidator<UniqueStateInCountry, EstadoDTO> {

    private Class<Estado> entity;

    @Autowired
    private EntityManager em;

    @Override
    public void initialize(UniqueStateInCountry annotation) {
        entity = annotation.entity();
    }

    @Override
    public boolean isValid(EstadoDTO estadoRequest, ConstraintValidatorContext context) {
        Query query = em.createQuery("select e from " + entity.getName() + " e where e.nome = :stateName and e.pais.id = :countryId");
        query.setParameter("countryId", estadoRequest.getPaisId());
        query.setParameter("stateName", estadoRequest.getNome());
        List<?> list = query.getResultList();

        Assert.isTrue(list.size() <= 1, "Existe mais de um registro no banco com nome" + estadoRequest.getNome() + "no país de id = " + estadoRequest.getPaisId());

        return list.isEmpty();
    }
}
