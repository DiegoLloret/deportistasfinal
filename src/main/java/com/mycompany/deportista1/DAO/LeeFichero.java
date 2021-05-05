/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.DAO;

/**
 *
 * @author Diego
 */
import java.io.*;

public class LeeFichero {
   public static void main(String [] arg) {
       LeeFichero a=new LeeFichero();
       
       String conex= a.leeConexion("C:/trabajo final/conexion.txt");
       System.out.println("con:"+conex);
   }       
public static String leeConexion(String fichero){
        File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String linea=""; 
       
   
        StringBuilder sb = new StringBuilder();
       
 
        
    
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (fichero);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         
         while((linea=br.readLine())!=null)
           sb.append(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return sb.toString();
   }
}
