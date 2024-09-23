package ro.animals_adoption_center.adoption.exceptions;

public class AnimalNotFoundException extends RuntimeException {

    private String animalName;

    public AnimalNotFoundException(String message){
         super(message);
    }

    public AnimalNotFoundException(String animalName, String message, Throwable cause){
        super(message, cause);
        this.animalName = animalName;
    }

    public String getAnimalName(){
        return this.animalName;
    }

}
