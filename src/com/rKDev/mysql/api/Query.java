package com.rKDev.mysql.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Query {
	
	private PreparedStatement statement;
	
	public Query(String query, DatabaseConfig config) {
		try {
			this.statement = (PreparedStatement)config.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() {
		try {
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet getResultSet() {
		ResultSet rs = null;
		try {
			rs = this.statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public PreparedStatement getStatement() {
		return this.statement;
	}
	

}
