
public interface AccountService {

    public void createAccount(Account account);
    public Account searchByFirstName(String name);
    public Account searchById(String id);
    public boolean DeleteById(String id);
    
}