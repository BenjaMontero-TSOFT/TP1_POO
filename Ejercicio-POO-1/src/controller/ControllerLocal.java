package controller;

import model.FootWear.FootWear;
import model.FootWear.FootWearFormalMen;
import model.FootWear.FootWearFormalWoman;
import model.FootWear.FootWearSports;
import model.InventoryLocal;
import model.Product;
import model.enums.DayOfSell;
import model.enums.Material;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class ControllerLocal {

    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private InventoryLocal inventoryLocal;
    private String entrada = "0";
    private View view = new View();

    public ControllerLocal(){
        this.inventoryLocal = new InventoryLocal();
    }

    private List<Product> getListOfProducts(){
        return inventoryLocal.getProducts();
    }

    private boolean isValidCode(String codeProduct) {
        for (Product p : this.getListOfProducts()){
            if(p.getCode().equalsIgnoreCase(codeProduct)){
                return true;
            }
        }

        return false;
    }

    public void launchProgram(){
        while (!entrada.equals("7")){
            view.showMenu();
            this.validateValueBufferReader(1,7);
            this.handlerDecisionsGeneral(Integer.parseInt(entrada));
        }
    }

    private void handlerDecisionsGeneral(int value) {
        switch (value){
            case 1:
                showInsertFootWear();
            case 2:
                getAllFootWearFormalWoman();
            case 3:
                showNumberOfFootWear();
            case 4:
                showFootWearWithValueMoreThat(80000.0);
            case 5:
                showAllTaxSpecific();
            case 6:
                showTotalDiscountOfSell();
            default:
                break;
        }
    }

    private void showTotalDiscountOfSell() {
        List<FootWear> footWearList = this.getAllFootWear();
        StringBuilder s = new StringBuilder();
        for (FootWear f : footWearList) {
            s.append(f.toString()).append("\n");
        }
        this.view.showData(s.toString());
    }

    private void createFootWearSport(DayOfSell dayOfSell, Double numberOfFootWear,
                                    Material material, String typeOfSports, String codeProduct) {
        Product product = this.getProductByCode(codeProduct);
        if(product != null){//always will into in to the conditional
            FootWear footWearSports = new FootWearSports(product, dayOfSell, numberOfFootWear, typeOfSports,material);
            this.inventoryLocal.addFootWear(footWearSports);
        }
    }

    private Product getProductByCode(String codeProduct){
        return this.getListOfProducts().stream()
                .filter(p -> p.getCode().equalsIgnoreCase(codeProduct)).findFirst().orElse(null);
    }

    private void showNumberOfFootWear(){
        //todo terminar
    }

    private void showFootWearWithValueMoreThat(Double value){
        List<FootWear> footWearList = this.getFootWearWithValueMoreThat(value);
        StringBuilder s = new StringBuilder();
        for (FootWear f : footWearList){
            s.append(f.toString()).append("\n");
        }

        this.view.showData(s.toString());
    }

    private void showAllTaxSpecific(){
        //todo: en que momento se vende ?
    }

    private void getAllFootWearFormalWoman(){
        List<FootWearFormalWoman> list = this.inventoryLocal.getAllFootWearOfWoman();
        StringBuilder s = new StringBuilder();
        for (FootWearFormalWoman f : list){
            s.append("Altura de taco: ").append(f.getHeightHell())
                    .append("\nDia de venta: ")
                    .append(f.getDayOfSell().toString())
                    .append("\nDescuento: ")
                    .append(f.getDiscount())
                    .append("\n");
        }
        this.view.showData(s.toString());
    }

    private void showInsertFootWear(){
        this.view.showSubMenu();
        this.validateValueBufferReader(1, 4);
        int newValueInsert = Integer.parseInt(entrada);
        if(newValueInsert == 4){
            return;
        }
        this.view.showData("\n ");
        handlerDecisionFootWear(newValueInsert);
    }

    private void handlerDecisionFootWear(int value){
        switch (value){
            case 1:
                insertFootWearSports();
            case 2:
                insertFootWearFormalWoman();
            case 3:
                insertFootWearFormalMen();
            default:
                break;
        }
    }

    private void insertFootWearSports(){
        this.view.showData("Ingresa el codigo del producto a ingresar \n");
        showProducts();
        try {
            String codeProduct= buffer.readLine();
            if(this.isValidCode(codeProduct)){
                DayOfSell dayOfSell = insertDayOfSell();
                this.view.showData("Ingresa el numero de calzado");
                Double numberOfFootWear = insertDoubleValue();
                Material material = insertMaterialOfSportFootWear();
                this.view.showData("Ingresa el tipo de deporte");
                String typeOfSports = insertString();
                this.createFootWearSport(dayOfSell, numberOfFootWear,material,typeOfSports, codeProduct);
                this.view.showData("\nCalzado creado correctamente\n");
            }else{
                this.view.showData("Codigo de producto invalido \n");
                insertFootWearSports();
            }
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
    }

    private void insertFootWearFormalMen(){
        this.view.showData("Ingresa el codigo del producto a ingresar \n");
        showProducts();
        try {
            String codeProduct= buffer.readLine();
            if(this.isValidCode(codeProduct)){
                DayOfSell dayOfSell = insertDayOfSell();
                this.view.showData("Ingresa el numero de calzado");
                Double numberOfFootWear = insertDoubleValue();
                this.view.showData("Ingresa el color");
                String color = insertString();
                this.createFootWearMen(dayOfSell, numberOfFootWear,color, codeProduct);
                this.view.showData("\nCalzado creado correctamente\n");
            }else{
                this.view.showData("Codigo de producto invalido \n");
                insertFootWearSports();
            }
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
    }

    private void insertFootWearFormalWoman(){
        this.view.showData("Ingresa el codigo del producto a ingresar \n");
        showProducts();
        try {
            String codeProduct= buffer.readLine();
            if(this.isValidCode(codeProduct)){
                DayOfSell dayOfSell = insertDayOfSell();
                this.view.showData("Ingresa el numero de calzado");
                Double numberOfFootWear = insertDoubleValue();
                this.view.showData("Ingresa el color");
                String color = insertString();
                this.view.showData("Ingresa la altura del taco");
                Double heightHell = insertDoubleValue();
                this.createFootWearWoman(dayOfSell, numberOfFootWear,color, codeProduct, heightHell);
                this.view.showData("\nCalzado creado correctamente\n");
            }else{
                this.view.showData("Codigo de producto invalido \n");
                insertFootWearSports();
            }
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
    }

    private  String insertString(){
        try {
            String value = buffer.readLine();
            return value;
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
        return insertString();
    }

    private  DayOfSell insertDayOfSell(){
        try {
            this.view.showData("Ingresa el dia de venta que desees \n" +
                    "1. Semana \n" +
                    "2. Fin de Semana");
            String entrada = buffer.readLine();
            int value = Integer.parseInt(entrada);
            if(value == 1 || value == 2){
                return value == 1 ? DayOfSell.WEEK : DayOfSell.WEEKEND;
            }
            this.view.showData("Valor incorrecto, ingrese un valor valido");
        }catch (NumberFormatException n){
            this.view.showData("Valor incorrecto, ingrese un valor valido");
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
        return insertDayOfSell();
    }

    private  Double insertDoubleValue(){
        try {
            String entrada = buffer.readLine();
            double value = Double.parseDouble(entrada);
            return value;
        }catch (NumberFormatException n){
            this.view.showData("Valor incorrecto, ingrese un valor valido");
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
        return insertDoubleValue();
    }

    private void showProducts(){
        List<Product> productsList = this.getListOfProducts();

        StringBuilder s = new StringBuilder();
        for (Product product : productsList){
                    s.append("Codigo: ")
                            .append(product.getCode())
                            .append(" Stock: ")
                            .append(product.getStock())
                            .append(" Valor: ").append(product.getBaseValue())
                            .append("\n");
        }
        this.view.showData(s.toString());
    }


    private  Material insertMaterialOfSportFootWear(){
        try {
            this.view.showData("Ingresa el Material que desees \n" +
                    "1. Cuero \n" +
                    "2. Lona");
            String entrada = buffer.readLine();
            int value = Integer.parseInt(entrada);
            if(value == 1 || value == 2){
                return value == 1 ? Material.LEATHER : Material.CANVAS;
            }
            this.view.showData("Valor incorrecto, ingrese un valor valido");
        }catch (NumberFormatException n){
            this.view.showData("Valor incorrecto, ingrese un valor valido");
        }catch (IOException e){
            this.view.showData("Error en la lectura de datos");
        }
        return insertMaterialOfSportFootWear();
    }

//    private String getProductExample(){
//        Product p = this.getProductByCode("p1");
//        String s = "Codigo de producto: " + p.getCode() +
//                "\nStock: " +p.getCode();
//        return s;
//    }

    private void createFootWearMen(DayOfSell dayOfSell, Double numberOfFootWear, String color, String codeProduct) {
        Product product = this.getProductByCode(codeProduct);
        if(product != null){//always will into in to the conditional
            FootWear footWearFormalMen = new FootWearFormalMen(product, dayOfSell, numberOfFootWear, color);
            this.inventoryLocal.addFootWear(footWearFormalMen);
        }
    }

    private void createFootWearWoman(DayOfSell dayOfSell, Double numberOfFootWear, String color, String codeProduct, Double heightHell) {
        Product product = this.getProductByCode(codeProduct);
        if(product != null){//always will into in to the conditional
            FootWear footWearFormalMen = new FootWearFormalWoman(product, dayOfSell, numberOfFootWear, color, heightHell);
            this.inventoryLocal.addFootWear(footWearFormalMen);
        }
    }

//    public List<FootWearFormalWoman> getAllFootWearFormalWoman(){
//        return this.inventoryLocal.getAllFootWearOfWoman();
//    }

    private List<FootWear> getFootWearWithValueMoreThat(Double value){
        return this.inventoryLocal.getFootWearWithValueMoreThat(value);
    }

    private List<FootWear> getAllFootWear(){
        return this.inventoryLocal.getAllFootWearOfLocal();
    }

    private void validateValueBufferReader(int to, int end) {
        try {
            entrada = buffer.readLine();
            int value = Integer.parseInt(entrada);
            if(!(value >= to && value <= end)){//if the value of buffer reader is not between to and end then restart the ingress
                this.view.showData("Valor incorrecto, vuelve a ingresar un nuevo valor");
                validateValueBufferReader(to, end);
            }
        }catch(NumberFormatException n) {
            this.view.showData("Debes ingresar un valor entero");
            validateValueBufferReader(to, end);
        }catch (IOException e){
            this.view.showData("Error en la lectura");
        }
    }
}
