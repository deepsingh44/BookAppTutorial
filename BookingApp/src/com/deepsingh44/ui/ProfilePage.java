package com.deepsingh44.ui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.deepsingh44.model.User;
import com.deepsingh44.utility.Util;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class ProfilePage extends JInternalFrame {
	private JTextField tfname;
	private JTextField tlastname;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	private User user;

	public ProfilePage(User user) {
		this.user = user;
		setBounds(100, 30, 588, 367);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 572, 337);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(135, 101, 84, 14);
		panel.add(lblFirstName);

		tfname = new JTextField();
		tfname.setBounds(135, 115, 86, 20);
		panel.add(tfname);
		tfname.setColumns(10);

		tlastname = new JTextField();
		tlastname.setColumns(10);
		tlastname.setBounds(273, 115, 86, 20);
		panel.add(tlastname);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(273, 101, 84, 14);
		panel.add(lblLastName);
		
		
		JLabel limage = new JLabel("");
		limage.setBorder(new LineBorder(new Color(0, 0, 0)));
		limage.setBounds(163, 169, 166, 144);
		panel.add(limage);
		

		//set Data in User Interface
		String dir = System.getProperty("user.dir");
		String imagelocation=dir+File.separator+"profileimages"+File.separator+user.getImage();
		tfname.setText(user.getFirstname());
		tlastname.setText(user.getLastname());
		limage.setIcon(Util.resize(new ImageIcon(imagelocation), 166, 144));
		
	}
}
