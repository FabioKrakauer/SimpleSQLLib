package com.rKDev.mysql.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {
	
	public static void main(String[] args) {
		DatabaseConfig db = new DatabaseConfig(); //INSTANCIA CLASSE CONSTRUTORA DA CONEXAO
		db.setDatabase("adiabc_db"); // DEFINE A DATABASE DA CONEXAO
		db.setHost("localhost"); // DEFINE O IP PARA CONEXAO
		db.setPort(3306); // DEFINE A PORTA PARA A CONEXAO
		db.setUser("root"); //DEFINE O USUARIO PARA A CONEXAO
		db.setPassword(""); // DEFINE A SENHA DO USUARIO PARA A CONEXAO
		db.createConnection(); // INICIA A CONEXAO
		
		Query users = new Query("SELECT * FROM `user`", db); //CRIA UMA QUERY DE RESULTADOS
		ResultSet rs = users.getResultSet(); // RETORNA OS RESULTADOS DA QUERY
		try {
			while(rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Query insertCity = new Query("INSERT INTO `city` (`id`, `name`) VALUES (NULL, 'Atibaia')", db); //CRIA UMA QUERY DE INSERÇÃO
		insertCity.execute(); //EXECUTA QUERY DE INSERCAO 
		System.out.println("Cidade Inserida");
	}

}
