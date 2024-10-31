package model;

import model.FootWear.FootWear;
import model.FootWear.FootWearFormalWoman;
import model.enums.DayOfSell;

import java.util.*;
import java.util.stream.Collectors;


public class InventoryLocal {

    private HashMap<String, FootWear> footWear;

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;

    public InventoryLocal(){
        this.footWear = new HashMap<String, FootWear>();
        this.products = new ArrayList<>();
        this.init();
    }

    public void addFootWear(FootWear footWear){
        if(!this.footWear.containsKey(footWear.getProduct().getCode())){ //if not exist the code product
            this.footWear.put(footWear.getProduct().getCode(), footWear);
        }
    }

    public List<FootWear> getAllFootWearOfLocal(){
        return (List<FootWear>) this.footWear.values();
    }

    public List<FootWearFormalWoman> getAllFootWearOfWoman(){
        return this.footWear.values().stream()
                .filter(wear -> wear instanceof FootWearFormalWoman)
                .map(f -> (FootWearFormalWoman)f)
                .collect(Collectors.toList());
    }

    private void init (){
        Product p1 = new Product("P1", 10, 10.0);
        Product p2 = new Product("P2", 12, 12.0);
        Product p3 = new Product("P3", 14, 14.0);
        this.products.add(p1);
        this.products.add(p2);
        this.products.add(p3);

        FootWear f = new FootWearFormalWoman(p1, DayOfSell.WEEK, 12.1, "Rojo", 12.0);
        FootWear f1 = new FootWearFormalWoman(p2, DayOfSell.WEEK, 12.1, "Rojo", 8.0);
        this.addFootWear(f);
        this.addFootWear(f1);
    }

    public List<FootWear> getFootWearWithValueMoreThat(Double value) {
        return this.footWear.values().stream()
                .filter(f -> f.getValueOfSell() >= value)
                .collect(Collectors.toList());
    }
}
