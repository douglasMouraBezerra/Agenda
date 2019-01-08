package br.com.caelum.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static String urlBanco = "jdbc:mysql://localhost:3306/caelum?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "java086510";
	private static Connection connection = null;

	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(urlBanco, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectado>>>");
			}
		} catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
			// e.printStackTrace();
			// fazemos o cast por que o compilador nao sabe de qual excecao estamos nos
			// referindo
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + ((SQLException) e).getSQLState());
			System.out.println("VendorError: " + ((SQLException) e).getErrorCode());
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
