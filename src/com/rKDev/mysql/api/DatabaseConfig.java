package com.rKDev.mysql.api;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseConfig {
	
	private Connection con;
	private String user;
	private String password;
	private String host;
	private String database;
	private Integer port;
	
	public DatabaseConfig() {
		this.con = null;
		this.user = null;
		this.password = null;
		this.database = null;
		this.port = null;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void createConnection() {
		String dsn = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = (Connection)DriverManager.getConnection(dsn, this.user, this.password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return this.con;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((con == null) ? 0 : con.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatabaseConfig other = (DatabaseConfig) obj;
		if (con == null) {
			if (other.con != null)
				return false;
		} else if (!con.equals(other.con))
			return false;
		return true;
	}

}
