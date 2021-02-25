package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.utility.Util;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class Splash extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					Splash frame = new Splash();
					frame.setVisible(true);
					
					for(int i=0;i<=100;i++) {
						frame.progressBar.setValue(i);
						Thread.sleep(100);
					}
					
					if(frame.progressBar.getValue()==100) {
						new RegisterPage().setVisible(true);
						frame.dispose();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(Util.resize(new ImageIcon(Splash.class.getResource("/com/deepsingh44/images/back.jpg")), 450, 300));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		contentPane.add(progressBar, BorderLayout.SOUTH);
	}

}
