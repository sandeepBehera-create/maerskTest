package SKU;

public class SKUC {
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

    public int getUnitPrice() {
        return unitPrice;
    }


    int numberOfItem;
    int promotePrice;
    private int unitPrice=20;

    public int promoteVal(){

        return 1;
    }
}
