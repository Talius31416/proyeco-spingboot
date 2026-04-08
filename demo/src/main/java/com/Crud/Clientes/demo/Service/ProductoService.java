package com.Crud.Clientes.demo.Service;

import com.Crud.Clientes.demo.Model.Producto;
import com.Crud.Clientes.demo.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public void guardar(Producto producto){
        productoRepository.save(producto);
    }
    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }
    public Optional<Producto> listarPorId(String id){
        return productoRepository.findById(id);
    }
    public Optional<Producto> actualizar(String id,Producto productoActualizar){
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizar.getNombre());
            producto.setDescripcion(productoActualizar.getDescripcion());
            producto.setPrecio(productoActualizar.getPrecio());
            return productoRepository.save(producto);
        });
    }
    public boolean eliminar(String id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
