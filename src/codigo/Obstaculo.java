/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author Pablo
 */
public class Obstaculo {
    
    Rectangle2D capitel, base, obstaculo;
    int hueco =130;
    int altura_columna = 200;
    int ancho_columna = 80;
    private int ancho_pantalla;
    Image col_abajo, col_arriba, col_medio;
    Rectangle2D columnaChoque;
Random aleatorio = new Random();    
    

  public Obstaculo (int _ancho, int _anchoPantalla){
       
        
      int desplazamientoMas = aleatorio.nextInt(200);
      int desplazamientoMenos= aleatorio.nextInt(200);
        obstaculo = new Rectangle2D.Double(_ancho, altura_columna + desplazamientoMas -desplazamientoMenos, 40, 40);
        
        ancho_pantalla = _anchoPantalla;
        
    }
  
    public void mueve(Graphics2D g2){
        mueveColumna();
        //mueveColumna(base);

        g2.setColor(Color.RED);
        

        
        //g2.fill(base);
        
       
        g2.drawImage(col_medio, (int)obstaculo.getX(), (int)obstaculo.getY(), null);
        g2.setColor(Color.GREEN);
        g2.fill(obstaculo);
        
        
        
    }
    private void mueveColumna(){
        if (obstaculo.getX() + ancho_columna < 0){
            
            int desplazamientoMas = aleatorio.nextInt(200);
      int desplazamientoMenos= aleatorio.nextInt(200);
            obstaculo.setFrame(ancho_pantalla,
                               altura_columna - desplazamientoMenos + desplazamientoMas, 
                               obstaculo.getWidth(), 
                               obstaculo.getHeight());
          
        }
        else{
            obstaculo.setFrame(obstaculo.getX()-5, obstaculo.getY(),obstaculo.getWidth(), obstaculo.getHeight());
        }
    }}