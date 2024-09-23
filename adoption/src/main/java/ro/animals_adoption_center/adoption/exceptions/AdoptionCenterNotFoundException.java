package ro.animals_adoption_center.adoption.exceptions;

public class AdoptionCenterNotFoundException extends RuntimeException{

    private String adoptionCenterName;

    public AdoptionCenterNotFoundException(String message){
        super(message);
    }

    public AdoptionCenterNotFoundException(String adoptionCenterName, String message, Throwable cause){
        super(message, cause);
        this.adoptionCenterName = adoptionCenterName;
    }

    public String getAdoptionCenterName(){
        return this.adoptionCenterName;
    }
}
