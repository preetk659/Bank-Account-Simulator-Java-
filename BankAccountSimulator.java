import java.util.Scanner;

class BankAccount {
    private String owner;
    private int accountNumber;
    private double balance;

    public BankAccount(String owner, int accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showDetails() {
        System.out.println("\n Account Details:");
        System.out.println(" Owner: " + owner);
        System.out.println(" Account Number: " + accountNumber);
        System.out.println(" Balance: ₹" + balance);
    }
}

public class BankAccountSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Welcome to Bank Simulator");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your account number: ");
        int accNum = sc.nextInt();

        BankAccount account = new BankAccount(name, accNum);

        int choice;
        do {
            System.out.println("\n MENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.showDetails();
                    break;
                case 5:
                    System.out.println(" Thank you for using the simulator.");
                    break;
                default:
                    System.out.println(" Invalid option. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
