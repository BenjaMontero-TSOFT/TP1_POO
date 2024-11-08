package model.places;

import model.Client;
import model.enums.TypeOfTemporate;

public class Hotel extends Hostel{

    private boolean includeBreakfast;

    public Hotel(Double valueOfNight, int quantityOfPersons, Client client,
                     TypeOfTemporate typeOfTemporate, int quantityOfNights, boolean isSmoker, boolean includeBreakfast){
        super(valueOfNight, quantityOfPersons, client, typeOfTemporate, quantityOfNights, isSmoker);
        this.includeBreakfast = includeBreakfast;
    }

    @Override
    public Double getCancelValue() {
        return this.getSubTotal() + this.getAdicionalValue() - this.getDiscountVoucher();
    }

    public Double getAdicionalValue(){
        if(this.isSmoker && this.includeBreakfast){
            return ((this.getSubTotal() * 30)/100);
        }

        return 0.0;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Incluye desayuno=" + includeBreakfast +
                ", Es fumador=" + isSmoker +
                ", Valor por noche=" + valueOfNight +
                ", Cantidad de personas=" + quantityOfPersons +
                ", Tipo de temporada=" + typeOfTemporate +
                ", Cantidad de noches=" + quantityOfNights +
                '}';
    }
}
