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
public class Columna {
    
    Rectangle2D capitel, base;
    int hueco =130;
    int altura_columna = 200;
    int ancho_columna = 80;
    private int ancho_pantalla;
    Image col_abajo, col_arriba, col_medio;
    Rectangle2D columnaChoque;
Random aleatorio = new Random();    
    

  public Columna (int _ancho, int _anchoPantalla){
       
        int desplazamiento = aleatorio.nextInt(50);//PORQUE SI LE METES MUCHO DESPLAZAMIENTO AL PRINCIPIO SE DIBUJA MAL
        capitel = new Rectangle2D.Double(_ancho, -desplazamiento-hueco, ancho_columna , altura_columna);
        base = new Rectangle2D.Double(_ancho, 
                                      altura_columna + hueco - desplazamiento, 
                                      ancho_columna, 
                                      altura_columna );
        
        ancho_pantalla = _anchoPantalla;
        
    }
  
    public void mueve(Graphics2D g2){
        mueveColumna();
        //mueveColumna(base);

        g2.setColor(Color.RED);
        

        
        //g2.fill(base);
        
        g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);
        g2.drawImage(col_arriba, (int)capitel.getX(), (int)capitel.getY(), null);
        g2.setColor(Color.GREEN);
        g2.fill(base);
        g2.fill(capitel);
        
        
        
    }
    private void mueveColumna(){
        if (capitel.getX() + ancho_columna < 0){
            int desplazamiento = aleatorio.nextInt(50);
            capitel.setFrame(ancho_pantalla, 
                            -desplazamiento-hueco,
                            capitel.getWidth(), 
                            capitel.getHeight());
            base.setFrame(ancho_pantalla, 
                            altura_columna + hueco - desplazamiento,
                            base.getWidth(), 
                            base.getHeight());
          
        }
        else{
            capitel.setFrame(capitel.getX()-1, capitel.getY(),capitel.getWidth(), capitel.getHeight());
            base.setFrame(base.getX()-1, base.getY(),base.getWidth(), base.getHeight());
        }
    }}