package br.com.zupacademy.shirlei.casacodigo.paisestado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping("/estados")
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid EstadoDTO request) {
        Estado estado = request.converte(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok(estado.toString());
    }
}
