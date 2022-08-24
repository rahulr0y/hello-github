public class PasswordMismatchException extends Exception{

    public PasswordMismatchException() {
        super();
    }

    public void show(){
        System.out.println("Passwords doesn't matches! Try again!");
    }
    
    
}
