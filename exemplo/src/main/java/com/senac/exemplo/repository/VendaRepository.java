package com.senac.exemplo.repository;

import com.senac.exemplo.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository <Venda, Long> {


}
