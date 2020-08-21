package Engine;

import CartData.EdCart;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class PrEngine {

    EdCart edCart;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        PrEngine prEngine = new PrEngine();

        prEngine.doRun();

    }

    public void doRun(){

        Map<String, Integer> skuMap = new HashMap<String, Integer>();
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        String line = null;
        String fileName = "CARTDETAIL.txt";

        /*skuMap = getSKUMap ("A,A,A,B,B");
        edCart = new EdCart(skuMap);
        //edCart = constructMyCart(skuMap);
        int totalPrice  = edCart.getTotalPrice();
        System.out.println("totalPrice  : "+ totalPrice);*/
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));

            while ((line = br.readLine()) != null) {

                //skuMap = null;
                skuMap = getSKUMap (line);
                edCart = new EdCart(skuMap);
                //edCart = constructMyCart(skuMap);
                int totalPrice  = edCart.getTotalPrice();
                System.out.println("TotalPrice  : "+ totalPrice);
            }


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{

            try{if(br != null) br.close();}catch(Exception ex){}
        }

    }

    public HashMap<String, Integer> getSKUMap(String line){

        HashMap<String, Integer> skuMap = new HashMap<String, Integer>();
        try {
                StringTokenizer st = new StringTokenizer(line, ",");
                while(st.hasMoreTokens()){
                String tmp = st.nextToken().toLowerCase();
                if(skuMap.containsKey(tmp)){
                    skuMap.put(tmp, skuMap.get(tmp)+1);
                    } else {
                        skuMap.put(tmp, 1);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skuMap;
    }

}
