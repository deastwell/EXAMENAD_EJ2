package com.example.examenad_ej2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/post")
    public ResponseEntity<Cliente> nuevo(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteRepository.save(cliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/activosVentaMayor/{total}")
    public List<Cliente> getClientesActivosConVentasMayor(@PathVariable Double total){
        return clienteRepository.findActivosByVentaMayor(total);
    }


}
