package com.senac.exemplo.service;

import com.senac.exemplo.enterprise.ValidationException;
import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Produto;
import com.senac.exemplo.repository.ClienteRepository;
import com.senac.exemplo.repository.FornecedorRepository;
import com.senac.exemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity)  {

        if(entity.getPrecoCompra() > entity.getPrecoVenda()) {
            throw new ValidationException("O preço de venda deve ser maior que o preço de compra ");
        }

        if (repository.findByDescricao(entity.getDescricao()) != null) {

            throw new ValidationException("Já existe um produto cadastrado com essa descricao");
        }


        return  repository.save(entity);}



    public List<Produto> buscaTodos() { return  repository.findAll();}

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto alterado) {
        Optional<Produto> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Produto produto = encontrado.get();
            produto.setDescricao(alterado.getDescricao());
            produto.setCor(alterado.getCor());
            produto.setNome(alterado.getNome());
            produto.setMarca(alterado.getMarca());
            produto.setPrecoCompra(alterado.getPrecoCompra());
            produto.setPrecoVenda(alterado.getPrecoVenda());
            produto.setModelo(alterado.getModelo());
            return repository.save(produto);
        }
        return null;
    }

    public void remover(Long id) { repository.deleteById(id);}

}
