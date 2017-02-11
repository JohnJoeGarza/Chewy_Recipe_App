package com.big.chew;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * To-DO:
 * Add Submit button logic:
 * 		*Need to use getText() methods to process recipe text.
 * 		*Need to implement database logic to store new recipe
 * 		*Need to switch back OpeningFrame after addition of recipe is complete and need to update table on said frame. 
 * 		
 * John J. Garza
 * 2/9/2017
*/




public class Add_New_Recipe extends JFrame {
	
	private Font jLabelFont = new Font("Calibri", Font.BOLD, 20);
	private Font inputTextFont =  new Font("Calibri", Font.PLAIN, 15);
	
	public Add_New_Recipe(JFrame parent){
		
		JFrame parentFrame = parent;
		this.setTitle("Add New Recipe");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);
		this.setLayout(new BorderLayout());
		//this.setLayout(new GridBagLayout());
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		gbc.weightx = 1;
		gbc.weighty = 0.0;
		
		// Setting up the GUI background image
		ImageIcon iconFood = new ImageIcon(getClass().getResource("/resources/buffet3.jpg"));
		JLabel jlbackgroundImage = new JLabel(iconFood);
		gbc.gridx = 13;
		gbc.gridy = 0;
		//gbc.ipadx = 300;
		
		this.add(jlbackgroundImage, BorderLayout.PAGE_START);
		
		
		JLabel recipeName = new JLabel("Recipe Name:");
		recipeName.setFont(jLabelFont);
		gbc.ipadx = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pane.add(recipeName, gbc);
		
		JLabel recipeRating = new JLabel("Recipe Rating:");
		recipeRating.setFont(jLabelFont);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pane.add(recipeRating, gbc);
		
		JLabel recipeIngredients = new JLabel("Ingredients:");
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		recipeIngredients.setFont(jLabelFont);
		gbc.gridx = 0;
		gbc.gridy = 2;
		pane.add(recipeIngredients, gbc);
		
		JLabel recipeInstructions = new JLabel("Instructions:");
		recipeInstructions.setFont(jLabelFont);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		pane.add(recipeInstructions, gbc);
		
		TextField txtRecipeName = new TextField(30);
		txtRecipeName.setFont(inputTextFont);
		gbc.ipadx = 200;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 8;
		pane.add(txtRecipeName, gbc);
		
		
		TextField txtRecipeRating = new TextField(30);
		txtRecipeRating.setFont(inputTextFont);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 8;
		pane.add(txtRecipeRating, gbc);
		
		
		TextArea txtRecipeIngredients = new TextArea();
		txtRecipeIngredients.setFont(inputTextFont);
		gbc.ipady = 100;
		gbc.gridwidth = 8;
		gbc.gridx = 1;
		gbc.gridy = 2;
		pane.add(txtRecipeIngredients, gbc);
		
		TextArea txtRecipeInstructions = new TextArea();
		txtRecipeInstructions.setFont(inputTextFont);
		gbc.gridwidth = 8;
		gbc.gridx = 1;
		gbc.gridy = 3;
		pane.add(txtRecipeInstructions, gbc);
				
		JButton btnSubmit = new JButton("Submit");
		gbc.weightx = 1;
		gbc.ipady = 4;
		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
		pane.add(btnSubmit, gbc);
		
		JButton btnCancel = new JButton("Cancel");
		gbc.ipady = 4;
		gbc.gridx = 7;
		gbc.gridy = 4;
		//gbc.anchor = GridBagConstraints.EAST;
        //gbc.fill = GridBagConstraints.NONE;
		pane.add(btnCancel, gbc);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				parentFrame.setVisible(true);
				dispose();
			}
		});
		
		//gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy =4;
		
		pane.add(new JLabel(" "), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 4;
		pane.add(new JLabel(" "), gbc);
		
		this.add(pane);
		this.pack();
		this.setVisible(true);

		
	}

}
