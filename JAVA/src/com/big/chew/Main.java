package com.big.chew;

/**
 * <h1>Chewy Recipe Application
 * <h1>Recipe application that provides a UI for viewing stored recipes.
 * <p>
 * <b>Note:</b> Current conception will use embedded Data Base
 * 
 * @author John J. Garza
 * @version 0.2
 * @since 2016-6-2017
 */
public class Main {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				OpeningFrame op = new OpeningFrame();
			}
		});
	}
}
