package models;

public interface IProduct {

    /**
     * Is manufactured
     *
     * @return boolean
     */
    public boolean isManufactured();

    /**
     * Is stored
     *
     * @return boolean
     */
    public boolean isStored();

    /**
     * Is sold
     *
     * @return boolean
     */
    public boolean isSold();
}
