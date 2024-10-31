package model.FootWear;

import model.Product;
import model.enums.DayOfSell;

public abstract class FootWear {

    protected Product product;
    protected DayOfSell dayOfSell;
    protected Double numberOfFootWear;

    public abstract Double getValueToBuy();

    protected FootWear(Product product,
                    DayOfSell dayOfSell,
                    Double numberOfFootWear){
        this.product = product;
        this.dayOfSell = dayOfSell;
        this.numberOfFootWear = numberOfFootWear;
    }

    /*valorVenta: retornará el valor de venta del calzado, sabiendo
    que el fin de semana, aumenta en un 24% el valor Base y en la semana
    el valor Base disminuye en un 15%.*/
    public Double getValueOfSell(){
        Double baseValue = this.product.getBaseValue();

        return switch (this.dayOfSell) {
            case DayOfSell.WEEK -> baseValue - ((baseValue * 15) / 100);
            case DayOfSell.WEEKEND -> baseValue + ((baseValue * 24) / 100);
            default -> 0.0;
        };
    }
    /*retornará el valor por concepto de IVA que es el 19% del valor venta*/
    public Double getTaxIVA(){
        return ((this.getValueOfSell() * 19) / 100);
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    public DayOfSell getDayOfSell() {
        return dayOfSell;
    }

    private void setDayOfSell(DayOfSell dayOfSell) {
        this.dayOfSell = dayOfSell;
    }

    public Double getNumberOfFootWear() {
        return numberOfFootWear;
    }

    private void setNumberOfFootWear(Double numberOfFootWear) {
        this.numberOfFootWear = numberOfFootWear;
    }
}
