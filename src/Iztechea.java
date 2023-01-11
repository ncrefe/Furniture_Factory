import models.*;

import java.util.Random;
import java.util.Scanner;

/**
 * The class Iztechea
 * <p>
 * In assignment, the factory is designed as a queue and the warehouses are
 * designed as a stack. We have precautions taken not to limit the number of
 * cycles taken from the user of the program. When the existing factories and
 * warehouses are not long enough, they continue their operations by extending
 * themselves.
 * <p>
 * Muhammed Efe INCIR 270201029
 */
public class Iztechea {

    /**
     * Main
     *
     * @param args the args
     */
    public static void main(String[] args) {
        // new Random for iterations
        Random rand = new Random();
        // new Scanner for reading
        Scanner input = new Scanner(System.in);

        // Controllers
        StorageChief storageChief = new StorageChief();
        Customer customer = new Customer();
        MarketingAnalyst<IProduct> marketingAnalyst = new MarketingAnalyst<IProduct>();

        // Products
        Sofa sofa = new Sofa();
        Bed bed = new Bed();
        Chair chair = new Chair();
        Dresser dresser = new Dresser();
        Table table = new Table();
        Bookcase bookcase = new Bookcase();

        // Product type list
        IProduct[] products = {sofa, bed, chair, dresser, table, bookcase};

        System.out.println("\t\t\tWelcome to the \033[3mIztechea\033[m");
        System.out.print("How many request cycles would you like to see? ");

        // Get the number of iterations
        int numOfRequest = input.nextInt();
        System.out.println();

        for (int i = 1; i < numOfRequest + 1; i++) {
            // Create random role
            int role = rand.nextInt(3);
            System.out.print(i + ".\t");

            if (role == 0) {
                // Create random product
                int productIndex = rand.nextInt(6);
                IProduct product = products[productIndex];

                // Add product to queue
                marketingAnalyst.enqueue(product);

                System.out.print("\033[3mMarketing Analyst\033[m requesting " + product);
                System.out.println(", \033[3mSUCCESS\033[m, " + product + " manufactured");
            } else if (role == 1) {
                // Get queued product from marketingAnalyst
                IProduct product = (IProduct) marketingAnalyst.dequeue();

                if (product != null) {
                    // If product is available push it to storageChief and print SUCCESS
                    storageChief.push(product);

                    System.out.print("\033[3mStorage Chief\033[m storing " + product);
                    System.out.println(", \033[3mSUCCESS\033[m, " + product + " stored in " + product + " warehouse");
                } else {
                    // If product is not available print FAIL
                    System.out.print("\033[3mStorage Chief\033[m can not store any product, ");
                    System.out.println("\033[3mFAIL\033[m, factory line is empty");
                }
            } else {
                // Create random product
                int productIndex = rand.nextInt(6);
                IProduct productType = products[productIndex];

                // Try to get product with specific productType
                IProduct product = storageChief.pop(productType);
                if (product != null) {
                    // If product is available push it to customer and print SUCCESS
                    customer.push(product);

                    System.out.print("\033[3mCustomer\033[m buying " + product);
                    System.out.println(", \033[3mSUCCESS\033[m, Customer bought " + product);
                } else {
                    // If product is not available print FAIL
                    System.out.print("\033[3mCustomer\033[m buying " + productType);
                    System.out.println(", \033[3mFAIL\033[m, " + productType + " warehouse empty");
                }
            }
        }

        System.out.println("\n\033[0;1mREPORT:\033[m  ");
        marketingAnalyst.report();
        storageChief.report();
        customer.report();

        input.close();
    }
}
