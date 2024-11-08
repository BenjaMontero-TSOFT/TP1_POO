package model.places;

import model.Client;
import model.enums.TypeOfTemporate;

public abstract class MeansOfLodging {

    protected Double valueOfNight;
    protected int quantityOfPersons;
    protected Client client;
    protected TypeOfTemporate typeOfTemporate;
    protected int quantityOfNights;

    protected MeansOfLodging(Double valueOfNight, int quantityOfPersons, Client client,
                             TypeOfTemporate typeOfTemporate, int quantityOfNights){
        this.typeOfTemporate = typeOfTemporate;
        this.valueOfNight = valueOfNight;
        this.quantityOfPersons = quantityOfPersons;
        this.client = client;
        this.quantityOfNights = quantityOfNights;
    }

    public Double getSubTotal(){
        return this.quantityOfNights * this.valueOfNight;
    }

    public Double getDiscountVoucher(){
        if(this.typeOfTemporate == TypeOfTemporate.LOW){
            return ((this.getSubTotal() * 25)/100);
        }

        if(this.typeOfTemporate == TypeOfTemporate.MEDIUM){
            return ((this.getSubTotal() * 12.5)/100);
        }

        return 0.0;
    }

    public abstract Double getCancelValue();

    public Double getValueOfNight() {
        return valueOfNight;
    }

    protected void setValueOfNight(Double valueOfNight) {
        this.valueOfNight = valueOfNight;
    }

    public int getQuantityOfPersons() {
        return quantityOfPersons;
    }

    protected void setQuantityOfPersons(int quantityOfPersons) {
        this.quantityOfPersons = quantityOfPersons;
    }

    public Client getClient() {
        return client;
    }

    protected void setClient(Client client) {
        this.client = client;
    }

    public TypeOfTemporate getTypeOfTemporate() {
        return typeOfTemporate;
    }

    protected void setTypeOfTemporate(TypeOfTemporate typeOfTemporate) {
        this.typeOfTemporate = typeOfTemporate;
    }

    public int getQuantityOfNights() {
        return quantityOfNights;
    }

    protected void setQuantityOfNights(int quantityOfNights) {
        this.quantityOfNights = quantityOfNights;
    }
}
