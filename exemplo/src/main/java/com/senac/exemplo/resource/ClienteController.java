package com.senac.exemplo.resource;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractController {

    @Autowired
    private ClienteService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Cliente entity) {
        Cliente save = service.salvar(entity);
        return  ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Cliente> clientes = service.buscaTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
    Cliente produto = service.buscaPorId(id);
    return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
    service.remover(id);
    return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cliente entity) {
        Cliente alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
