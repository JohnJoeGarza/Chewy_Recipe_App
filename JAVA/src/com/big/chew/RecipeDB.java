/*
 * TO-DO:
 * Brainstorm implementation of different methods that are going to access the database to work with
 * View, Search, Delete, Add New, and Edit buttons.
 * 
 * Figure out where to put connection closing statements.
 * 
 * Add logic for certain methods to return an empty method upon failure.
 *
 * Work on Exception handling. 
 * 
 * John J. Garza
 * 2/14/2017
 *  
 */

package com.big.chew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Class that is used to handle different query operations that are used on the
 * recipe database. Certain methods are used to access specific relations that
 * are used with the recipe application.
 * 
 * @author johnj
 *
 */
public class RecipeDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:chewyrecipes;create=true";
	public static final String SQL_DATA_FOR_JTABLE_STATMENT = "SELECT recipe_name, recipe_rating, date_added FROM recipes";

	private Connection conn;

	/**
	 * Constructs a RecipeDB object that will connect to the recipe database via
	 * DriverManager and Connection
	 * 
	 * @see DriverManager
	 * @see Connection
	 * 
	 */
	public RecipeDB() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(JDBC_URL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes a query that will retrieve all recipes from the recipe database.
	 * 
	 * @note Only the recipe_name, recipe_rating, and date_added attributes are
	 *       retrieved.
	 * 
	 * @return Vectors of all recipes in the recipe database.
	 */
	public Vector<Vector<Object>> getAllRecipeTableData() {

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_DATA_FOR_JTABLE_STATMENT);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while (resultSet.next()) {
				Vector<Object> rowVector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					rowVector.add(resultSet.getObject(columnIndex));
				}
				data.add(rowVector);
			}

			return data;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Return Empty Table?
		return null;
	}
}