package br.com.zupacademy.shirlei.casacodigo.paisestado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping("/paises")
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid PaisDTO request) {
        Pais pais = request.convertePais();
        paisRepository.save(pais);
        return ResponseEntity.ok(pais.toString());
    }
}