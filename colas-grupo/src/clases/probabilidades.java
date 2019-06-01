/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author migue
 */
public class probabilidades {
    private double ramdom;

    public probabilidades() {
        this.ramdom = 0;
    }
    
    public int generarPrbabilidad(double prov1, double prov2, double prov3, double prov4){        
        ramdom=Math.random()*100+1;
        System.out.println(ramdom);
        System.out.println((prov1*100)+" "+((prov4+prov3+prov2+prov1)*100));
        if(ramdom>0&&ramdom<=prov1*100){
            ramdom=3;
        }else if(ramdom>prov1*100&&ramdom<=(prov2+prov1)*100){
            ramdom=2;
        }else if(ramdom>(prov2+prov1)*100&&ramdom<=(prov3+prov2+prov1)*100){
            ramdom=1;
        }else if(ramdom>(prov3+prov2+prov1)*100&&ramdom<=(prov4+prov3+prov2+prov1)*100){
            ramdom=0;
        }
        return (int)ramdom;
    }
    
    
}
