package com.duan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static Connection conn = null;
	
	private static String url = "jdbc:sqlserver://192.168.1.69; DataBaseName=BookStore";
	private static String user = "Hao";
	private static String password = "ChuTich@123";
	
	static
	{
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			//new MessageJDialog("Đã có lỗi sảy ra!", e.getMessage(), "Đã Hiểu", MessageJDialog.TYPE_ICON_ERROR).setVisible(true);
			e.printStackTrace();
		}
	}
	
	//private static Connection conn = null;
	
	/**
	 * @param url url cấu hình JDBC
	 * @param user Username SQL
	 * @param password Password SQL
	 * Thực hiện tạo giá trị connection cho biến conn
	 */
	public static void setConnection(String url, String user, String password) throws SQLException
	{
		conn = DriverManager.getConnection(url, user, password);
	}
	
	
	//Trả về giá trị connection của biến conn
	public static Connection getConnection()
	{
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
