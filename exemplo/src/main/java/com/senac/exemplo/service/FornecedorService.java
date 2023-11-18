package com.senac.exemplo.service;

import com.senac.exemplo.enterprise.ValidationException;
import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Fornecedor;
import com.senac.exemplo.repository.ClienteRepository;
import com.senac.exemplo.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

        @Autowired
        private FornecedorRepository repository;

        public Fornecedor salvar(Fornecedor entity) {

            if (repository.findBycnpj(entity.getCnpj()) != null) {

                throw new ValidationException("Já existe um cliente com esse CNPJ cadastrado");
            }

            if (entity.getNome() == entity.getRazaoSocial()){
                throw new ValidationException("O nome não pode ser igual a razão social");
            }

                return  repository.save(entity);}

        public List<Fornecedor> buscaTodos() { return  repository.findAll();}

        public Fornecedor buscaPorId(Long id) {
            return repository.findById(id).orElse(null);
        }

        public Fornecedor alterar(Long id, Fornecedor alterado) {
            Optional<Fornecedor> encontrado = repository.findById(id);
            if(encontrado.isPresent()) {
                //alterar para o set da classe fornecedor, que são cnpj e razão social
                Fornecedor fornecedor = encontrado.get();
                fornecedor.setCnpj(alterado.getCnpj());
                fornecedor.setRazaoSocial(alterado.getRazaoSocial());
                fornecedor.setNome(alterado.getNome());
                fornecedor.setEmail(alterado.getEmail());
                fornecedor.setTelefone(alterado.getTelefone());
                return repository.save(fornecedor);
            }
            return null;
        }

        public void remover(Long id) { repository.deleteById(id);}


    }


