/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenInvaders;

import static ChickenInvaders.Main.Balls;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Reda
 */
public class MovingBalls extends JPanel implements Runnable{

   
   public Tank BlueTank=new Tank("E:\\Work\\OOP\\TankBlueS.jpg");
   public Tank BlueTank2= new Tank("E:\\Work\\OOP\\TankBlueS.jpg");
   private JLabel Score;
   private JLabel Score2;
   private JLabel fasel;
   public MovingBalls()
    {
        Score=new JLabel();
        Score2=new JLabel();
        fasel=new JLabel();
        Score.setText("player1:"+BlueTank.score+"  Lives:"+ BlueTank.Live);
        Score2.setText(" player2:"+BlueTank2.score +"  Lives:"+ BlueTank2.Live);
        fasel.setText(" | ");
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=100;
        BlueTank.pos.y=340;
        BlueTank2.pos.x=450;
        BlueTank2.pos.y=340;
        
        this.addKeyListener(new keylist());
        add(Score);
        add(fasel);
        add(Score2);
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
            
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank2.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_F)
            {
                
                BlueTank2.fireBullet();
            }
           //-------------------------------------------------------------------------------
            if((e.getKeyCode()==KeyEvent.VK_R) && (BlueTank2.BlueTank2visible==true))
            {
            
        BlueTank2.pos.x=450;
        BlueTank2.pos.y=340;
            }
            if((e.getKeyCode()==KeyEvent.VK_M)&& (BlueTank.BlueTank1visible==true))
            {
            
        BlueTank.pos.x=100;
        BlueTank.pos.y=340;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        
         imgtank = ImageIO.read(new File(BlueTank2.ImagePath));
         imgrocket = ImageIO.read(new File(BlueTank2.Rocket2.imgPath));
         
        g.drawImage(imgtank, BlueTank2.pos.x, BlueTank2.pos.y,null);
        g.drawImage(imgrocket, BlueTank2.Rocket.pos.x, BlueTank2.Rocket2.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                BlueTank.score++;
                Score.setText(" player1:"+BlueTank.score+"  Lives: "+ BlueTank.Live);
        
                Balls.remove(OneBall);
                break;
                
            }
              if (BlueTank2.Rocket2.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                BlueTank2.score++;
                
                Score2.setText(" player2:"+BlueTank2.score+"  Lives: "+ BlueTank2.Live);
                Balls.remove(OneBall);
                break;
                
            }
            
            if(BlueTank.pos.distance(OneBall.x,OneBall.y)<=50)
            {
           
                
                BlueTank.Live--;
                Score.setText(" player1:"+BlueTank.score+"   Lives:"+ BlueTank.Live);
                BlueTank.pos.setLocation(1000, 1000);
                if(BlueTank.Live==0)
                {
                JOptionPane.showMessageDialog(null,"Player1 Died");
                BlueTank.BlueTank1visible=false;
                }
            }
                 if(BlueTank2.pos.distance(OneBall.x,OneBall.y)<=50)
            {
                
                
                BlueTank2.Live--;
                Score2.setText(" player2:"+BlueTank2.score+"   Lives:"+ BlueTank2.Live);
                BlueTank2.pos.setLocation(1000, 1000);
                
              if(BlueTank2.Live==0)
                {
                JOptionPane.showMessageDialog(null,"Player2 Died");
                BlueTank2.BlueTank2visible=false;
                }
            
            }
        
        
        }
         
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
       
            
        }    
       
       if(Balls.isEmpty())
       {
       Balls.add(new Ball(60,0,10,Color.BLACK));
        Balls.add(new Ball(150,0,10,Color.ORANGE));
        Balls.add(new Ball(250,0,10,Color.red));
        Balls.add(new Ball(350,0,10,Color.CYAN));
        Balls.add(new Ball(450,0,10,Color.DARK_GRAY));
        Balls.add(new Ball(530,0,10,Color.YELLOW));
       }
        
       if((BlueTank.Live==0) && (BlueTank2.Live==0))
       {
       if(BlueTank.score>BlueTank2.score)
       {
           JOptionPane.showMessageDialog(null, "Player1 Won");
       System.exit(0);
       }
        if(BlueTank.score<BlueTank2.score)
       {
        JOptionPane.showMessageDialog(null, "Player2 Won");
        System.exit(0);
       }
           if(BlueTank.score==BlueTank2.score)
       {
        JOptionPane.showMessageDialog(null, "Draw");
       System.exit(0);
       }
           
       }
       
        //y+=10;
        Thread.sleep(90);
        repaint();
        
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
