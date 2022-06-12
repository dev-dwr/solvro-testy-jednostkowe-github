package ex5;

public class Exceptions {
    protected final static int DEFAULT_NUMBER = 6;

    public String justAFunction(int number){
        if(number > DEFAULT_NUMBER){
            throw new IllegalArgumentException("given number is bigger than default_number");
        }
        return String.valueOf(number);
    }

}
