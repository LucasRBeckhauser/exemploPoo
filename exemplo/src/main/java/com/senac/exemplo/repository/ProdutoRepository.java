package com.senac.exemplo.repository;

import com.senac.exemplo.model.Cliente;
import com.senac.exemplo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    public Produto findByDescricao (String cpf);
}
