/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class CRUD {
     private static int opcion = -1;
    private static final Scanner T = new Scanner(System.in);
    private static venta vent = new venta();

    public static void main(String[] args) {
       String niv = null; 
       
        while (opcion != 0) {
            try {
                System.out.println("BASE DE DATOS VENTA"
                        + "\nSelecciona una opcion\n"
                     
                        + "1.- IMPRIME BASE DE DATOS\n"
                        + "2.- LISTAR A TODOS LOS EMPLEADOS\n"
                        + "3.- ACTUALIZAR \n"
                        + "4.- ELIMINAR\n" 
                        + "0.- SALIR");
                opcion=Integer.parseInt(T.nextLine());
                
                switch (opcion) {
                   
                        
                       
                    case 1:
                        System.out.println("Como se dejo en clase");
                        
                        vent.imprimir(niv);
                     
                        break;
                    case 2:
                        System.out.println("Lista de empleados");
                        vent.listar();
                        
                        break;
                    case 3:
                        System.out.println("Actualizar registo");
                        System.out.println("Ingresa el NIV del empleado:");
                        niv=T.nextLine();
                        vent.update(niv);
                        
                        break;
                    case 4:
                        System.out.println("Eliminar Registro");
                        System.out.println("Ingrese el NIV del empleado:");
                        niv=T.nextLine();
                        vent.delete(niv);
                        
                        break;
                    case 0:
                        System.out.println("¡GRACIAAAS CUATE NOS VEMOS !");
                        break;
                    default:
                        System.out.println("NO SE ENTIENDE");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
}
