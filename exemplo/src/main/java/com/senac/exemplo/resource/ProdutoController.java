package com.senac.exemplo.resource;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Produto;
import com.senac.exemplo.service.ClienteService;
import com.senac.exemplo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/produtos")
@RestController
public class ProdutoController extends AbstractController {

        @Autowired
        private ProdutoService service;


        @PostMapping
        public ResponseEntity create(@RequestBody Produto entity) {
            Produto save = service.salvar(entity);
            return  ResponseEntity.created(URI.create("/api/produtos/" + entity.getId())).body(save);
        }

        @GetMapping
        public ResponseEntity findAll(){
            List<Produto> clientes = service.buscaTodos();
            return ResponseEntity.ok(clientes);
        }

        @GetMapping ("{id}")
        public ResponseEntity findById(@PathVariable ("id") Long id) {
            Produto produto = service.buscaPorId(id);
            return ResponseEntity.ok(produto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") Long id) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
            Produto alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        }
    }


