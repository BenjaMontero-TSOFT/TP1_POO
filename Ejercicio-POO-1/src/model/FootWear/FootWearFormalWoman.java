package model.FootWear;

import model.Product;
import model.enums.DayOfSell;

public class FootWearFormalWoman extends FootWearFormal{

    private Double heightHell;

    public FootWearFormalWoman(
            Product product,
            DayOfSell dayOfSell,
            Double numberOfFootWear,
            String color,
            Double heightHell){
        super(product, dayOfSell, numberOfFootWear, color);
        this.heightHell = heightHell;
    }

    /*Si la altura del taco es mayor a 10, el descuento será de un 20% del valor venta*/
    @Override
    public Double getDiscount() {
        if(this.heightHell > 10){
            return ((this.getValueOfSell() * 20)/100);
        }

        return 0.0;
    }

    public Double getHeightHell() {
        return heightHell;
    }

    @Override
    public String toString() {
        return "FootWearFormalWoman{" +
                "heightHell=" + heightHell +
                ", color='" + color + '\'' +
                ", numberOfFootWear=" + numberOfFootWear +
                ", dayOfSell=" + dayOfSell +
                ", product=" + product +
                '}';
    }
}
