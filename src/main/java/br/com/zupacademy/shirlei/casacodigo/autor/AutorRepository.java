package br.com.zupacademy.shirlei.casacodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> { //JpaRepository fornece alguns métodos relacionados ao JPA, como liberar o contexto de persistência e excluir registros em um lote.

}
