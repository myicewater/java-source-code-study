package functiondraw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener,MouseMotionListener
{
	FuncitonDraw ui;
 int flag;
 double h_times;
 int w_times;
 int dx;
 int dy;
 String str;
 Point pt = new Point(0, 0);
 void init()
 {
  flag = -1;
  h_times = Math.PI / 100;
  w_times = 100;
  dx = 300;
  dy = 300;
 }
 public MyPanel(FuncitonDraw ui)
 {
  this.addMouseMotionListener(this);
  init();
  this.ui = ui;
 }
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D)g; 
  drawCoordinate(g2);
  Line2D line;
  g2.setColor(Color.BLUE);
  g2.drawString("(" + (pt.x - 300) + ", " + (300 - pt.y) + ")", pt.x + 20, pt.y + 20);
  switch(flag)
  {
  case 0:
   g2.drawString("y = Asin(Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.sin(getReal_X(i)) * w_times, i + 1, dy - Math.sin(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 1:
   g2.drawString("y = Acos(Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.cos(getReal_X(i)) * w_times, i + 1, dy - Math.cos(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 2:
   g2.drawString("y = Atan(Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.tan(getReal_X(i)) * w_times, i + 1, dy - Math.tan(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 3:
   g2.drawString("y = Apow(Bx + C, 2) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.pow(getReal_X(i), 2) * w_times, i + 1, dy - Math.pow(getReal_X(i + 1), 2) * w_times);
    g2.draw(line);
   }
   break;
  case 4:
   g2.drawString("y = Apow(Bx + C, 3) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.pow(getReal_X(i), 3) * w_times, i + 1, dy - Math.pow(getReal_X(i + 1), 3) * w_times);
    g2.draw(line);
   }
   break;
  case 5:
   g2.drawString("y = Alog(Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.log(getReal_X(i)) * w_times, i + 1, dy - Math.log(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 6:
   g2.drawString("y = Apow(2, Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.pow(2, getReal_X(i)) * w_times, i + 1, dy - Math.pow(2, getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 7:
   g2.drawString("y = Asqrt(Bx + C) + D", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(i, dy - Math.sqrt(getReal_X(i)) * w_times, i + 1, dy - Math.sqrt(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  case 8:
   g2.drawString("y = a(sita)", 105, 60);
   for(double i = 0; i < 600; i += 0.01)
   {
    line = new Line2D.Double(getReal_X(i) * Math.cos(getReal_X(i)), dy - getReal_X(i) * Math.sin(getReal_X(i)) * w_times, getReal_X(i) * Math.cos(getReal_X(i + 1)), dy - getReal_X(i) * Math.sin(getReal_X(i + 1)) * w_times);
    g2.draw(line);
   }
   break;
  }
  if(flag != -1)
  {
   g2.drawString("A = " + w_times, 105, 90);
   g2.drawString("B= " + h_times, 105, 120);
   g2.drawString("C= " + (300 - dx), 105, 150);
   g2.drawString("D= " + (300 - dy), 105, 180);
  }
 }
 private double getReal_X(double x)
 {
  return (x - dx) * h_times;
 }
 private void drawCoordinate(Graphics2D g2)
 {
  int len = 20;
  Line2D line;
  for(int i = 0; i <= 600 / len; i++)
  {
   g2.setColor(Color.PINK.darker());
   if(i == 300 / len)
    g2.setColor(Color.RED);
   else;
   line = new Line2D.Double(0, i * len, 600, i * len);
   g2.draw(line);
   line = new Line2D.Double(i * len, 0, i * len, 600);
   g2.draw(line);
  }
  drawPoint(g2, 300, 300); 
 }
 private void drawPoint(Graphics2D g2, double x, double y)
 {
  g2.setColor(Color.YELLOW);
  Ellipse2D circle = new Ellipse2D.Double(x - 2, y - 2, 4, 4);
  g2.fill(circle);
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource() == ui.rb1)
  {
   ui.tf.setEnabled(true);
   ui.cb.setEnabled(false);
   flag = -1;
  }
  if(e.getSource() == ui.rb2)
  {
   ui.tf.setEnabled(false);
   ui.cb.setEnabled(true);
  }
  if(e.getSource() == ui.bn1)
  {
   h_times /= 1.1;
  }
  if(e.getSource() == ui.bn2)
  {
   h_times *= 1.1;
  }
  if(e.getSource() == ui.bn3)
  {
//   ui.bn4.setEnabled(true);
   w_times += 10;
//   if(w_times >= 300)
//   ui.bn3.setEnabled(false);
  }
  if(e.getSource() == ui.bn4)
  {
//   ui.bn3.setEnabled(true);
   w_times -= 10;
//   if(w_times <= 0)
//   ui.bn4.setEnabled(false);
  }
  if(e.getSource() == ui.bn5)
  {
   dx -= 10;
  }
  if(e.getSource() == ui.bn6)
  {
   dx += 10;
  }
  if(e.getSource() == ui.bn7)
  {
//   ui.bn8.setEnabled(true);
   dy -= 10;
//   if(dy <= 0)
//   ui.bn7.setEnabled(false);
  }
  if(e.getSource() == ui.bn8)
  {
//   ui.bn7.setEnabled(true);
   dy += 10;
//   if(dy >= 600)
//   ui.bn8.setEnabled(false);
  }
  if(e.getSource() == ui.bn)
  {
   if(ui.tf.isEnabled() == true)
   {
    str = ui.tf.getText();
    if(str == null || str.length() == 0)
    {
     ui.bn1.setEnabled(false);
     ui.bn2.setEnabled(false);
     ui.bn3.setEnabled(false);
     ui.bn4.setEnabled(false);
     ui.bn5.setEnabled(false);
     ui.bn6.setEnabled(false);
     ui.bn7.setEnabled(false);
     ui.bn8.setEnabled(false);
     JOptionPane.showMessageDialog(this, "请输入函数表达式 !");
     return;
    }
   }else flag = -2;
   ui.bn1.setEnabled(true);
   ui.bn2.setEnabled(true);
   ui.bn3.setEnabled(true);
   ui.bn4.setEnabled(true);
   ui.bn5.setEnabled(true);
   ui.bn6.setEnabled(true);
   ui.bn7.setEnabled(true);
   ui.bn8.setEnabled(true);
   init();
   if(ui.cb.isEnabled() == true)
   {
    flag = ui.cb.getSelectedIndex();
   }
  }
  if(e.getSource() == ui.exit)
   System.exit(0);
  repaint();
 }
 public void mouseDragged(MouseEvent arg0)
 {
 }
 public void mouseMoved(MouseEvent e)
 {
  pt = e.getPoint();
  repaint();  
 }
}