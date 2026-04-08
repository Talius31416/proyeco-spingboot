package com.Crud.Clientes.demo.Service;

import com.Crud.Clientes.demo.Model.Cliente;
import com.Crud.Clientes.demo.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> listarPorId(String id){
        return clienteRepository.findById(id);
    }
    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> actualizar(Cliente clienteActualizado){
        return clienteRepository.findById(clienteActualizado.getID()).
                map(cliente -> {
                    cliente.setNombre(cliente.getNombre());
                    cliente.setFechaNacimiento(cliente.getFechaNacimiento());
                    cliente.setDireccion(cliente.getDireccion());
                    return clienteRepository.save(cliente);
                });
    }

    public boolean eliminar(String id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
