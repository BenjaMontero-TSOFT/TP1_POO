package model.places;

import model.Client;
import model.enums.TypeOfTemporate;

public class Cabin extends MeansOfLodging{

    private boolean firePlace;

    public Cabin(Double valueOfNight, int quantityOfPersons, Client client,
                     TypeOfTemporate typeOfTemporate, int quantityOfNights, boolean firePlace){
        super(valueOfNight, quantityOfPersons, client, typeOfTemporate, quantityOfNights);
        this.firePlace = firePlace;
    }

    public boolean incrementBaseValue(){
        if(this.quantityOfPersons > 5){
            this.setValueOfNight(this.getValueOfNight() + ((this.getValueOfNight() * 18/100)));
            return true;
        }
        return false;
    }

    @Override
    public Double getCancelValue() {
        return this.getSubTotal() - this.getDiscountVoucher();
    }

    @Override
    public String toString() {
        return "Cabin{" +
                "Chimenea=" + firePlace +
                ", Valor por noche=" + valueOfNight +
                ", Cantidad de personas=" + quantityOfPersons +
                ", Tipo de temporada=" + typeOfTemporate +
                ", Cantidad de noches=" + quantityOfNights +
                '}';
    }
}
