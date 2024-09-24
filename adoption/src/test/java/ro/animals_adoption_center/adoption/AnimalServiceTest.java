//package ro.animals_adoption_center.adoption;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import ro.animals_adoption_center.adoption.dto.AnimalDTO;
//import ro.animals_adoption_center.adoption.model.Animal;
//import ro.animals_adoption_center.adoption.repository.AnimalRepository;
//import ro.animals_adoption_center.adoption.service.AnimalService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class AnimalServiceTest {
//
//    @Test
//    void getAllAnimals(){
//
//        AnimalRepository mockedAnimalRepository = mock(AnimalRepository.class);
//        AnimalService animalService = new AnimalService(mockedAnimalRepository);
//
//        Animal animal = new Animal();
//
//        animal.setBreed("huskey");
//        animal.setName("chiuaua");
//        animal.setSpecies("dog");
//        animal.setAvailable(true);
//        animal.setAge(23);
//        animal.setDescription("very quite dog!");
//
//        List<Animal> animals = new ArrayList<>();
//        animals.add(animal);
//
//        when(mockedAnimalRepository.findAll()).thenReturn(animals);
//
//        List<AnimalDTO> allAnimals = animalService.getAllAnimals();
//
//        assertEquals(allAnimals, "The list must not be null!");
//        assertEquals(1, allAnimals.size(), "The list must have one element");
//        assertEquals(animal, allAnimals.get(0), "The list must have one element of Animal");
//
//
//    }
//}
