package it.molinari.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.molinari.model.Utente;

public class Dao {

	public Connection getConnessione() {
		try {
			String drive = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";

			String login = "admin";
			String psw = "admin";

			Connection conn = null;
			Class.forName(drive);
			conn = DriverManager.getConnection(url, login, psw);

			return conn;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	// all'inserimento del paramentro Controller?id=5
	// chiediamo di estrarre in UtenteService l'utente 5
	// getUtente(id)
	// dao.getUtente(id)

	public Utente estraiUtenteDao(String id) throws SQLException {

		Utente user = new Utente();

		Dao dao = new Dao();
		Connection conn = dao.getConnessione();

		String query = "SELECT * FROM docenti WHERE id="+id;

		Statement st = conn.prepareStatement(query);
		//st.setString(1, id);
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");

			// print the results
			user.setCognome(cognome);
			user.setNome(nome);
		}
		st.close();

		return user;
	}

	public void modificaUtenteDao(String id, String nome) throws SQLException {

		// Utente user = new Utente();

		Dao dao = new Dao();
		Connection conn = dao.getConnessione();

		 String query = "update docenti set nome = ? where id = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(2,id);
	      preparedStmt.setString(1, nome);

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      conn.close();

	}

}
