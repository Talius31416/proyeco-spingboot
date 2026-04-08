package com.Crud.Clientes.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Crud.Clientes.demo.Model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
}
