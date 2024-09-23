package ro.animals_adoption_center.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.dto.ClientDTO;
import ro.animals_adoption_center.adoption.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable int id) {
        Optional<ClientDTO> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/saveClient")
    public ResponseEntity<String> saveClient(@RequestBody ClientDTO client){

        ClientDTO clientDTO = clientService.createClient(client);
        if(clientDTO != null) {
            return ResponseEntity.ok().body("Client added successfully!");
        } else {
            return ResponseEntity.internalServerError().body("Client could not be created!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody AnimalDTO animalDetails) {
        clientService.updateClient(id, animalDetails);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated succesfully! ");
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Client deleted Successfully!");
    }


}
