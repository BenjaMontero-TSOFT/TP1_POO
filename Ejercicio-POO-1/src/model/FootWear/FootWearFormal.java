package model.FootWear;

import model.Product;
import model.enums.DayOfSell;

import java.util.HashMap;
import java.util.concurrent.Callable;

public abstract class FootWearFormal extends FootWear {

    protected String color;
    public abstract Double getDiscount();

    protected FootWearFormal(Product product,
                             DayOfSell dayOfSell,
                             Double numberOfFootWear,
                             String color){
        super(product, dayOfSell, numberOfFootWear);
        this.color = color;

    }

    /*retornará el valor de impuesto específico el cual es un 7.4% del valor base (el calzado deportivo no paga éste impuesto)*/
    public Double getTaxSpecific() {
        return ((this.getProduct().getBaseValue() * 7.4) / 100);
    }


    /*Si hay Stock: disminuirá el stock en 1 y además, retornará el valor a pagar por el cliente, el cual
    será: el valor venta menos los descuentos más impuestos (donde corresponda)
    Si no hay Stock, retornará -1*/
    @Override
    public Double getValueToBuy() {
        if(this.getProduct().isValidateStock()){
            this.product.discountStock(1);
            Double valueOfSell = this.getValueOfSell();
            Double discount = this.getDiscount();
            Double taxIva = this.getTaxIVA();
            Double taxSpecific = this.getTaxSpecific();
            return (valueOfSell + taxIva + taxSpecific) - discount;
        }else{
            return -1.0;
        }
    }
}
