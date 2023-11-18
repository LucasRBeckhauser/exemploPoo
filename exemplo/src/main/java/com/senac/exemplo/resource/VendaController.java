package com.senac.exemplo.resource;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.ItemVenda;
import com.senac.exemplo.model.Venda;
import com.senac.exemplo.service.ClienteService;
import com.senac.exemplo.service.ItemVendaService;
import com.senac.exemplo.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController extends AbstractController{

    @Autowired
    private VendaService service;

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Venda entity) {
        Venda save = service.salvar(entity);
        return  ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Venda> vendas = service.buscaTodos();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Venda produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Venda entity) {
        Venda alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);

    }

    @PostMapping("/item")
    public ResponseEntity createItem(@RequestBody ItemVenda entity) {
    ItemVenda save = itemVendaService.salvar(entity);
    return ResponseEntity.created(URI.create("/api/vendas" + entity.getId())).body(save);
    }


    @GetMapping ("{id}/item")
    public ResponseEntity findByVendaId(@PathVariable ("id") Long id) {
        List<ItemVenda> itemVendas = itemVendaService.buscaTodosPorVenda(id);
        return ResponseEntity.ok(itemVendas);

        //localhost/vendas/id/item -> para testar o getmapping do caso a cima.
    }
}
