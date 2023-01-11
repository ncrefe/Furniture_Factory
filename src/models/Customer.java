package models;

/**
 * The class Customer
 */
public class Customer {

    public IProduct[] basket = new IProduct[50];
    private int numBed, numBookcase, numChair, numDresser, numSofa, numTable;
    private int topIndex = -1;

    /**
     * It is a constructor.
     */
    public Customer() {
    }

    /**
     * It is a constructor.
     *
     * @param initialCapacity the initial capacity
     */
    public Customer(int initialCapacity) {
        IProduct[] tempStack = (IProduct[]) new Object[initialCapacity];
        basket = tempStack;
    }

    /**
     * Push
     * <p>
     * Pushes to basket
     *
     * @param newEntry the new entry
     */
    public void push(IProduct newEntry) {
        ensureCapacity();
        basket[topIndex + 1] = newEntry;
        topIndex++;
    }

    /**
     * Ensure capacity
     * <p>
     * Ensures capacity and if needed expands array
     */
    private void ensureCapacity() {
        if (topIndex == basket.length - 1) {
            int newLength = 2 * basket.length;
            IProduct[] tempStack = new IProduct[newLength];
            for (int i = 0; i < basket.length; i++) {
                tempStack[i] = basket[i];
            }
            basket = tempStack;
        }
    }

    /**
     * Report
     * <p>
     * Reports current storage amounts
     */
    public void report() {
        for (int i = 0; i < topIndex + 1; i++) {
            switch (basket[i].toString()) {
                case "Bed":
                    numBed++;
                    break;
                case "Chair":
                    numChair++;
                    break;
                case "Bookcase":
                    numBookcase++;
                    break;
                case "Sofa":
                    numSofa++;
                    break;
                case "Table":
                    numTable++;
                    break;
                case "Dresser":
                    numDresser++;
                    break;
            }
        }
        System.out.println("Amount of Bed Sold: " + numBed + "\n" + "Amount of Sofa Sold: " + numSofa + "\n"
                + "Amount of Dresser Sold: " + numDresser + "\n" + "Amount of Table Sold: " + numTable + "\n"
                + "Amount of Chair Sold: " + numChair + "\n" + "Amount of Bookcase Sold: " + numBookcase);
    }
}
