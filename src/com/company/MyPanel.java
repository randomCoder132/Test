package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyPanel extends JPanel implements ActionListener {

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;

  private BufferedImage img;
  private Timer timer;
  private JButton button;
  private ArrayList<Ball> Balls = new ArrayList<Ball>();

  public MyPanel(){
      loadImage();
      button = new JButton();// creates the button
      button.setBounds(200,100,300,200);
      button.addActionListener(this);

      this.add(button); // adds the button to the panel
      this.setPreferredSize(new Dimension(PANEL_HEIGHT,PANEL_WIDTH));
      this.setBackground(Color.white);
      timer = new Timer(10, this);// starting the timer
      timer.start();
  }
  public void loadImage(){// importing the image
      try {
          img = ImageIO.read(new File("./Pic/download.jpg"));
      }
      catch(IOException e){};
  }

  public void paint(Graphics g){ // getting the graphics object
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      for(Ball i: Balls){
          i.draw(g2d);
      }
  }
  public void actionPerformed(ActionEvent e){ // checking for logic and updating the program
      if(e.getSource() == button){ // adding a new ball when the button is pressed
          int xPos = (int)(Math.random()*401);
          System.out.println(xPos);
          Balls.add(new Ball(xPos,0,img));
      }//updating the ball position
      for(Ball i: Balls){
        i.updatePosition();
      }
      repaint();
  }

}
