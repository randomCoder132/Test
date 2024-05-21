package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Ball {
    private Ellipse2D circle;
    private  double yVelocity = 2;
    private double x ;
    private  double y ;
    private  double accel = 0.3;
    private  BufferedImage img;

    public Ball(int x1, int y1, BufferedImage img){ // constructor
        this.img = img;
        x = x1;
        y = y1;
        circle = new Ellipse2D.Double(x,y,100,100);
    }
    public void updatePosition(){ // updates the position of the ball and image
        yVelocity += accel;
        if(y >= 300){
            yVelocity = -10;
            if(yVelocity <= 0){
                yVelocity += 0.5;
            }

        }
        y = y + yVelocity;
        circle.setFrame(x,y,100,100);
    }
    public void draw(Graphics2D g2d){ // draws the graphics
        g2d.drawImage(img,(int)x,(int)y,100,100,null);
        g2d.draw(circle);
    }
}
