public class MobileNumberException extends Exception{

    public MobileNumberException() {
        super();
    }

    public void show() {
        System.out.println("Enter valid mobile number!");
        System.out.println("Mobile number should be 10 digits and contain only numbers!");
    }

    
    
}
