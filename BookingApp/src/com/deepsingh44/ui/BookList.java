package com.deepsingh44.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookList extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
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
	public BookList() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Book List");
		setBounds(100, 30, 588, 367);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		String[] cols = { "ID", "TITLE", "PRICE", "AUTHOR", "STATUS" };
		DefaultTableModel dt = new DefaultTableModel(cols, 0);

		table = new JTable(dt) {
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return Float.class;
				case 3:
					return String.class;
				default:
					return Boolean.class;
				}
			}
		};

		table.getTableHeader().setBackground(Color.green);
		table.getTableHeader().setForeground(Color.WHITE);
		// table.getTableHeader().setFont(new Font("",Font.BOLD,20));
		// table.setForeground(new Color(255, 255, 255));
		// table.setBackground(new Color(153, 0, 0));

		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(56, 117, 460, 197);
		panel.add(jp);

		for (int i = 1; i <= 50; i++) {
			DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
			dt1.addRow(new Object[] { i, "title" + i, i, "author" + i });
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println(table.getSelectedRow());
				/*
				 * DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
				 * System.out.println(dt1.getValueAt(table.getSelectedRow(), 0));
				 * System.out.println(dt1.getValueAt(table.getSelectedRow(), 1));
				 * System.out.println(dt1.getValueAt(table.getSelectedRow(), 2));
				 * System.out.println(dt1.getValueAt(table.getSelectedRow(), 3));
				 */

				// remove seleted row
				/*
				 * DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
				 * dt1.removeRow(table.getSelectedRow());
				 */
			}
		});
	}
}
