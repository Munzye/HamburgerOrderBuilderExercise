package com.ejemplo.builder;

public class Main {
    public static void main(String[] args) {

        Hamburguesa clasica = new Hamburguesa.Builder("Pan brioche", "Carne de res")
                .conQueso("Cheddar")
                .agregarIngrediente("Lechuga")
                .agregarIngrediente("Tomate")
                .agregarIngrediente("Cebolla caramelizada")
                .build();

        Hamburguesa sencilla = new Hamburguesa.Builder("Pan integral", "Pollo")
                .agregarIngrediente("Pepinillos")
                .build();

        System.out.println("= Hamburguesa 1 =");
        System.out.println(clasica);

        System.out.println("\n= Hamburguesa 2 =");
        System.out.println(sencilla);
    }
}
