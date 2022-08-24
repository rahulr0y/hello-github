public class AccountNotFoundException extends Exception{

    public AccountNotFoundException() {
        super();
    }

    public void show() {
        System.out.println("Account with given details doesn't exists!");
    }
    
}
