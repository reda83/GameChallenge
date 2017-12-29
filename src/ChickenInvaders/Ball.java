/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenInvaders;

import java.awt.Color;

/**
 *
 * @author Reda
 */
public class Ball {
     public int x,y;
    public int speedy;
    public Color CurrentColor;
    public Ball(int x,int y,int speedy,Color color)
    {
        this.x=x;
        this.y=y;
        this.speedy=speedy;
        this.CurrentColor=color;
    }
    
    public Ball()
    {
    x=0;
        y=0;
        speedy=1;
        CurrentColor=Color.GREEN;
    }
    public  void move(int width)
    {
        y+=speedy;
        if (y+100>width)
        {
            speedy= -speedy;
        }
        if (y<0)
        {
            speedy= -speedy;
        }
    }
    
}
