package SKU;

import Promotions.PromotionRule;

public class SKUA implements PromotionRule {

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
        this.promotePrice = promoteVal();
    }

    public int getUnitPrice() {
        return unitPrice;
    }


    int numberOfItem;
    int promotePrice;
    private int unitPrice = 50;

    public int promoteVal(){
        int  iteration = 0;
        int remander = 0;
        int totalPrice = 0;

        if (this.numberOfItem >= 3){
            iteration = this.numberOfItem / 3;
            remander = this.numberOfItem%3;

            totalPrice = iteration*130;
            totalPrice = totalPrice+ remander*this.unitPrice;

        }else{
            totalPrice = this.numberOfItem*this.unitPrice;
        }

        return totalPrice;
    }

}
