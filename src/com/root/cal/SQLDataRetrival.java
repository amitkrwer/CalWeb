
package com.root.cal;

import java.sql.*;
import java.util.*;

import org.json.JSONArray;

public class SQLDataRetrival {

	Connection connection = null;

	public String queryForState(String pin) throws SQLException {

		if (connection == null) {
			connection = createConnection();
		}

		String state = "";
		PreparedStatement ps = null;
		String queryForState = "SELECT distinct statename FROM all_india_pincode_data where pincode = ?";
		if (connection != null) {
			ps = connection.prepareStatement(queryForState);
		}
		ps.setString(1, pin);
		ResultSet resultSetForState = ps.executeQuery();
		while (resultSetForState.next()) {
			state = resultSetForState.getString("statename");
		}
		resultSetForState.close();
		connection.close();
		return state;
	}

//getting list of district for a pincode
	public JSONArray queryForArea(String pin) throws SQLException {
		ArrayList<String> areaSet = new ArrayList<>();

		Connection connection = createConnection();

		PreparedStatement ps = null;

		String queryForPin = "SELECT distinct districtname from all_india_pincode_data where pincode = ?";
		if (connection != null) {
			ps = connection.prepareStatement(queryForPin);
		}
		ps.setString(1, pin);
		ResultSet resultSetForState = ps.executeQuery();
		while (resultSetForState.next()) {
			String state = resultSetForState.getString("districtname");
			areaSet.add(state);
		}

		resultSetForState.close();
		connection.close();
		String[] temp = new String[areaSet.size()];
		for (int i = 0; i < areaSet.size(); i++) {
			temp[i] = areaSet.get(i);
		}
		JSONArray jsArray2 = new JSONArray(areaSet);
		return jsArray2;

	}

//database creation
	public Connection createConnection() {
//		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/pincodedump?autoReconnect=true&useSSL=false";
		String USER = "root";
		String PASS = "qwerty123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}


	public static void main(String[] args){
		
	}
}
