/*
 * To-DO:
 *	Change design so that both ingredients and instructions that have been added to the list
 *	are able to be removed from the list. 
 *
 * John J. Garza
 * 2/20/2017
*/

package com.big.chew;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class that constructs the JFrame window to add a new recipe to the recipe
 * database.
 * 
 * @author johnj
 *
 */
public class Add_New_Recipe extends JFrame {

	private static final Font JLABELFONT = new Font("Calibri", Font.BOLD, 20);
	private static final Font INPUT_TEXT_FONT = new Font("Calibri", Font.PLAIN, 15);
	private static final Font RADIO_BUTTON_TEXT_FONT = new Font("Calibri", Font.BOLD, 20);
	private static final Insets LABEL_INSETS = new Insets(10, 10, 10, 0);
	private static final Insets TEXT_BOX_INSETS = new Insets(10, 0, 10, 10);
	private static final Insets BUTTON_INSETS = new Insets(10, 10, 10, 10);
	private static final Dimension BUTTON_DIMENSION = new Dimension(150, 10);

	private static String rating = "1";
	private static ArrayList<String> ingredientAList = new ArrayList<String>();
	private static ArrayList<String> amountAList = new ArrayList<String>();
	private static ArrayList<String> instrucitonAList = new ArrayList<String>();
	private static int ingredientNumber = 1;
	private static int instructionNumber = 1;

	public Add_New_Recipe(OpeningFrame parent, RecipeDB rdb) {
		this.setTitle("Add New Recipe");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel pane = new JPanel(new GridBagLayout());

		// Setting up the GUI background image
		ImageIcon iconFood = new ImageIcon(getClass().getResource("/resources/buffet3.jpg"));
		JLabel jlbackgroundImage = new JLabel(iconFood);
		this.add(jlbackgroundImage, BorderLayout.PAGE_START);

		JLabel recipeName = new JLabel("Recipe Name:");
		recipeName.setFont(JLABELFONT);
		this.addNewItem(pane, recipeName, 0, 0, 1, 1, GridBagConstraints.WEST, 0, 0, LABEL_INSETS);

		JLabel recipeDescription = new JLabel("Description:");
		recipeDescription.setFont(JLABELFONT);
		this.addNewItem(pane, recipeDescription, 0, 1, 1, 1, GridBagConstraints.NORTHEAST, 0, 0, LABEL_INSETS);

		JLabel recipeRating = new JLabel("Recipe Rating:");
		recipeRating.setFont(JLABELFONT);
		this.addNewItem(pane, recipeRating, 0, 2, 1, 1, GridBagConstraints.NORTHEAST, 0, 0, LABEL_INSETS);

		JLabel recipeIngredients = new JLabel("Ingredients:");
		recipeIngredients.setFont(JLABELFONT);
		this.addNewItem(pane, recipeIngredients, 0, 3, 1, 1, GridBagConstraints.NORTHEAST, 0, 0, LABEL_INSETS);

		JLabel ingredientAmount = new JLabel("Amount:");
		ingredientAmount.setFont(JLABELFONT);
		this.addNewItem(pane, ingredientAmount, 5, 3, 1, 1, GridBagConstraints.CENTER, 0, 0, LABEL_INSETS);

		JLabel recipeInstructions = new JLabel("Instruction:");
		recipeInstructions.setFont(JLABELFONT);
		this.addNewItem(pane, recipeInstructions, 0, 5, 1, 1, GridBagConstraints.FIRST_LINE_END, 0, 0, LABEL_INSETS);
		
		JLabel recipeNotes = new JLabel("Recipe Notes:");
		recipeNotes.setFont(JLABELFONT);
		this.addNewItem(pane, recipeNotes, 0, 7, 1, 1, GridBagConstraints.FIRST_LINE_END, 0, 0, LABEL_INSETS);

		JTextField txtRecipeName = new JTextField(30);
		txtRecipeName.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, txtRecipeName, 1, 0, 8, 1, GridBagConstraints.WEST, 200, 0, TEXT_BOX_INSETS);

