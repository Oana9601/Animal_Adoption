package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.ClientDTO;
import ro.animals_adoption_center.adoption.model.Client;

import java.lang.ref.Cleaner;

@Component
public class ClientMapper {

    public static ClientDTO toDTO(Client client){
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public static Client toEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setEmail(clientDTO.getEmail());
        client.setName(client.getName());
        return client;
    }

}
