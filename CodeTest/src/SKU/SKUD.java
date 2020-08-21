package SKU;

public class SKUD {
    public int getNumberOfSku() {
        return numberOfItem;
    }

    public void setNumberOfSku(int numberOfSku) {
        this.numberOfItem = numberOfSku;
    }

    public int getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(int promotePrice) {
        this.promotePrice = promotePrice;
    }

    int numberOfItem;
    int promotePrice;

    public int getUnitPrice() {
        return unitPrice;
    }

    private int unitPrice=15;

    public int promoteVal(){

        return 1;
    }
}
