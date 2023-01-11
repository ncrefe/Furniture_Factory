package models;

/**
 * The class Storage chief
 */
public class StorageChief {
    // The Ware Houses separately
    int indexBed = -1, indexChair = -1, indexBookcase = -1, indexDresser = -1, indexSofa = -1, indexTable = -1;
    IProduct[] beds = new IProduct[50];
    IProduct[] chairs = new IProduct[50];
    IProduct[] bookcases = new IProduct[50];
    IProduct[] dressers = new IProduct[50];
    IProduct[] sofas = new IProduct[50];
    IProduct[] tables = new IProduct[50];

    /**
     * Pop
     * <p>
     * Pops from according array of product
     *
     * @param product the product
     * @return IProduct
     */
    public IProduct pop(IProduct product) {
        switch (product.toString()) {
            case "Bed":
                if (indexBed != -1) {
                    beds[indexBed] = null;
                    indexBed--;
                    return product;
                }
                break;
            case "Chair":
                if (indexChair != -1) {
                    chairs[indexChair] = null;
                    indexChair--;
                    return product;
                }
                break;
            case "Bookcase":
                if (indexBookcase != -1) {
                    bookcases[indexBookcase] = null;
                    indexBookcase--;
                    return product;
                }
                break;
            case "Sofa":
                if (indexSofa != -1) {
                    sofas[indexSofa] = null;
                    indexSofa--;
                    return product;
                }
                break;
            case "Table":
                if (indexTable != -1) {
                    tables[indexTable] = null;
                    indexTable--;
                    return product;
                }
                break;
            case "Dresser":
                if (indexDresser != -1) {
                    dressers[indexDresser] = null;
                    indexDresser--;
                    return product;
                }
                break;
        }
        return null;
    }

    /**
     * Push
     * <p>
     * Pushes to according array of product
     *
     * @param product the product
     */
    public void push(IProduct product) {
        switch (product.toString()) {
            case "Bed":
                indexBed++;
                beds = ensureCapacity(beds, indexBed);
                beds[indexBed] = product;
                break;
            case "Chair":
                indexChair++;
                chairs = ensureCapacity(chairs, indexChair);
                chairs[indexChair] = product;
                break;
            case "Bookcase":
                indexBookcase++;
                bookcases = ensureCapacity(bookcases, indexBookcase);
                bookcases[indexBookcase] = product;
                break;
            case "Sofa":
                indexSofa++;
                sofas = ensureCapacity(sofas, indexSofa);
                sofas[indexSofa] = product;
                break;
            case "Table":
                indexTable++;
                tables = ensureCapacity(tables, indexTable);
                tables[indexTable] = product;
                break;
            case "Dresser":
                indexDresser++;
                dressers = ensureCapacity(dressers, indexDresser);
                dressers[indexDresser] = product;
                break;
        }
    }

    /**
     * Ensure capacity
     * <p>
     * Ensures capacity and if needed expands array
     *
     * @param controlArray the control array
     * @param snapIndex    the snap index
     * @return IProduct[]
     */
    public IProduct[] ensureCapacity(IProduct[] controlArray, int snapIndex) {
        if (snapIndex + 2 >= controlArray.length) {
            int newLength = 2 * controlArray.length;
            IProduct[] tempQueue = new IProduct[newLength];
            for (int i = 0; i < controlArray.length; i++) {
                tempQueue[i] = controlArray[i];
            }
            return tempQueue;
        }
        return controlArray;
    }

    /**
     * Report
     * <p>
     * Reports current storage amounts
     */
    public void report() {
        System.out.println("Amount of Bed in Bed Warehouse: " + (indexBed + 1) + "\n" + "Amount of Sofa in Sofa Warehouse: "
                + (indexSofa + 1) + "\n" + "Amount of Dresser in Dresser Warehouse: " + (indexDresser + 1) + "\n"
                + "Amount of Table in Table Warehouse: " + (indexTable + 1) + "\n" + "Amount of Chair in Chair Warehouse: "
                + (indexChair + 1) + "\n" + "Amount of Bookcase in Bookcase Warehouse: " + (indexBookcase + 1) + "\n");
    }
}
