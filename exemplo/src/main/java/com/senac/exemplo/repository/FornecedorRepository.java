package com.senac.exemplo.repository;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    public Cliente findBycnpj (String cpf);

}
