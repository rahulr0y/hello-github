import java.util.Scanner;

public class BusinessLogic {

    Scanner in = new Scanner(System.in);
    AccountServiceImpl acc = new AccountServiceImpl();
    Account a = null;

    public void launchApplication() {
        int option = 0;

        while (option != 5) {
            System.out.println("\n1.Create Account\n2.SearchById\n3.SearchByName\n4.DeleteById\n5.Exit");
            System.out.print("Enter an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEnter ID: ");
                    String loginid = in.next();
                    System.out.print("Enter password: ");
                    String password = in.next();
                    System.out.print("Confirm password: ");
                    String cpassword = in.next();
                    if (!password.equals(cpassword)) {
                        try {
                            throw new PasswordMismatchException();
                        } catch (PasswordMismatchException e) {
                            e.show();
                            break;
                        }
                    }
                    System.out.print("Enter first name: ");
                    String fname = in.next();
                    System.out.print("Enter last name: ");
                    String lname = in.next();
                    System.out.print("Enter mobile number :");
                    String mobile = in.next();
                    if (mobile.length() < 10 || !mobile.matches("[0-9]+")) {
                        try {
                            throw new MobileNumberException();
                        } catch (MobileNumberException e) {
                            e.show();
                            break;
                        }
                    }
                    Account account = new Account(loginid, password, cpassword, fname, lname, mobile);
                    acc.createAccount(account);
                    System.out.println("Account created!");
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String id = in.next();
                    a = acc.searchById(id);
                    if (a == null) {
                        try {
                            throw new AccountNotFoundException();
                        } catch (AccountNotFoundException e) {
                            e.show();
                        }
                    } else {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name = in.next();
                    a = acc.searchByFirstName(name);
                    if (a == null) {
                        try {
                            throw new AccountNotFoundException();
                        } catch (AccountNotFoundException e) {
                            e.show();
                        }
                    } else {
                        System.out.println(a);
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    id = in.next();
                    if (acc.DeleteById(id)) {
                        System.out.println("Account Deleted!");
                    } else {
                        System.out.println("Account deletion was not successful!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }

    }
}
