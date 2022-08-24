import java.util.*;

public class AccountServiceImpl implements AccountService{

    private List<Account> li= new ArrayList<Account>();


    @Override
    public void createAccount(Account account) {
        li.add(account);
    }

    @Override
    public Account searchByFirstName(String name) {
        for (Account account : li) {
            if (account.getFirstName().equals(name)) {
                return account;
            } 
        }
        return null;
    }

    @Override
    public Account searchById(String id) {
        Account a = null;
        for (Account account : li) {
            if (account.getLoginId().equals(id)) {
                System.out.println("Account exists");
                a = account;
            } else {
                System.out.println("No account found with " + id );
            }
        }
        return a;
    }

    @Override
    public boolean DeleteById(String id) {
        for (Account account : li) {
            if (account.getLoginId().equals(id)) {
                li.remove(account);
                return true;                
            }
        }
        return false;   
    }
    
}
