package ro.animals_adoption_center.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.dto.ClientDTO;
import ro.animals_adoption_center.adoption.exceptions.AnimalNotFoundException;
import ro.animals_adoption_center.adoption.exceptions.ClientNotFoundException;
import ro.animals_adoption_center.adoption.mapper.AnimalMapper;
import ro.animals_adoption_center.adoption.mapper.ClientMapper;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.Client;
import ro.animals_adoption_center.adoption.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> ClientMapper.toDTO(client)).toList();
    }

    public Optional<ClientDTO> getClientById(int id) {

        Client client = clientRepository.findById(Long.valueOf(id)).orElseThrow(() ->
                new ClientNotFoundException("Animal not found!"));

        return Optional.ofNullable(ClientMapper.toDTO(client));
    }

    public ClientDTO createClient(ClientDTO clientDTO){
        List<Animal> animals = new ArrayList<>();

        for(AnimalDTO animal : clientDTO.getAnimalsDTOList()){
            animals.add(AnimalMapper.toEntity(animal));
        }

        Client client = ClientMapper.toEntity(clientDTO);
        client.setAnimalList(animals);
        clientRepository.save(client);

        return clientDTO;
    }

    public void updateClient(Long id, AnimalDTO animalDetails) {

        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found!"));

        List<Animal> animals = client.getAnimalList();
        animals.add(AnimalMapper.toEntity(animalDetails));
        client.setAnimalList(animals);

        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
