/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenInvaders;

import java.awt.Point;

/**
 *
 * @author Reda
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public Bullet Rocket2=new Bullet();
    public int speed;
    public int Live=3;
    boolean BlueTank2visible=true;
    boolean BlueTank1visible=true;
    public int score=0;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="E:\\Work\\OOP\\Bullettt.png";
        Rocket2.imgPath="E:\\Work\\OOP\\Bullettt.png";
    }

    void mover() {
        if(this.pos.x<460){
        this.pos.x+=speed;
        }
    }
      void movel() {
          if(this.pos.x>0){
        this.pos.x-=speed;
          }
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+50;
        Rocket.pos.y=this.pos.y-92;
        Rocket2.pos.x=this.pos.x+50;
        Rocket2.pos.y=this.pos.y-92;
        Thread t1=new Thread (Rocket);
        Thread t2=new Thread (Rocket2);
        t1.start();
        t2.start();
    }
}
