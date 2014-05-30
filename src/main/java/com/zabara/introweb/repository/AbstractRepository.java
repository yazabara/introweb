package com.zabara.introweb.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class AbstractRepository {

	//default values
	private String url = "jdbc:h2:file:C:/h2/data/introweb";
	private String name = "";
	private String password = "";
	private String driverName = "org.h2.Driver";

	public AbstractRepository() throws ClassNotFoundException {
		//Загружаем драйвер
		Class.forName(driverName);
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, password);
	}

	public void runScript(String fileName) throws SQLException {
		String s;
		StringBuffer sb = new StringBuffer();
		try {
			FileReader fr = new FileReader(new File(fileName));
			// be sure to not have line starting with "--" or "/*" or any other non aplhabetical character
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			// here is our splitter ! We use ";" as a delimiter for each request
			// then we are sure to have well formed statements
			String[] inst = sb.toString().split(";");
			Connection c = getConnection();
			Statement st = c.createStatement();
			for (int i = 0; i < inst.length; i++) {
				// we ensure that there is no spaces before or after the request string
				// in order to not execute empty statements
				if (!inst[i].trim().equals("")) {
					st.executeUpdate(inst[i]);
					System.out.println(">>" + inst[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("*** Error : " + e.toString());
			System.out.println("*** ");
			System.out.println("*** Error : ");
			e.printStackTrace();
			System.out.println("################################################");
			System.out.println(sb.toString());
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}
