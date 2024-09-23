package ro.animals_adoption_center.adoption.exceptions;

public class FoodNotFoundException extends RuntimeException{

    private String foodName;


    public FoodNotFoundException(String message){
        super(message);
    }

    public FoodNotFoundException(String foodName, String message, Throwable cause){
        super(message, cause);
        this.foodName = foodName;
    }

    public String getFoodName(){
        return this.foodName;
    }
}
