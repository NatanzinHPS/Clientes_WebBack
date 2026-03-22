package com.cliente.Controller;

import com.cliente.Entity.Client;
import com.cliente.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id) {
        Optional<Client> client = clientService.get(id);
        return client.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client> existing = clientService.get(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        Client updatedClient = clientService.update(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/email")
    public ResponseEntity<List<Client>> findByEmail(@RequestParam String email) {
        List<Client> clients = clientService.findByEmail(email);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
        List<Client> clients = clientService.findByName(name);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/search/partialName")
    public ResponseEntity<List<Client>> findByParcialName(@RequestParam String partialName) {
        List<Client> clients = clientService.findByParcialName(partialName);
        return ResponseEntity.ok(clients);
    }
}