		JTextField txtRecipeDescription = new JTextField(30);
		txtRecipeDescription.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, txtRecipeDescription, 1, 1, 8, 1, GridBagConstraints.WEST, 200, 0, TEXT_BOX_INSETS);

		JRadioButton oneButton = new JRadioButton(": 1 ", true);
		JRadioButton twoButton = new JRadioButton(": 2 ");
		JRadioButton threeButton = new JRadioButton(": 3 ");
		JRadioButton fourButton = new JRadioButton(": 4 ");
		JRadioButton fiveButton = new JRadioButton(": 5 ");
		ButtonGroup ratingButtonsGroup = new ButtonGroup();
		Box ratingBox = Box.createHorizontalBox();
		oneButton.setFont(RADIO_BUTTON_TEXT_FONT);
		twoButton.setFont(RADIO_BUTTON_TEXT_FONT);
		threeButton.setFont(RADIO_BUTTON_TEXT_FONT);
		fourButton.setFont(RADIO_BUTTON_TEXT_FONT);
		fiveButton.setFont(RADIO_BUTTON_TEXT_FONT);
		ratingButtonsGroup.add(oneButton);
		ratingButtonsGroup.add(twoButton);
		ratingButtonsGroup.add(threeButton);
		ratingButtonsGroup.add(fourButton);
		ratingButtonsGroup.add(fiveButton);
		ratingBox.add(oneButton);
		ratingBox.add(twoButton);
		ratingBox.add(threeButton);
		ratingBox.add(fourButton);
		ratingBox.add(fiveButton);
		this.addNewItem(pane, ratingBox, 1, 2, 8, 1, GridBagConstraints.FIRST_LINE_START, 200, 0, TEXT_BOX_INSETS);
		oneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setRating("1");
			}
		});

		twoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setRating("2");
			}
		});

		threeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setRating("3");
			}
		});

		fourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setRating("4");
			}
		});

		fiveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setRating("5");
			}
		});

		JTextField txtaddIngredient = new JTextField(40);
		txtaddIngredient.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, txtaddIngredient, 1, 3, 4, 1, GridBagConstraints.WEST, 20, 0, TEXT_BOX_INSETS);

		JTextField txtAmount = new JTextField(20);
		txtAmount.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, txtAmount, 6, 3, 2, 1, GridBagConstraints.WEST, 20, 0, BUTTON_INSETS);

		JTextArea txtRecipeIngredients = new JTextArea();
		txtRecipeIngredients.setFont(INPUT_TEXT_FONT);
		JScrollPane jsp_RecipeIngredients = new JScrollPane(txtRecipeIngredients);
		this.addNewItem(pane, jsp_RecipeIngredients, 1, 4, 8, 1, GridBagConstraints.WEST, 200, 100, TEXT_BOX_INSETS);

		JTextArea txtAddInstruction = new JTextArea();
		txtAddInstruction.setFont(INPUT_TEXT_FONT);
		JScrollPane jspAddInstruction = new JScrollPane(txtAddInstruction);
		this.addNewItem(pane, jspAddInstruction, 1, 5, 7, 1, GridBagConstraints.WEST, 200, 20, TEXT_BOX_INSETS);

		JTextArea txtRecipeInstructions = new JTextArea();
		txtRecipeInstructions.setFont(INPUT_TEXT_FONT);
		JScrollPane jsp_RecipeInstructions = new JScrollPane(txtRecipeInstructions);
		this.addNewItem(pane, jsp_RecipeInstructions, 1, 6, 8, 1, GridBagConstraints.WEST, 100, 100, TEXT_BOX_INSETS);
		
		JTextArea txtRecipeNotes = new JTextArea();
		txtRecipeInstructions.setFont(INPUT_TEXT_FONT);
		JScrollPane jsp_RecipeNotes = new JScrollPane(txtRecipeNotes);
		this.addNewItem(pane, jsp_RecipeNotes, 1, 7, 8, 1, GridBagConstraints.WEST, 100, 100, TEXT_BOX_INSETS);

		JButton btnAddIngredient = new JButton("Add");
		btnAddIngredient.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, btnAddIngredient, 8, 3, 1, 1, GridBagConstraints.CENTER, 0, 0, TEXT_BOX_INSETS);
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (txtRecipeIngredients.getText().equals(""))
					txtRecipeIngredients.setText(txtAmount.getText() + " " + txtaddIngredient.getText());
				else
					txtRecipeIngredients.setText(txtRecipeIngredients.getText() + "\n" + txtAmount.getText() + " "
							+ txtaddIngredient.getText());
				
				appendIngredientAList(txtaddIngredient.getText());
				appendAmountAList(txtAmount.getText());
				txtaddIngredient.setText("");
				txtAmount.setText("");
				setIngredientNumber(getIngredientNumber() + 1);
			}
		});

		JButton btnAddInstruction = new JButton("Add");
		btnAddInstruction.setFont(INPUT_TEXT_FONT);
		this.addNewItem(pane, btnAddInstruction, 8, 5, 1, 1, GridBagConstraints.CENTER, 0, 0, TEXT_BOX_INSETS);
		btnAddInstruction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(txtRecipeInstructions.getText().equals(""))
					txtRecipeInstructions.setText(getInstructionNumber() + ". " + txtAddInstruction.getText());
				else
					txtRecipeInstructions.setText(txtRecipeInstructions.getText() + "\n" + getInstructionNumber()
					+ ". " + txtAddInstruction.getText());
				
				txtAddInstruction.setText("");
				appendInstructionAList(txtAddInstruction.getText());
				setInstructionNumber(getInstructionNumber() + 1);
			}
		});

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setPreferredSize(BUTTON_DIMENSION);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String rIngredients = txtRecipeIngredients.getText();
				String lines[] = rIngredients.split("\\r?\\n");
				for (int i = 0; i < lines.length; i++) {
					System.out.println(lines[i]);
				}
				rdb.addNewRecipe(txtRecipeName.getText(), getRating(), txtRecipeDescription.getText(),
						txtRecipeNotes.getText() , getIngredientAList(), getAmountAList(), getInstrucitonAList());
				parent.updateTable();
				parent.getUI(true);
				dispose();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(BUTTON_DIMENSION);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				parent.setVisible(true);
				dispose();
			}
		});

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(btnSubmit);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 50)));
		buttonPane.add(btnCancel);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 10)));
		this.add(buttonPane, BorderLayout.SOUTH);

		this.add(pane);
		this.pack();
		this.setResizable(false);
	}

	
	private void addNewItem(JPanel pane, JComponent component, int gx, int gy, int width, int height, int anchor,
			int padx, int pady, Insets newInsets) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = newInsets;
		gc.weightx = 1;
		gc.weighty = 0.0;
		gc.gridx = gx;
		gc.gridy = gy;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.ipadx = padx;
		gc.ipady = pady;
		gc.anchor = anchor;

		pane.add(component, gc);
	}

	public void getUI(boolean visable) {
		this.setVisible(visable);
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		Add_New_Recipe.rating = rating;
	}

	public static int getIngredientNumber() {
		return ingredientNumber;
	}

	public static void setIngredientNumber(int ingredientNumber) {
		Add_New_Recipe.ingredientNumber = ingredientNumber;
	}

	public static ArrayList<String> getIngredientAList() {
		return ingredientAList;
	}

	public static void appendIngredientAList(String ingredient) {
		Add_New_Recipe.ingredientAList.add(ingredient);
	}

	/**
	 * @return the amountAList
	 */
	public static ArrayList<String> getAmountAList() {
		return amountAList;
	}

	/**
	 * @param amountAList the amountAList to set
	 */
	public static void appendAmountAList(String amount) {
		Add_New_Recipe.amountAList.add(amount);
	}

	/**
	 * @return the instrucitonAList
	 */
	public static ArrayList<String> getInstrucitonAList() {
		return instrucitonAList;
	}

	/**
	 * @param instrucitonAList the instrucitonAList to set
	 */
	public static void appendInstructionAList(String instruction) {
		Add_New_Recipe.instrucitonAList.add(instruction);
	}

	/**
	 * @return the instructionNumber
	 */
	public static int getInstructionNumber() {
		return instructionNumber;
	}

	/**
	 * @param instructionNumber add the instructionNumber to set
	 */
	public static void setInstructionNumber(int instructionNumber) {
		Add_New_Recipe.instructionNumber = instructionNumber;
	}

}
