package view;

import controller.ControllerLocal;
import model.FootWear.FootWear;
import model.FootWear.FootWearFormalWoman;
import model.Product;
import model.enums.DayOfSell;
import model.enums.Material;

import java.io.IOException;
import java.util.List;

public class View {

    private static ControllerLocal controllerLocal = new ControllerLocal();

    public View() {

    }

    public static void main(String[] args) {
        controllerLocal.launchProgram();
    }

    public void showData(String s) {
        System.out.println(s);
    }


    public void showMenu(){
        System.out.println("Sistema\n" +
                "1. Ingresar\n" +
                "2. Mostrar sólo los calzado de mujer\n" +
                "3. Valor Venta\n" +
                "4. Calzados top\n" +
                "5. Total Impuesto Especifico\n" +
                "6. Total descuento\n" +
                "7. Salir");
    }

    public void showSubMenu(){
        System.out.println("Selccionar el calzado a ingresar \n" +
                "1. Calzado Deportivo \n" +
                "2. Calzado Formal Femenino \n" +
                "3. Calzado Formal Masculino \n" +
                "4. Atras \n");
    }
}



