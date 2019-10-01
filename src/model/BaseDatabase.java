/**
 * Copyright(C) 2019 Luvina JSC
 * BaseDatabase.java, Sep 25, 2019, HangHT
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HangHT
 *
 */
public class BaseDatabase {
	public static final String URL = PropertyFile.readProperty("url");
	public static final String DRIVER = PropertyFile.readProperty("driver");
	public static final String USER = PropertyFile.readProperty("user");
	public static final String PASS = PropertyFile.readProperty("pass");
	public static final String ERR_CLASS = PropertyFile.readProperty("classerr");
	public static final String ERR_SQL = PropertyFile.readProperty("sqlerr");
	protected Connection con;
	
	public BaseDatabase() throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(ERR_CLASS);
		}
	}
	
	protected void openConnection() throws SQLException {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(ERR_SQL);
		}
	}
	
	protected void closeConnection() throws SQLException {
		try {
			if(con == null || con.isClosed()) {
				return;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(ERR_SQL);
		}
	}
}
