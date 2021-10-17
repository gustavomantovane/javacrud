package br.com.cliente.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//Nome do usuário do mysql
	private static final String USERNAME = "root";

	//Senha do banco
	private static final String PASSWORD = "";

	//Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/JavaCRUD";

	/*
	 * Conexão com o banco de dados
	 */
	public static Connection createConnectionToMySql() throws Exception {
		//Faz com que a classe seja carregada pelo JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

	public static void main(String args[]) throws Exception {

		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySql();

		//Testar se a conexão é nula
		if(con != null) {

			System.out.println("Conexão obtida com sucesso");
			con.close();

		}

	}
}
