package ro.animals_adoption_center.adoption.exceptions;

public class ClientNotFoundException extends RuntimeException {

    private String clientName;

    public ClientNotFoundException(String message){
        super(message);
    }

    public ClientNotFoundException(String clientName, String message, Throwable cause){
        super(message, cause);
        this.clientName = clientName;
    }

    public String getClientName(){
        return this.clientName;
    }
}
