package com.senac.exemplo.repository;

import com.senac.exemplo.model.Fornecedor;
import com.senac.exemplo.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    public List<ItemVenda> findByVendaId(Long id);

}
