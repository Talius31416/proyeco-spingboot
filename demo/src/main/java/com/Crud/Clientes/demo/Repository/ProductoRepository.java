package com.Crud.Clientes.demo.Repository;

import com.Crud.Clientes.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
