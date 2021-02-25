package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import com.deepsingh44.utility.Util;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AddBook extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Add Book");
		setBounds(100, 30, 588, 367);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(10, 11, 552, 315);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel.setBounds(206, 11, 127, 93);
		panel.add(lblNewLabel);

		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setForeground(Color.WHITE);
		lblBookTitle.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookTitle.setBounds(42, 136, 103, 14);
		panel.add(lblBookTitle);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(42, 152, 196, 30);
		panel.add(textField);

		JLabel lblBookAuthor = new JLabel("Book Author");
		lblBookAuthor.setForeground(Color.WHITE);
		lblBookAuthor.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookAuthor.setBounds(287, 136, 103, 14);
		panel.add(lblBookAuthor);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(287, 152, 225, 30);
		panel.add(textField_1);

		JLabel lblBookPrice = new JLabel("Book Price");
		lblBookPrice.setForeground(Color.WHITE);
		lblBookPrice.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookPrice.setBounds(42, 193, 103, 14);
		panel.add(lblBookPrice);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setBounds(42, 209, 196, 30);
		panel.add(textField_2);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(185, 268, 178, 36);
		panel.add(btnAddBook);

		JButton button = new JButton("...");

		button.setForeground(Color.WHITE);
		button.setFont(new Font("Serif", Font.BOLD, 12));
		button.setBackground(new Color(0, 51, 51));
		button.setBounds(483, 208, 33, 30);
		panel.add(button);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBounds(287, 207, 186, 30);
		panel.add(textField_3);

		JLabel lblBookImage = new JLabel("Book Image");
		lblBookImage.setForeground(Color.WHITE);
		lblBookImage.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookImage.setBounds(287, 193, 103, 14);
		panel.add(lblBookImage);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(AddBook.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					lblNewLabel.setIcon(Util.resize(new ImageIcon(file.getAbsolutePath()), 127, 93));
					
				}
			}
		});

	}
}
