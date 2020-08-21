package CartData;

import Promotions.PromotionRule;
import Promotions.PromotionRuleCombi;
import SKU.SKUA;
import SKU.SKUB;
import SKU.SKUC;
import SKU.SKUD;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EdCart implements PromotionRuleCombi {



    public SKUA getSkuA() {
        return skuA;
    }

    public void setSkuA(SKUA skuA) {
        this.skuA = skuA;
    }

    public SKUB getSkuB() {
        return skuB;
    }

    public void setSkuB(SKUB skuB) {
        this.skuB = skuB;
    }

    public SKUC getSkuC() {
        return skuC;
    }

    public void setSkuC(SKUC skuC) {
        this.skuC = skuC;
    }

    public SKUD getSkuD() {
        return skuD;
    }

    public void setSkuD(SKUD skuD) {
        this.skuD = skuD;
    }

    SKUA skuA;
    SKUB skuB;
    SKUC skuC;
    SKUD skuD;


    public EdCart(Map<String, Integer>skuMap){

        Iterator iterator = skuMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            int numberOfelement = ((int)mapElement.getValue());
            String skuElement = mapElement.getKey().toString();


            if (skuElement.equalsIgnoreCase("A")){
                skuA = new SKUA();
                skuA.setNumberOfSku(numberOfelement);
                skuA.setPromotePrice();
            }
            if (skuElement.equalsIgnoreCase("B")){
                skuB = new SKUB();
                skuB.setNumberOfSku(numberOfelement);
                skuB.setPromotePrice();
            }
            if (skuElement.equalsIgnoreCase("C")){
                skuC = new SKUC();
                skuC.setNumberOfSku(numberOfelement);
            }
            if (skuElement.equalsIgnoreCase("D")){
                skuD = new SKUD();
                skuD.setNumberOfSku(numberOfelement);
            }

        }
    }



    public int promoteVal(){
        int totalPrice = 0;
        if(skuC.getNumberOfSku() > skuD.getNumberOfSku()){
            totalPrice = skuD.getNumberOfSku()*30 + skuC.getUnitPrice()*(skuC.getNumberOfSku()-skuD.getNumberOfSku());
        }else if(skuD.getNumberOfSku() > skuC.getNumberOfSku()){
            totalPrice = skuC.getNumberOfSku()*30 + skuD.getUnitPrice()*(skuD.getNumberOfSku()-skuC.getNumberOfSku());

        }else if(skuC.getNumberOfSku() == skuD.getNumberOfSku()){
            totalPrice = skuC.getNumberOfSku()*30;
        }


        return totalPrice;
    }

    public int getTotalPrice(){

        int totalPrice = 0;

        if (skuC!=null && skuD!=null){
            if (skuC.getNumberOfSku()>0 && skuD.getNumberOfSku()>0){
                totalPrice = promoteVal();
            }else{
                totalPrice = skuC.getNumberOfSku()* skuC.getUnitPrice();
                totalPrice = totalPrice + skuD.getNumberOfSku()* skuD.getUnitPrice();
            }
        }else if(skuC!=null && skuD==null){
            totalPrice = skuC.getNumberOfSku()* skuC.getUnitPrice();
        }else if(skuD!=null && skuC==null){
            totalPrice = skuD.getNumberOfSku()* skuD.getUnitPrice();
        }
        if (skuA!=null){
            totalPrice += skuA.getPromotePrice();
        }
        if (skuB!=null){
            totalPrice += skuB.getPromotePrice();
        }




        return totalPrice;
    }


}
