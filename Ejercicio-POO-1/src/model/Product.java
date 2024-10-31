package model;

public class Product {

    private String code;
    private Integer stock;
    private Double baseValue;

    public Product(String code, Integer stock, Double baseValue){
        this.code = code;
        this.stock = stock;
        this.baseValue = baseValue;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    private void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    private void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", stock=" + stock +
                ", baseValue=" + baseValue +
                '}';
    }

    public boolean isValidateStock(){
        return this.stock >= 1;
    }

    public void discountStock(int value){
        this.setStock(this.stock - value);
    }

}
