package com.derek.convertidordemoneda.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        PrincipalConBusqueda pcb = new PrincipalConBusqueda();

        int opcion = 0;
        double valorAConvertir = 0;
        double resultado = 0;

        String bienvenida = """
                *******************************************************
                Bienvenidos a su convertidor de moneda de confianza
                *******************************************************
                """;

        String menu = """
                *******************************************************
                
                Escoge la conversión que desees realizar: 
                
                1. Dólar Estadounidense / Peso Colombiano
                2. Peso Colombiano / Dólar Estadounidense
                3. Euro / Dólar Estadounidense
                4. Dólar Estadounidense / Yen Japonés
                5. Libra Esterlina / Dólar Estadounidense
                6. Dólar Estadounidense / Franco Suizo
                7. Dólar Australiano / Dólar Estadounidense
                8. Dólar Estadounidense / Dólar Canadiense
                9. Realiza la conversión que desees
                10. Salir del programa
                
                *******************************************************
                """;

        Scanner teclado = new Scanner(System.in);

        System.out.println(bienvenida);

        while (opcion != 10){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1 -> conversion(pcb, teclado, "USD", "COP");
                case 2 -> conversion(pcb, teclado, "COP", "USD");
                case 3 -> conversion(pcb, teclado, "EUR", "USD");
                case 4 -> conversion(pcb, teclado, "USD", "JPY");
                case 5 -> conversion(pcb, teclado, "GBP", "USD");
                case 6 -> conversion(pcb, teclado, "USD", "CHF");
                case 7 -> conversion(pcb, teclado, "AUD", "USD");
                case 8 -> conversion(pcb, teclado, "USD", "CAD");
                case 9 -> {
                    teclado.nextLine();
                    System.out.println("Ingresa el código de la moneda fuente (por ejemplo: USD): ");
                    String monedaBase = teclado.nextLine().toUpperCase();

                    System.out.println("Ingresa el código de la moneda objetivo (por ejemplo: COP): ");
                    String monedaDestino = teclado.nextLine().toUpperCase();

                    conversion(pcb, teclado, monedaBase, monedaDestino);
                }
                case 10 -> System.out.println("Gracias por usar nuestro programa!");
                default -> System.out.println("Opción invalida, intente uevamente por favor.");
            }
        }
    }

    public static void conversion(PrincipalConBusqueda pcb, Scanner teclado, String monedaBase, String monedaDestino){
        pcb.setMonedaBase(monedaBase);
        pcb.setMonedaDestino(monedaDestino);

        System.out.println("Ingresa el monto a convertir: ");
        double valorAConvertir = teclado.nextDouble();

        pcb.consultarTasa();

        double resultado = valorAConvertir * pcb.getTasa();
        System.out.println("Resultado: " + resultado + " " + pcb.getMonedaDestino());
    }


}