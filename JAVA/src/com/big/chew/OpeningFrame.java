/*
 * TO-DO:
 * Finish Add_New_Recipe button Logic
 * Implement View Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java
 * Implement Edit Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java
 * Implement Search Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java. 
 * Implement Delete recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java.
 * Create Menu system for the app.
 * 		*Brainstorm what items should go in the menu bar and would be beneficial to the application. 
 * 
 * John J. Garza
 * 2/9/2017
 */

package com.big.chew;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class OpeningFrame extends JFrame {
	private static final int PAD = 30;
	private static final Dimension tableDim = new Dimension(800,500);
	
	private JButton viewRecipe;
	private JButton addNewRecipe;
	private JButton editRecipe;
	private JButton searchRecipe;
	private JButton deleteRecipe;
	private JTable table;
	private JScrollPane pane;
	private DefaultTableModel model;

	public OpeningFrame() {
		this.setTitle("Chewy Recipe Application");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);

		int shift = 150;

		// Table
		// Logic---------------------------------------------------------------------------
		final Class[] columnClass = new Class[] { String.class, String.class, Integer.class};
		
		//Currently only holding test values for the table temporarily 
		String[] columns = new String[] {"Recipe", "Rating", "Date Added"};
		Object[][] data = new Object[][] {	
			{"Test" , 1, "1/1/1"},
			{"Test2", 2, "1/2/1"},
			{"Test3", 3, "1/2/3"}
		};

		// create table model with data
		model = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClass[columnIndex];
			}
		};
		
		table = new JTable(model);
		
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		pane = new JScrollPane();
		pane.setViewportView(table);
		table.setPreferredSize(tableDim);
		pane.setBounds(150, 250, 1200, 500);
		this.add(pane);

		// Setting up buttons to interact with the data
		viewRecipe = new JButton("View Recipe");
		viewRecipe.setBounds(200 + shift, 760, 150, 25);
		this.add(viewRecipe);
		viewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("View Recipe Button Pressed");
			}
		});

		addNewRecipe = new JButton("Add New Recipe");
		addNewRecipe.setBounds(360 + shift, 760, 150, 25);
		this.add(addNewRecipe);
		addNewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Add_New_Recipe addNewRecipeFrame = new Add_New_Recipe(OpeningFrame.this);
				dispose();
			}
		});

		editRecipe = new JButton("Edit Recipe");
		editRecipe.setBounds(520 + shift, 760, 150, 25);
		this.add(editRecipe);
		editRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Edit Recipe Button Pressed");
			}
		});

		searchRecipe = new JButton("Search Recipes");
		searchRecipe.setBounds(680 + shift, 760, 150, 25);
		this.add(searchRecipe);
		searchRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Search Recipes Button Pressed");
			}
		});

		deleteRecipe = new JButton("Delete Recipe");
		deleteRecipe.setBounds(840 + shift, 760, 150, 25);
		this.add(deleteRecipe);
		deleteRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Delete Recipe Button Pressed");
			}
		});

		// Setting up the GUI background image
		ImageIcon iconFood = new ImageIcon(getClass().getResource("/resources/foodback.jpg"));
		JLabel jlbackgroundImage = new JLabel(iconFood);
		jlbackgroundImage.setBounds(0, 0, 1500, 1000);
		this.add(jlbackgroundImage);
		this.setVisible(true);

	}

}
