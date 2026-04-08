package com.Crud.Clientes.demo.Controller;

import com.Crud.Clientes.demo.Model.Producto;
import com.Crud.Clientes.demo.Service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public Iterable<Producto> listarProductos(){
        return productoService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarProductoPorId(String id){
        return productoService.listarPorId(id).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public void guardar(@RequestBody Producto producto){
        productoService.guardar(producto);
    }
    @PutMapping("/{id}")
    public void actualizar(@PathVariable String id, @RequestBody Producto productoActualizar){
        productoService.actualizar(id, productoActualizar).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable String id){
        return productoService.eliminar(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }
}
