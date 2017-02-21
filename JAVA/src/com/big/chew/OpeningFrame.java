/*
 * TO-DO:
 * 
 * Finish Add_New_Recipe button Logic
 * 		*Tentative 
 * Implement View Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java
 * Implement Edit Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java
 * Implement Search Recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java. 
 * Implement Delete recipe button logic to display desired frame
 * 		*Need to create rough draft of UI then implement it in Java.
 * Create Menu system for the application.
 * 		*Brainstorm what items should go in the menu bar and would be beneficial to the application. 
 * 
 * John J. Garza
 * 2/14/2017
 */

package com.big.chew;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Class that generates the first window of the application that generates the
 * recipe table and buttons to interact with the database.
 * 
 * @author John J. Garza
 *
 */
public class OpeningFrame extends JFrame {
	private static final int PAD = 30;
	private static final Dimension TABLE_DIM = new Dimension(800, 500);
	private static final Font TABLE_FONT = new Font("Arial", Font.BOLD, 18);
	private static final int TABLE_CELL_HEIGHT = 20;

	private RecipeDB rdb = new RecipeDB();

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

		table = generateTable();

		pane = new JScrollPane();
		pane.setViewportView(table);
		table.setPreferredSize(TABLE_DIM);
		pane.setBounds(150, 250, 1200, 500);
		this.add(pane);

		// Setting up buttons to interact with the data
		viewRecipe = new JButton("View Recipe");
		viewRecipe.setBounds(350, 760, 150, 25);
		this.add(viewRecipe);
		viewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("View Recipe Button Pressed");
			}
		});

		addNewRecipe = new JButton("Add New Recipe");
		addNewRecipe.setBounds(510, 760, 150, 25);
		this.add(addNewRecipe);
		addNewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Add_New_Recipe addNewRecipeFrame = new Add_New_Recipe(OpeningFrame.this, rdb);
				addNewRecipeFrame.getUI(true);
				OpeningFrame.this.getUI(false);
			}
		});

		editRecipe = new JButton("Edit Recipe");
		editRecipe.setBounds(670, 760, 150, 25);
		this.add(editRecipe);
		editRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Edit Recipe Button Pressed");
			}
		});

		searchRecipe = new JButton("Search Recipes");
		searchRecipe.setBounds(830, 760, 150, 25);
		this.add(searchRecipe);
		searchRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Search Recipes Button Pressed");
			}
		});

		deleteRecipe = new JButton("Delete Recipe");
		deleteRecipe.setBounds(990, 760, 150, 25);
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
	}

	/**
	 * Method that generates a new default table model and then populates it
	 * using the RecipeDB.getAllRecipeTableData() method
	 * 
	 * @return Recipe Table to be added to the parent object.
	 * @see RecipeDB
	 */
	public JTable generateTable() {
		final Class[] columnClass = new Class[] { String.class, String.class, Integer.class };

		Vector<String> columns = new Vector<String>(3);
		columns.add("Recipe");
		columns.add("Rating");
		columns.add("Date Added");
		Vector<Vector<Object>> data = rdb.getAllRecipeTableData();

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

		JTable newTable = new JTable(model);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		newTable.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		newTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		newTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		newTable.setFont(TABLE_FONT);
		newTable.setRowHeight(TABLE_CELL_HEIGHT);

		return newTable;

	}
	
	public void updateTable(){
		table = generateTable();
		pane.setViewportView(table);
	}
	
	public void getUI(boolean visable){
		this.setVisible(visable);
	}

}
