package com.Crud.Clientes.demo.Controller;

import com.Crud.Clientes.demo.Model.Cliente;
import com.Crud.Clientes.demo.Service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public Iterable<Cliente> listarClientes(){
        return clienteService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarClientePorId(String id){
        return clienteService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.guardar(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente clienteActualizado){
        return clienteService.actualizar(clienteActualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarCliente(@PathVariable String id){
        return clienteService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
