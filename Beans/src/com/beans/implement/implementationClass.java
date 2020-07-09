package com.beans.implement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class implementationClass extends JFrame {
	Container pane;
	JEditorPane innerPane;
	JTextField length , breadth, width;
	JLabel len, bre, wid,title, info, info_text;
	JButton predict;
	JTextArea jta;
	String model = "Model Information \n";
	public implementationClass() throws Exception {
		super("Beans Prediction");
		pane  = new Container();
		
		title  =  new JLabel("Bean Predicton Example Using Machine Learning Model (J48)");
		title.setBounds(50,20,600,23);
		title.setFont(new Font("TimesRoman", Font.BOLD | Font.BOLD, 18));
		pane.add(title);
		len = new JLabel("Enter Length :");
		len.setBounds(50,100,100,20);
		pane.add(len);
		length = new JTextField() {{
			 addKeyListener(new KeyAdapter() {
		            public void keyTyped(KeyEvent e) {
		                if (Character.isLetter(e.getKeyChar()))
		                    e.consume();
		            }
		        });
		    }};
		length.setBounds(160,100,200,20);
		pane.add(length);
		
		bre = new JLabel("Enter Breadth :");
		bre.setBounds(50,140,100,20);
		pane.add(bre);
		
		breadth = new JTextField() {{
	        addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                if (Character.isLetter(e.getKeyChar()))
	                    e.consume();
	            }
	        });
	    }};
		breadth.setBounds(160,140,200,20);
		pane.add(breadth);
		
		
		wid = new JLabel("Enter Width :");
		wid.setBounds(50,180,100,20);
		pane.add(wid);
		
		width = new JTextField() {{
			 addKeyListener(new KeyAdapter() {
		            public void keyTyped(KeyEvent e) {
		                if (Character.isLetter(e.getKeyChar()))
		                    e.consume();
		            }
		        });
		    }};
		width.setBounds(160,180,200,20);
		pane.add(width);
		
		predict = new JButton("Make Prediction");
		predict.setBounds(50,220,250,30);
		
		pane.add(predict);
		
		jta = new JTextArea();
		jta.setBackground(Color.black);
		jta.setForeground(Color.white);
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(50,260,310,186);
		pane.add(jsp);
		
		innerPane = new JEditorPane();
		innerPane.setEditable(false);
		innerPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5),
				new LineBorder(Color.decode("#075574"))));
		innerPane.setBounds(420,50,300,400);
		ImageIcon img = new ImageIcon(this.getClass().getResource("images/no_beans.png"));
		ImageIcon img_02 = new ImageIcon(this.getClass().getResource("images/big_drum.png"));
		ImageIcon img_03 = new ImageIcon(this.getClass().getResource("images/milk.png"));
		ImageIcon img_04 = new ImageIcon(this.getClass().getResource("images/oloyin.png"));
		ImageIcon img_05 = new ImageIcon(this.getClass().getResource("images/small_drum.png"));
		JLabel lab = new JLabel(img);
		lab.setSize(200, 300);
		info  = new JLabel("");
		info.setFont(new Font("TimesRoman", Font.BOLD | Font.BOLD, 13));
		
		
		predict.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(width.getText().length() < 0) {
						JOptionPane.showMessageDialog(null, "Empty Fields Detected : Width");
					}else if (length.getText().length() < 0) {
						JOptionPane.showMessageDialog(null, "Empty Fields Detected : length");
					}else if(breadth.getText().length() < 0) {
						JOptionPane.showMessageDialog(null, "Empty Fields Detected : Width");
						
					}else {
						
					new LogInFile(length.getText(),breadth.getText(),width.getText());
					new dataSetClasss().dataClasss(info, jta);
					//System.out.println(model);
					if(info.getText().contentEquals("BIG_DRUM")) {
						lab.setIcon(img_02);
					}else if(info.getText().contentEquals("SMALL_DRUM")) {
						lab.setIcon(img_05);
					}else if(info.getText().contentEquals("oloyin_beans")) {
						lab.setIcon(img_04);
					}else if(info.getText().contentEquals("MILK_BEANS")) {
						lab.setIcon(img_03);
					}
					
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Data Error OR Invalid Inputs!!! ");
					e.printStackTrace();
				}
				
			}
			
		});
		innerPane.setLayout(new BorderLayout());
		innerPane.add(lab, BorderLayout.CENTER);
		innerPane.add(info, BorderLayout.NORTH);
		pane.add(innerPane);
		
		getContentPane().add(pane).setBackground(Color.black);
		setSize(800,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		implementationClass im  = new implementationClass();
		

	}

}
