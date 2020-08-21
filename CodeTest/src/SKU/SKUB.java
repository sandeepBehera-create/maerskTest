package SKU;

import Promotions.PromotionRule;

public class SKUB implements PromotionRule {

    public int getNumberOfSku() {
        return numberOfItem;
    }

    public void setNumberOfSku(int numberOfSku) {
        this.numberOfItem = numberOfSku;
    }

    public int getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice() {
        this.promotePrice = promoteVal();;
    }

    public int getUnitPrice() {
        return unitPrice;
    }


    int numberOfItem;
    int promotePrice;
    private int unitPrice = 30;

    public int promoteVal(){

        int  iteration = 0;
        int remander = 0;
        int totalPrice = 0;

        if (this.numberOfItem >= 2){
            iteration = this.numberOfItem / 2;
            remander = this.numberOfItem%2;

            totalPrice = iteration*45;
            totalPrice = totalPrice+ remander*this.unitPrice;

        }else{
            totalPrice = this.numberOfItem*this.unitPrice;
        }

        return totalPrice;
    }
}
