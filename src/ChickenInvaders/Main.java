/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenInvaders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Reda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Ball>Balls=new ArrayList<Ball>();
    public static void main(String[] args) {
        // TODO code application logic here
        
        JOptionPane.showMessageDialog(null, "Player1: Left arrow to move left , Right Arrow to move Right , Space to shot, M to Respawn\n You got 3 Lives if the ball hits you you will lose 1 Live \n if your live Become 0 you will not be able to respawn");
        JOptionPane.showMessageDialog(null, "Player2: A to move left , D to move Right , F to shot, R to Respawn\n You got 3 Lives if the ball hits you you will lose 1 Live \n if your live Become 0 you will not be able to respawn");
        JOptionPane.showMessageDialog(null,"Press ok to Start :D have fun");
        JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        MovingBalls mb=new MovingBalls();
        Balls.add(new Ball(60,0,10,Color.BLACK));
        Balls.add(new Ball(150,0,10,Color.ORANGE));
        Balls.add(new Ball(250,0,10,Color.red));
        Balls.add(new Ball(350,0,10,Color.CYAN));
        Balls.add(new Ball(450,0,10,Color.DARK_GRAY));
        Balls.add(new Ball(530,0,10,Color.YELLOW));
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
         
        
        
    }
    
}
