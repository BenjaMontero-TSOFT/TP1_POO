package model.FootWear;

import model.Product;
import model.enums.DayOfSell;

public class FootWearFormalMen extends FootWearFormal{

    public FootWearFormalMen(
            Product product,
            DayOfSell dayOfSell,
            Double numberOfFootWear,
            String color){
        super(product, dayOfSell, numberOfFootWear, color);
    }


    @Override
    public String toString() {
        return "FootWearFormalMen{" +
                "color='" + color + '\'' +
                ", product=" + product +
                ", dayOfSell=" + dayOfSell +
                ", numberOfFootWear=" + numberOfFootWear +
                '}';
    }

    /*Si el calzado es de hombre y de color es “Rojo” o “Verde el descuento será de un 25%*/
    @Override
    public Double getDiscount() {
        if(this.color.equalsIgnoreCase("rojo") || this.color.equalsIgnoreCase("verde")){
            return ((this.getValueOfSell()*25)/100);
        }

        return 0.0;
    }
}
