package model.places;

import model.Client;
import model.enums.TypeOfTemporate;

public abstract class Hostel extends MeansOfLodging {

    protected boolean isSmoker;

    protected Hostel(Double valueOfNight, int quantityOfPersons, Client client,
                     TypeOfTemporate typeOfTemporate, int quantityOfNights, boolean isSmoker){
        super(valueOfNight, quantityOfPersons, client, typeOfTemporate, quantityOfNights);
        this.isSmoker = isSmoker;
    }
}
