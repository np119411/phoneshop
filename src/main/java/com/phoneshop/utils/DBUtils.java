
package com.phoneshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;

public class DBUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		/*final String url = "jdbc:mysql://localhost:3306/phoneshop";
		final String user = "root";
		final String password = "119411"; // DATABASE PASSWORD
*/
		
		 final String url = "jdbc:mysql://remotemysql.com:3306/hPMST9hiwo"; final
		 String user = "hPMST9hiwo"; final String password = "mCrnFlaPhf" ; //DATABASE PASSWORD
		 Connection conn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		return conn;

	}

}
