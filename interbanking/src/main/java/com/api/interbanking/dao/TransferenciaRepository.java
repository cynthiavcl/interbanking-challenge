package com.api.interbanking.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.interbanking.model.Transferencia;


@Repository
public interface TransferenciaRepository  extends JpaRepository<Transferencia, Long>{


}
