package developers.icecreamgameui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Events {
    private int customerNr;
    private double customerMax;
    public String DisplayAndSetEvents(Balbiino balbiino){
        String message = randomEvent(balbiino);
        return message;
    }

    public List<Customer> GenerateCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        Random random = new Random();
        String preferred;
        for (int i = 0; i < customerNr; i++) {
            int preference = random.nextInt(3);
            double pops_multiplier = 1;
            if (preference == 0){
                preferred = "Choco";
            } else if (preference == 1) {
                preferred = "Vanilla";
            } else {
                pops_multiplier = 0.75;
                preferred = "Popsicle";
            }
            customers.add(new Customer(preferred,random.nextInt(1,5),random.nextDouble(pops_multiplier*customerMax*0.8,pops_multiplier*customerMax*2)));
        }

        return customers;
    }

    private String randomEvent(Balbiino balbiino){
        Random random = new Random();
        int randint = random.nextInt(1,8);
        String info = "";
        balbiino.setChoco_Sell_price(0.5); // reset ice cream prices from balbiino in case of price change events
        balbiino.setPopsicle_Sell_price(0.3);
        balbiino.setVanilla_Sell_price(0.5);
        customerMax = 0.9;
        switch (randint) {
            case 1 -> {
                customerNr = 30;
                info = "Ilmateade:Soe ja paikesepaisteline ilm. Parim paev randa minemiseks";
            }
            case 2 -> {
                customerNr = 13;
                info = "Ilmateade:Soe ja paikesepaisteline ilm, aga suur voimalus ,et hakkab sadama";
            }
            case 3 -> {
                balbiino.setChoco_Sell_price(0.35);
                balbiino.setPopsicle_Sell_price(0.15);
                balbiino.setVanilla_Sell_price(0.35);
                customerNr = 0;
                info = "Ilmateade:Terve paev sajab vihma.\n" +
                        "Lisainfo:Firma, kust sa jaatist ostad teeb uhepaevase allahindluse";
            }
            case 4 -> {
                balbiino.setChoco_Sell_price(0.75);
                balbiino.setPopsicle_Sell_price(0.5);
                balbiino.setVanilla_Sell_price(0.75);
                customerNr = 30;
                info = "Ilmateade:Soe ja paikesepaisteline ilm. Parim paev randa minemiseks\n" +
                        "Lisainfo:Firma, kust sa jaatist ostad tostis uheks paevaks hindu";
            }
            case 5 -> {
                customerNr = 13;
                info = "Ilmateade:Selge taevas, aga kulmavoitu";
            }
            case 6 -> {
                customerMax += 0.25;
                customerNr = 17;
                info = "Ilmateade:Ilus ilm, aga vesi on kulm";
            }
            case 7 -> {
                customerMax -= 0.10;
                customerNr = 22;
                info = "Ilmateade:Pilvine ilm, aga vesi on soe";
            }
        }
        return info;
    }
}
