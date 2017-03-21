/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Pablo
 */
public class Helicoptero extends Ellipse2D.Double{
    
     Color colorHelicoptero;
     int yVelocidad = -2;
     Image helicopterox;
     int radio;
    
      
     
    public Helicoptero(int _radio){
        super(100, 100, _radio, _radio);
        
        radio = _radio;
        precargaImagenes();
}
    public void recolocar(){
       
    }
        
    public void mueve(Graphics2D g2){
        this.y = this.y - yVelocidad;
//        g2.drawImage( helicoptero);
        //pongo un tope para que no se salga por el techo
        if (this.y < 0) {
            this.y = 0;
            yVelocidad = -2;
        }
        g2.drawImage(helicopterox, (int)getX(), (int)getY(), null);
        
        yVelocidad -= 1;
        if (yVelocidad < -2){
            yVelocidad = -3;
        }
    }
    public boolean chequeaColision(Columna c){
    
    return ( this.intersects(c.capitel) || this.intersects(c.base));
    }
      public boolean chequeaColision2(Obstaculo o){
    
    return (this.intersects(o.obstaculo));
    }
      
      
      private void precargaImagenes(){
        helicopterox = (new ImageIcon(new ImageIcon(
                getClass().getResource("/imagenes/Transport-Helicopter-icon.png"))
                .getImage().getScaledInstance(radio,radio,Image.SCALE_DEFAULT)))
                .getImage();
         
                
    }

//NI IDEA
//public static boolean testIntersection(Shape shapeA, Shape shapeB) {
//   Area areaA = new Area(shapeA);
//   areaA.intersect(new Area(shapeB));
//   return !areaA.isEmpty();
//    }
    
//ANTIGUO CODIGO    
//    public boolean chequeaColision(Columna c){
//        Area areaHelicoptero = new Area(this);
//        Area areaRectangulo = new Area(c.columnaChoque);
//        
//        
//        boolean choca = true;
//        areaHelicoptero.intersect(areaRectangulo);
//       
//        if (areaHelicoptero.isEmpty()){
//            choca = false;
//        }
//        return (this.intersects(c.capitel) || 
//                this.intersects(c.base) ||
//                choca
//                );
//    }
}