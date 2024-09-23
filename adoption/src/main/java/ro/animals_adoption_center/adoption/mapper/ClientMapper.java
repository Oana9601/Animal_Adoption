package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.dto.ClientDTO;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.Client;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public static ClientDTO toDTO(Client client){
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());

        List<AnimalDTO> animals = new ArrayList<>();
        for(Animal animal : client.getAnimalList()){
            animals.add(AnimalMapper.toDTO(animal));
        }
        dto.setAnimalsDTOList(animals);
        return dto;
    }

    public static Client toEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setEmail(clientDTO.getEmail());
        client.setName(client.getName());

        List<Animal> animals = new ArrayList<>();
        for(AnimalDTO animal : clientDTO.getAnimalsDTOList()){
            animals.add(AnimalMapper.toEntity(animal));
        }
        client.setAnimalList(animals);
        return client;
    }

}
