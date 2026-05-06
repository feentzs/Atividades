package br.com.senai.crud.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    ArrayList<Cliente> findAllByAtivoTrue();
    Optional<Cliente> findByIdAndAtivoTrue(Long id);
}
