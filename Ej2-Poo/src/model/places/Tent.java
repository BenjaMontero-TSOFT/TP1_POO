package model.places;

import model.Client;
import model.enums.TypeOfTemporate;

public class Tent extends Hostel{

    public Tent(Double valueOfNight, int quantityOfPersons, Client client, TypeOfTemporate typeOfTemporate,
                   int quantityOfNights, boolean isSmoker) {
        super(valueOfNight, quantityOfPersons, client, typeOfTemporate, quantityOfNights, isSmoker);
    }

    @Override
    public Double getCancelValue() {
        return this.getSubTotal() - this.getDiscountVoucher();
    }
}
