
import java.util.Scanner;

public class ATMMachine {
    private double balance;
    private int pin;

    // Constructor to initialize balance and pin
    public ATMMachine(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Method to check if the entered PIN is valid
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to check account balance
    public double checkBalance() {
        return this.balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful. Current balance: $" + this.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + this.balance);
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMMachine atm = new ATMMachine(1000.00, 1234); // Initial balance and PIN

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (atm.validatePin(enteredPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current balance: $" + atm.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}
