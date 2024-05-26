package com.gabriel.prestadorservicosapi.model.repository;

import com.gabriel.prestadorservicosapi.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
