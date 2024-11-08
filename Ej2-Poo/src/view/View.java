package view;

import controller.ManagmentController;
import model.enums.TypeOfTemporate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    private BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private ManagmentController managmentController = new ManagmentController(this);
    public static void main(String[] args) {
        View view = new View();
        view.handlerDecision();
    }

    public View(){};

    public void handlerDecision(){
        String entry = "0";
        while (!entry.equalsIgnoreCase("9")){
            showMenu();
            entry = validateValueBufferReader(1,9);
            switch (entry){
                case "1":
                    System.out.println(managmentController.ingressNewMeansOfLodging());
                    break;
                case "2":
                    System.out.println(managmentController.getAllMeansOfLodging());
                    break;
                case "3":
                    System.out.println(managmentController.getDataOfClient());
                    break;
                case "4":
                    System.out.println(managmentController.getAllTotalAditional());
                    break;
                case "5":
                    System.out.println(managmentController.getAllTotalDiscount());
                    break;
                case "6":
                    System.out.println(managmentController.getQuantityOfMeansOfLodging());
                    break;
                case "7":
                    System.out.println(managmentController.getValueToCancelOfClient());
                case "8":
                    System.out.println(managmentController.incrementBaseValue());
                    break;
            }
        }
    }

    public String validateValueBufferReader(int to, int end) {
        try {
            String value = buffer.readLine();
            int entry = Integer.parseInt(value);
            if(!(entry >= to && entry <= end)){//if the value of buffer reader is not between to and end then restart the ingress
                System.out.println("Valor incorrecto, vuelve a ingresar un nuevo valor");
                return validateValueBufferReader(to, end);
            }
            return value;
        }catch(NumberFormatException n) {
            System.out.println("Debes ingresar un valor entero");
            return validateValueBufferReader(to, end);
        }catch (IOException e){
            System.out.println("Error en la lectura");
            return "";
        }
    }

    public String insertString(){
        try {
            String value = buffer.readLine();
            return value;
        }catch (IOException e){
            System.out.println("Error en la lectura de datos");
        }
        return insertString();
    }

    private static void showMenu(){
        System.out.println("Sistema de Alojamiento\n" +
                "1.\tIngresar Medio de Alojamiento (almacena un objeto de tipo Carpa/Cabaña/Hotel en la colección, siempre que no exista, es decir solo se puede asociar un cliente por medio de alojamiento.)\n" +
                "2.\tMostrar medios de alojamiento (muestra datos de todos los objetos almacenados)\n" +
                "3.\tDatos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)\n" +
                "4.\tTotal adicional\n" +
                "5.\tTotal bono descuento\n" +
                "6.\tCantidad medios de alojamiento X\n" +
                "7.\tValor a cancelar por un cliente X (el cliente debe existir)\n" +
                "8.\tAplicar incremento del valor base (donde corresponda)\n" +
                "9.\tSalir.\n");
    }

    public void showMeansOfLodging(){
        System.out.println("Selcciona el medio de alojamiento \n" +
                "1. Hotel \n" +
                "2. Cabaña \n" +
                "3. Carpa \n" +
                "4. Atras \n");
    }

    public void showData(String s){
        System.out.println(s);
    }

    public TypeOfTemporate ingressTypeOfTemporate(){
        System.out.println("Selecciona el tipo de temporada \n" +
                "1. Temporada Baja \n" +
                "2. Temporada Media \n" +
                "3. Temporada Alta");
        String entry =  validateValueBufferReader(1,3);

        if(entry.equalsIgnoreCase("1")) return TypeOfTemporate.LOW;

        if(entry.equalsIgnoreCase("2")) return TypeOfTemporate.MEDIUM;

        return TypeOfTemporate.HIGH;
    }

    public Integer insertIntegerValue(){
        try {
            String entrada = buffer.readLine();
            int value = Integer.parseInt(entrada);
            return value;
        }catch (NumberFormatException n){
            this.showData("Valor incorrecto, ingrese un valor valido");
        }catch (IOException e){
            this.showData("Error en la lectura de datos");
        }
        return insertIntegerValue();
    }

    public Integer selectedTypeOfMeansOfLodging(){
        System.out.println("Selecciona el medio de alojamiento \n" +
                "1. Hotel \n" +
                "2. Cabaña \n" +
                "3. Carpa");
        String entry =  validateValueBufferReader(1,3);

        return Integer.parseInt(entry);
    }

    public boolean insertBoolean() {
        System.out.println(
                "1. Si \n" +
                "2. No ");;
        String entry =  validateValueBufferReader(1,3);
        return Integer.parseInt(entry) == 1 ? true : false;
    }

    public Double insertDouble() {
        try {
            String entrada = buffer.readLine();
            double value = Double.parseDouble(entrada);
            return value;
        }catch (NumberFormatException n){
            this.showData("Valor incorrecto, ingrese un valor valido");
        }catch (IOException e){
            this.showData("Error en la lectura de datos");
        }
        return insertDouble();
    }
}