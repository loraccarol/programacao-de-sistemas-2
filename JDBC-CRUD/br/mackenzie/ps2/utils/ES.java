package br.mackenzie.ps2.utils;

import java.util.Scanner;
public class ES {

    static Scanner scanner = new Scanner(System.in);

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static int inputInt(String msg) {
        boolean valido = false;
        int valor = 0;
        while (!valido) {
            try {
                valor = Integer.parseInt(inputString(msg));
                valido = true;
            } catch(NumberFormatException ex) {
                System.out.println("\n## Entrada inválida! Por favor, entre um número.\n");
            }
        }
        return valor;
    }
    
    public static String inputString(String msg) {
        System.out.print(msg + " ");
        String s;
        s = scanner.nextLine();
        return s;
    }
    public static double inputDouble(String msg) {
        boolean valido = false;
        double valor = 0;
        while (!valido) {
            try {
                valor = Double.parseDouble(inputString(msg));
                valido = true;
            } catch(NumberFormatException ex) {
                System.out.println("\n## Entrada inválida! Por favor, entre um número.\n");
            }
        }
        return valor;
    }

}