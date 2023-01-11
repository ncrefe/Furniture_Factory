package models;

/**
 * The class Bookcase implements I product
 */
public class Bookcase implements IProduct {
    @Override
    public boolean isManufactured() {
        return false;
    }

    @Override
    public boolean isStored() {
        return false;
    }

    @Override
    public boolean isSold() {
        return false;
    }

    /**
     * To string
     *
     * @return String
     */
    public String toString() {
        return "Bookcase";
    }
}
