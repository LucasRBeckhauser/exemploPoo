package com.senac.exemplo.service;

import com.senac.exemplo.enterprise.ValidationException;
import com.senac.exemplo.model.ItemVenda;
import com.senac.exemplo.model.Produto;
import com.senac.exemplo.repository.ItemVendaRepository;
import com.senac.exemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    public ItemVenda salvar(ItemVenda entity)  {

        return  repository.save(entity);}

    public List<ItemVenda> buscaTodosPorVenda(Long id) {
        return repository.findByVendaId(id);
    }

    public List<ItemVenda> buscaTodos() { return  repository.findAll();}

    public ItemVenda buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ItemVenda alterar(Long id, ItemVenda alterado) {
        Optional<ItemVenda> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            ItemVenda itemVenda = encontrado.get();
            itemVenda.setVenda(alterado.getVenda());
            itemVenda.setDesconto(alterado.getDesconto());
            itemVenda.setProduto(alterado.getProduto());
            itemVenda.setQuantidade(alterado.getQuantidade());
            return repository.save(itemVenda);
        }
        return null;
    }

    public void remover(Long id) { repository.deleteById(id);}
}
