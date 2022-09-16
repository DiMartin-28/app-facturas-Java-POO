package org.mdiaz.appfacturas;

import org.mdiaz.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cli = new Cliente();
        cli.setCuil("20-35529505-0");
        cli.setNombre("Martín Díaz");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        String desc = sc.nextLine();
        Factura fact = new Factura(desc, cli);

        Producto prod;

        System.out.println();

        for (int i = 0; i < 2; i++){
            prod = new Producto();
            System.out.println("Ingrese producto nro " + prod.getCodigo() +  ": ");
            prod.setNombre(sc.nextLine());

            System.out.println("Ingrese el precio: ");
            prod.setPrecio(sc.nextFloat());

            System.out.println("Ingrese la cantidad: ");

            fact.addItem( new ItemFactura(sc.nextInt(), prod));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(fact);
    }
}
