package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import com.deepsingh44.model.User;
import com.deepsingh44.service.UserService;
import com.deepsingh44.utility.Util;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfirstname;
	private JTextField tlastname;
	private JTextField temail;
	private JTextField tprofile;
	private JTextField tloginemail;
	private JPasswordField tpassword;
	private JPasswordField tloginpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int count = 1;

	public RegisterPage() {
		// setUndecorated(true);
		setTitle("Book Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 451);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 51));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 656, 61);
		panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Email Here");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Serif", Font.BOLD, 12));
		label.setBounds(219, 7, 103, 14);
		panel.add(label);

		tloginemail = new JTextField();
		tloginemail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tloginemail.setColumns(10);
		tloginemail.setBounds(219, 21, 144, 30);
		panel.add(tloginemail);

		tloginpass = new JPasswordField();
		tloginpass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tloginpass.setBounds(374, 21, 144, 30);
		panel.add(tloginpass);

		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Serif", Font.BOLD, 12));
		label_1.setBounds(373, 7, 103, 14);
		panel.add(label_1);

		JButton btnLogin = new JButton("Login");

		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Serif", Font.BOLD, 12));
		btnLogin.setBackground(new Color(0, 102, 153));
		btnLogin.setBounds(528, 21, 118, 30);
		panel.add(btnLogin);

		JLabel lblCanteenApp = new JLabel("Book Shop", JLabel.CENTER);
		lblCanteenApp.setForeground(new Color(255, 255, 255));
		lblCanteenApp.setFont(new Font("Serif", Font.BOLD, 20));
		lblCanteenApp.setBounds(10, 7, 129, 45);
		panel.add(lblCanteenApp);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 83, 271, 318);
		panel_1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.6f));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel.setIcon(Util.resize(
				new ImageIcon(RegisterPage.class.getResource("/com/deepsingh44/images/book_image.jpeg")), 251, 192));
		lblNewLabel.setBounds(10, 11, 251, 192);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(
				"<html>Framework is a predefine architecture where we can manipulate the data not the architecture.Framework is a predefine architecture where we can manipulate the data not the architecture.</html>");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(10, 214, 251, 93);
		panel_1.add(lblNewLabel_2);

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				lblNewLabel.setIcon(Util.resize(
						new ImageIcon(RegisterPage.class.getResource("/com/deepsingh44/images/book" + count + ".jpg")),
						251, 192));
				if (count == 3) {
					count = 1;
				} else {
					count++;
				}
			}
		}, 500, 1000);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 102));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(291, 83, 375, 318);
		panel_2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblRegisterDetail = new JLabel("Register Detail", JLabel.CENTER);
		lblRegisterDetail.setForeground(new Color(255, 255, 255));
		lblRegisterDetail.setFont(new Font("Serif", Font.BOLD, 15));
		lblRegisterDetail.setBounds(106, 22, 173, 30);
		panel_2.add(lblRegisterDetail);

		tfirstname = new JTextField();
		tfirstname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfirstname.setBounds(27, 85, 144, 30);
		panel_2.add(tfirstname);
		tfirstname.setColumns(10);

		tlastname = new JTextField();
		tlastname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tlastname.setColumns(10);
		tlastname.setBounds(199, 85, 144, 30);
		panel_2.add(tlastname);

		temail = new JTextField();
		temail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		temail.setColumns(10);
		temail.setBounds(27, 146, 144, 30);
		panel_2.add(temail);

		tprofile = new JTextField();
		tprofile.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tprofile.setEnabled(false);
		tprofile.setColumns(10);
		tprofile.setBounds(27, 210, 227, 30);
		panel_2.add(tprofile);

		JButton btnNewButton = new JButton("Browse");

		btnNewButton.setFont(new Font("Serif", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(267, 210, 76, 30);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Submit Here");

		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 102, 153));
		btnNewButton_1.setBounds(82, 273, 197, 30);
		panel_2.add(btnNewButton_1);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Serif", Font.BOLD, 12));
		lblFirstName.setBounds(27, 69, 103, 14);
		panel_2.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Serif", Font.BOLD, 12));
		lblLastName.setBounds(198, 69, 103, 14);
		panel_2.add(lblLastName);

		JLabel lblEmailHere = new JLabel("Email Here");
		lblEmailHere.setForeground(new Color(255, 255, 255));
		lblEmailHere.setFont(new Font("Serif", Font.BOLD, 12));
		lblEmailHere.setBounds(27, 131, 103, 14);
		panel_2.add(lblEmailHere);

		JLabel lblMobile = new JLabel("Password");
		lblMobile.setForeground(new Color(255, 255, 255));
		lblMobile.setFont(new Font("Serif", Font.BOLD, 12));
		lblMobile.setBounds(198, 131, 103, 14);
		panel_2.add(lblMobile);

		JLabel lblProfileImage = new JLabel("Profile Image");
		lblProfileImage.setForeground(new Color(255, 255, 255));
		lblProfileImage.setFont(new Font("Serif", Font.BOLD, 12));
		lblProfileImage.setBounds(27, 196, 103, 14);
		panel_2.add(lblProfileImage);

		tpassword = new JPasswordField();
		tpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpassword.setBounds(199, 146, 144, 30);
		panel_2.add(tpassword);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(Util.resize(
				new ImageIcon(RegisterPage.class.getResource("/com/deepsingh44/images/book_image.jpeg")), 676, 412));
		lblNewLabel_1.setBounds(0, 0, 676, 412);
		contentPane.add(lblNewLabel_1);

		// Event task always write in last section
		// submit code here
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validRegistration()) { // final code here // Bind all data in model class
					User user = new User(first, last, regemail, regpass, image);
					Util.normalMessage(RegisterPage.this, UserService.getUserService().register(user));
				}

			}
		});

		// browse image code here
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				int i = file.showOpenDialog(RegisterPage.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File myfile = file.getSelectedFile();
					
					String dir = System.getProperty("user.dir");
					File folder = new File(dir, "profileimages");
					folder.mkdir();
					image1 = temail.getText() + ".jpg";
					tprofile.setText(image1);
					File userImage = new File(folder, image1);
					try {
						userImage.createNewFile();
						FileInputStream fi = new FileInputStream(myfile.getAbsolutePath());
						FileOutputStream fo = new FileOutputStream(userImage);
						int k = 0;
						while ((k = fi.read()) != -1) {
							fo.write(k);
						}
						fo.close();
						fi.close();
						System.out.println(userImage.getAbsolutePath());
					} catch (Exception e2) {
						System.out.println(e2);
					}

				}
			}
		});

		// login code here
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validLogin()) {
					// login final code here
					new HomePage().setVisible(true);
					dispose();
				}
			}
		});
	}
	String image1 = "";
	private String logemail, logpass;

	private boolean validLogin() {
		logemail = tloginemail.getText();
		logpass = String.valueOf(tloginpass.getPassword());

		if (logemail.equals("")) {
			Util.warningMessage(this, "please enter email");
			tloginemail.requestFocus();
			return false;
		} else if (!Util.emailValidation(logemail)) {
			Util.warningMessage(this, "please enter valid email");
			tloginemail.requestFocus();
			return false;
		} else if (logpass.equals("")) {
			Util.warningMessage(this, "please enter password");
			tloginpass.requestFocus();
			return false;
		} else {
			return true;
		}
	}

	private String first, last, regemail, image, regpass;

	private boolean validRegistration() {
		first = tfirstname.getText();
		last = tlastname.getText();
		regemail = temail.getText();
		image = tprofile.getText();
		regpass = String.valueOf(tpassword.getPassword());

		if (first.equals("")) {
			Util.warningMessage(this, "please enter first name");
			tfirstname.requestFocus();
			return false;
		} else if (last.equals("")) {
			Util.warningMessage(this, "please enter last name");
			tlastname.requestFocus();
			return false;
		} else if (regemail.equals("")) {
			Util.warningMessage(this, "please enter email");
			temail.requestFocus();
			return false;
		} else if (!Util.emailValidation(regemail)) {
			Util.warningMessage(this, "please enter valid email");
			temail.requestFocus();
			return false;
		} else if (regpass.equals("")) {
			Util.warningMessage(this, "please enter password");
			tpassword.requestFocus();
			return false;
		} else if (image.equals("")) {
			Util.warningMessage(this, "please select profile image");
			tprofile.requestFocus();
			return false;
		} else {
			return true;
		}
	}
}
