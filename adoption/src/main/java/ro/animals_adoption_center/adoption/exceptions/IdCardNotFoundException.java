package ro.animals_adoption_center.adoption.exceptions;

public class IdCardNotFoundException extends RuntimeException {

    private String idCardName;

    public IdCardNotFoundException(String message){
        super(message);
    }

    public IdCardNotFoundException(String idCardName, String message, Throwable cause){
        super(message, cause);
        this.idCardName = idCardName;
    }

    public String getIdCardName(){
        return this.idCardName;
    }

}
