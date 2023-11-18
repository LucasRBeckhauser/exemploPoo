package com.senac.exemplo.resource;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Fornecedor;
import com.senac.exemplo.service.ClienteService;
import com.senac.exemplo.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController  extends AbstractController{

        @Autowired
        private FornecedorService service;


        @PostMapping
        public ResponseEntity create(@RequestBody Fornecedor entity) {
            Fornecedor save = service.salvar(entity);
            return  ResponseEntity.created(URI.create("/api/fornecedor/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll(){
            List<Fornecedor> fornecedores = service.buscaTodos();
            return ResponseEntity.ok(fornecedores);
        }

        @GetMapping ("{id}")
        public ResponseEntity findById(@PathVariable ("id") Long id) {
            Fornecedor produto = service.buscaPorId(id);
            return ResponseEntity.ok(produto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Fornecedor entity) {
            Fornecedor alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }

