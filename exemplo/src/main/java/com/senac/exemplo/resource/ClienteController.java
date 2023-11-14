package com.senac.exemplo.resource;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Cliente entity) {
        Cliente save = service.salvar(entity);
        return  ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }
}
