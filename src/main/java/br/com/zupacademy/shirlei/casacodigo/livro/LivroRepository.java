package br.com.zupacademy.shirlei.casacodigo.livro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
    @Override
    Optional<Livro> findById(Long id);
}
