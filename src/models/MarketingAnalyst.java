package models;

/**
 * The class Marketing analyst< t>
 */
public class MarketingAnalyst<T> {
    public T[] factoryLine;
    private int numBed, numBookcase, numChair, numDresser, numSofa, numTable;
    private int topIndex;
    private static final int defaultCapacity = 50;

    /**
     * Marketing analyst
     *
     * @return public
     */
    public MarketingAnalyst() {
        this(defaultCapacity);
    }

    /**
     * Marketing analyst
     *
     * @param initialCapacity the initial capacity
     * @return public
     */
    public MarketingAnalyst(int initialCapacity) {
        T[] tempStack = (T[]) new Object[initialCapacity];
        factoryLine = tempStack;
        topIndex = -1;
    }

    /**
     * Enqueue
     * <p>
     * Queues new entry
     *
     * @param newEntry the new entry
     */
    public void enqueue(T newEntry) {
        ensureCapacity();
        factoryLine[topIndex + 1] = newEntry;
        topIndex++;
    }

    /**
     * Ensure capacity
     * <p>
     * Ensures capacity and if needed expands array
     */
    private void ensureCapacity() {
        if (topIndex == factoryLine.length - 1) {
            int newLength = 2 * factoryLine.length;
            T[] tempQueue = (T[]) new Object[newLength];
            for (int i = 0; i < factoryLine.length; i++) {
                tempQueue[i] = factoryLine[i];
            }
            factoryLine = tempQueue;
        }
    }

    /**
     * Dequeue
     * <p>
     * Dequeues entry and returns
     *
     * @return T
     */
    public T dequeue() {
        if (topIndex != -1) {
            T popEntry = factoryLine[0];
            factoryLine[0] = null;
            for (int i = 0; i < topIndex; i++) {
                factoryLine[i] = factoryLine[i + 1];
            }
            topIndex--;
            return popEntry;
        }
        return null;
    }

    /**
     * Report
     * <p>
     * Reports current storage amounts
     */
    public void report() {
        for (int i = 0; i < topIndex + 1; i++) {
            switch (factoryLine[i].toString()) {
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
        System.out.println("Amount of Bed in Factory Line: " + numBed + "\n" + "Amount of Sofa in Factory Line: " + numSofa
                + "\n" + "Amount of Dresser in Factory Line: " + numDresser + "\n" + "Amount of Table in Factory Line: "
                + numTable + "\n" + "Amount of Chair in Factory Line: " + numChair + "\n"
                + "Amount of Bookcase in Factory Line: " + numBookcase + "\n");
    }
}
