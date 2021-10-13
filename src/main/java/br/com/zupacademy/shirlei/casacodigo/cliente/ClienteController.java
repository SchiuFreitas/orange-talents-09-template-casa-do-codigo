package br.com.zupacademy.shirlei.casacodigo.cliente;


import br.com.zupacademy.shirlei.casacodigo.paisestado.EstadoRepository;
import br.com.zupacademy.shirlei.casacodigo.paisestado.PaisRepository;
import br.com.zupacademy.shirlei.casacodigo.validacao.ExistsStateInCountryValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ExistsStateInCountryValidator existsStateInCountryValidator;


    public ClienteController(ClienteRepository clienteRepository,
                             PaisRepository paisRepository,
                             EstadoRepository estadoRepository, ExistsStateInCountryValidator existsStateInCountryValidator) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.existsStateInCountryValidator = existsStateInCountryValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {

        binder.addValidators((Validator) existsStateInCountryValidator);
    }

    @PostMapping("/clientes")
    @Transactional
    public String cadastra(@RequestBody @Valid ClienteDTO request) {

        Cliente cliente = request.map(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return cliente.toString();
    }
}
