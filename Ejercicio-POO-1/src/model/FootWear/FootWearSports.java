package model.FootWear;

import model.Product;
import model.enums.DayOfSell;
import model.enums.Material;

public class FootWearSports extends FootWear {

    private String typeOfSports;
    private Material material;

    public FootWearSports(Product product,
                          DayOfSell dayOfSell,
                          Double numberOfFootWear,
                          String typeOfSports,
                          Material material){
        super(product, dayOfSell, numberOfFootWear);
        this.typeOfSports = typeOfSports;
        this.material = material;
    }

    @Override
    public String toString() {
        return "FootWearSports{" +
                "typeOfSports='" + typeOfSports + '\'' +
                ", material=" + material +
                ", dayOfSell=" + dayOfSell +
                ", product=" + product +
                ", numberOfFootWear=" + numberOfFootWear +
                '}';
    }

    public Double getTaxMaterial() {
        if(this.material == Material.LEATHER){
            return ((this.getProduct().getBaseValue() * 15)/100);
        }else if (this.material == Material.CANVAS){
            return ((this.getProduct().getBaseValue() * 6)/100);
        }else{
            return 0.0;
        }
    }

    @Override
    public Double getValueToBuy() {
        if(this.getProduct().isValidateStock()){
            this.getProduct().discountStock(1);
            Double valueOfSell = this.getValueOfSell();
            Double taxIva = this.getTaxIVA();
            Double taxMaterial = this.getTaxMaterial();
            return valueOfSell + taxIva + taxMaterial;
        }else{
            return -1.0;
        }
    }
}
