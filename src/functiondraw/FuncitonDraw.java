package functiondraw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * 一个绘制函数的 swing 程序
 * @author 朱素海
 *
 */
public class FuncitonDraw  extends JFrame{

	
	
	
	MyPanel mp;
	 JPanel pl = new JPanel();
	 JPanel pl1 = new JPanel(),
	     pl2 = new JPanel(),
	     pl3 = new JPanel(),
	     pl4 = new JPanel();
	 JRadioButton rb1,rb2;
	 ButtonGroup bg = new ButtonGroup();
	 JTextField tf = new JTextField(16);
	 String[] s = {"y = sin(x)", "y = cos(x)", "y = tan(x)", 
	      "y = pow(x, 2)", "y = pow(x, 3)", "y = log(x)",
	      "y = pow(2, x)", "y = sqrt(x)", "r = a(sita)"};
	 JComboBox cb;
	 JButton bn1 = new JButton("变宽"),
	         bn2 = new JButton("变窄"),
	         bn3 = new JButton("拉长"),
	         bn4 = new JButton("压短"),
	         bn = new JButton("绘图"),
	         exit = new JButton("退出"),
	         bn5 = new JButton("左移"),
	         bn6 = new JButton("右移"),
	         bn7 = new JButton("上移"),
	         bn8 = new JButton("下移");
	 
	 public FuncitonDraw()
	 {
	  mp = new MyPanel(this);
	  pl1.setLayout(new GridLayout(1, 2));
	  pl2.setLayout(new GridLayout(1, 2));
	  pl3.setLayout(new GridLayout(1, 2));
	  pl4.setLayout(new GridLayout(1, 2));
	  pl1.add(bn1); bn1.setEnabled(false);
	  pl1.add(bn2); bn2.setEnabled(false);
	  pl2.add(bn3); bn3.setEnabled(false);
	  pl2.add(bn4); bn4.setEnabled(false);
	  pl3.add(bn5); bn5.setEnabled(false);
	  pl3.add(bn6); bn6.setEnabled(false);
	  pl4.add(bn7); bn7.setEnabled(false);
	  pl4.add(bn8); bn8.setEnabled(false);
	  pl.setLayout(new GridLayout(20, 1));
	  rb1 = new JRadioButton("输入函数");
	  rb2 = new JRadioButton("选择已有函数");
	  rb2.setSelected(true);
	  tf.setEnabled(false);
	  bg.add(rb1); bg.add(rb2);
	  rb1.addActionListener(mp);
	  rb2.addActionListener(mp);
	  pl.add(rb1);
	  pl.add(tf);
	  pl.add(rb2);
	  cb = new JComboBox(s);
	  pl.add(cb);
	  pl.add(new JLabel());
	  pl.add(pl1); pl.add(pl2);
	  pl.add(pl3); pl.add(pl4);
	  pl.add(bn);
	  pl.add(exit);
	  bn1.addActionListener(mp);
	  bn2.addActionListener(mp);
	  bn3.addActionListener(mp);
	  bn4.addActionListener(mp);
	  bn5.addActionListener(mp);
	  bn6.addActionListener(mp);
	  bn7.addActionListener(mp);
	  bn8.addActionListener(mp);
	  bn.addActionListener(mp);
	  exit.addActionListener(mp);
	  
	  this.setLayout(new BorderLayout());
	  this.add(mp, BorderLayout.CENTER);
	  this.add(pl, BorderLayout.EAST);
	  
	  this.setTitle("平面直角坐标系画图小工具");
	  this.setSize(797, 600 + 37);
	  Dimension dn = Toolkit.getDefaultToolkit().getScreenSize();
	  this.setLocation((dn.width - 797) / 2, (dn.height - 637) / 2);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(3);
	 }
	 
	 public static void main(String[] args)
	 {
	  new FuncitonDraw();
	 }
}
