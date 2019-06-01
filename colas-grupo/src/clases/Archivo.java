/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author migue
 */
public class Archivo {
    private String [][] ar;
    private double prov1, prov2, prov3, prov4;
    int inicio,fin;

    public Archivo() {
        this.ar=new String[100][4];
        this.prov1 = 0.1;
        this.prov2 = 0.25;
        this.prov3 = 0.40;
        this.prov4 = 1;
        fin=0;
        inicio=0;
    }

    public Archivo(double prov1, double prov2, double prov3, double prov4) {        
        this.ar=new String[100][4];
        System.out.println(prov1);
        this.prov1 = prov1;
        this.prov2 = prov2;
        this.prov3 = prov3;
        this.prov4 = prov4;
        fin=0;
        inicio=0;
    }

    public void cargarAchivo() throws FileNotFoundException{
        String line="";
        FileReader f = new FileReader("nombres.txt");
        BufferedReader b = new BufferedReader(f);
       try{
           while(fin<100 && b.ready()){
               line=b.readLine();
               StringTokenizer token=new StringTokenizer(line,",");
               probabilidades ne=new probabilidades();
               this.ar[this.fin][0]=token.nextToken();
               this.ar[this.fin][1]=token.nextToken();
               this.ar[this.fin][2]=token.nextToken();
               this.ar[this.fin][3]=String.valueOf(ne.generarPrbabilidad(prov1, prov2, prov3, prov4));
               this.fin++;
           }
           b.close();
       }catch(IOException e){
           System.out.println("Error en carga de archivo");
       }
       
    }

    public String [] extraer(){
        String nuevo[]=new String[4];
        if(inicio==fin){
            inicio=0;
        }
        nuevo[0]=this.ar[inicio][0];
        nuevo[1]=this.ar[inicio][1];
        nuevo[2]=this.ar[inicio][2];
        nuevo[3]=this.ar[inicio][3];
        inicio++;
        return nuevo;
    }

    
    
    
}
