/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class venta {
    
    private Scanner tx = new Scanner(System.in);
    
    
    public void imprimir(String niv){
       //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbventa?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","PicHel55314750");        
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM dbventa.tb_venta";
            ResultSet resultado = sentencia.executeQuery(sql);
            
            
            while(resultado.next()){
                int r = resultado.getInt(3)+resultado.getInt(4)+resultado.getInt(5)+
                        resultado.getInt(6)+resultado.getInt(7)+resultado.getInt(8);
                System.out.println("NIV ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero = "+resultado.getInt(3));
                System.out.println("Febrero = "+resultado.getInt(4));
                System.out.println("Marzo = "+resultado.getInt(5));
                System.out.println("Abril = "+resultado.getInt(6));
                System.out.println("Mayo = "+resultado.getInt(7));
                System.out.println("Junio = "+resultado.getInt(8));
                System.out.println("Total ventas = "+r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
}
    public void listar(){
        String url = "jdbc:mysql://localhost:3306/dbventa?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url,"root","PicHel55314750");
            Statement sentencia = conexion.createStatement();
            String query = "SELECT * FROM dbventa.tb_venta";
            ResultSet resultado = sentencia.executeQuery(query);
            int enero=0,febrero=0,marzo=0,abril=0,mayo=0,junio=0;
            
            while(resultado.next()){
                System.out.println("NIV ="+resultado.getInt(1)+"| Nombre = "+resultado.getString(2)+"\t\t| Enero = "+resultado.getInt(3)+
                "| Febrero = "+resultado.getInt(4)+"| Marzo = "+resultado.getInt(5)+"| Abril = "+resultado.getInt(6)+
                "| Mayo = "+resultado.getInt(7)+"| Junio = "+resultado.getInt(8));
                
                enero=enero+resultado.getInt(3); febrero=febrero+resultado.getInt(4);
                marzo=marzo+resultado.getInt(5);abril=abril+resultado.getInt(6);
                mayo=mayo+resultado.getInt(7);junio=junio+resultado.getInt(8);
                
            }
            System.out.println("TOTAL DE VENTAS DE CADA MES ");
            System.out.println("Enero = "+enero+"\nFebrero = "+febrero+"\nMarzo = "+marzo);
            System.out.println("Abril = "+abril+"\nMayo = "+mayo+"\nJunio = "+junio);
            
        } catch (SQLException ex) {
            System.out.println("hay clavos "+ex);
        }
    }
    public void delete(String niv){
         String url = "jdbc:mysql://localhost:3306/dbventa?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url,"root","PicHel55314750");
            Statement sentencia = conexion.createStatement();
            
            String query2 = "SELECT * FROM tb_venta where NIV="+niv;
            String query = "delete from tb_venta where NIV="+niv;
            String respuesta;
            
            System.out.println("Estas seguro que quieres eliminar a : ");
            ResultSet resultado = sentencia.executeQuery(query2);
            
            while(resultado.next()){
               System.out.println("NIV = "+resultado.getInt(1)+ " Nombre = "+resultado.getString(2));
            }
            
            respuesta=tx.nextLine();
            
            if (respuesta.equalsIgnoreCase("si")) {
                sentencia.executeUpdate(query);
                System.out.println("Eliminado");

            }else{
                System.out.println("Eliminacion cancelada");
            }
            
        } catch (SQLException ex) {
            System.out.println("Hay un problema... "+ex);
        }
        
    }
    public void update(String niv){
        String url = "jdbc:mysql://localhost:3306/dbventa?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            String nombre;
            Connection conexion = DriverManager.getConnection(url,"root","PicHel55314750");
            Statement sentencia = conexion.createStatement();
            String query2 = "SELECT * FROM tb_venta  where NIV = "+niv;
            ResultSet resultado = sentencia.executeQuery(query2);
            
            while(resultado.next()){
               System.out.println("NIV = "+resultado.getInt(1)+ " Nombre = "+resultado.getString(2));
              
               System.out.println("Ingrese el nombre a modificar : ");
            }
            
            nombre=tx.nextLine();
            String query = "update tb_venta  set nombre= '"+nombre+"' where NIV= "+niv;
            sentencia.executeUpdate(query);
            System.out.println("!SE ACTUALIZO EL REGRISTO");
          
        } catch (SQLException ex) {
            System.out.println("Hay un problema : "+ex);
        }
        
        
    }
    
}
