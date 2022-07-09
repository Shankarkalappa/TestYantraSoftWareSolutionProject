package com.vtiger.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;


/**
 * This Class Contains All Generic or Common Method of Database
 * @author shank
 *
 */
public class DataBaseUtility {
	static ArrayList<String> list = new ArrayList<String>();
	static Connection connection;
	/**
	 * This Method is used to get the Connection from DataBase
	 * @param dburl
	 * @param dbuserName
	 * @param dbpassword
	 * @throws SQLException
	 */
	public static void getMysqlDatabaseConnection(String dburl, String dbuserName,String dbpassword) throws SQLException {
		Driver driver= new Driver();

		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(dburl, dbuserName, dbpassword);
	}
	/**
	 * This Method is used to Fetch the Data from the Database based on Column Number
	 * @param query
	 * @param columnNumber
	 * @return 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDatabase(String query, int columnNumber) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			list.add(result.getString(columnNumber));	
		}
		statement.close();
		return list;
	}

	/**
	 * This Method Is used to fetch the data from Database on the Column Name
	 * @param query
	 * @param columnNumberOrColumnName
	 * @return
	 * @throws SQLException
	 */
	public static  ArrayList<String> getDataFromDatabase(String query,String columnNumberOrColumnName) throws SQLException {
		String num="";
		for (int i = 0; i < columnNumberOrColumnName.length(); i++) {
			char ch = columnNumberOrColumnName.charAt(i);
			if (Character.isDigit(ch)) {
				num=num+columnNumberOrColumnName.charAt(i);
			}else {
				break;
			}
		}
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		int columnNumber=0;
		String columnName=null;
		if (num.equalsIgnoreCase(columnNumberOrColumnName)) {
			columnNumber=Integer.parseInt(num);
			while (result.next()) {
				list.add(result.getString(columnNumber));
			}
		}else {
			columnName=columnNumberOrColumnName;
			while (result.next()) {
				list.add(result.getString(columnName));
			}
		}
		connection.close();
		return list;
	}
	/**
	 * This method is used to update/write/modify the data inside the database
	 * @param query
	 * @throws SQLException
	 */
	public static void updateDataIntoDatabase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		System.out.println("query executed Successfully");
		statement.close();
	}
	/**
	 * This Method is used to verify the data whether it is present in the database or not
	 * @param query
	 * @param ColumnNameorColumnNumber
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public static boolean verifyData(String query, String ColumnNameorColumnNumber,String expData) throws SQLException {
		ArrayList<String> listData = getDataFromDatabase(query,ColumnNameorColumnNumber);
		boolean flag= false;
		for(String data:listData) {
			if (data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	public static void closeDatabaseConnection() throws Throwable {
			connection.close();
	}
}
