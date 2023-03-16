package it.molinari.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.molinari.model.Utente;

public class Dao {

	Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection getConnessione(String dbmsUser, String dbmsPass, String db) {
		try {
			String drive = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/"+db;

//			String login = "admin";
//			String psw = "admin";

			Connection conn = null;
			Class.forName(drive);
			conn = DriverManager.getConnection(url, dbmsUser, dbmsPass);

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

		setConn(getConnessione("admin","admin","test"));

		String query = "SELECT * FROM docenti WHERE id="+id;

		Statement st = this.conn.prepareStatement(query);
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

		setConn(getConnessione("admin","admin","test"));

		 String query = "update docenti set nome = ? where id = ?";
	      PreparedStatement preparedStmt = this.conn.prepareStatement(query);
	      preparedStmt.setString(2,id);
	      preparedStmt.setString(1, nome);

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      this.conn.close();

	}

	public void deleteUtenteDao(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		setConn(getConnessione("admin","admin","test"));
		String query = "DELETE FROM docenti WHERE id= ?";
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.setString(1, id);
		
		preparedStmt.executeUpdate();
		this.conn.close();
		
	}

	public void postUtenteDao(String nome,String cognome) throws SQLException {
		// TODO Auto-generated method stub
		setConn(getConnessione("admin","admin","test"));

		 String query = "INSERT INTO docenti SET nome= ?, cognome= ?";
	      PreparedStatement preparedStmt = this.conn.prepareStatement(query);
	      preparedStmt.setString(1,nome);
	      preparedStmt.setString(2, cognome);
	      

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      this.conn.close();
	}

	public Utente cercaUtenteDao(String user, String pass) throws SQLException {
		// TODO Auto-generated method stub
		setConn(getConnessione("admin","admin","test"));
		
		String query = "SELECT * FROM utenti WHERE username='pippo' and password='pippo'"; // and password=? 
		Statement st = this.conn.prepareStatement(query);
		//st.setString(1, id);
		ResultSet rs = st.executeQuery(query);
		
		if(rs!=null) {
			Utente user2 = new Utente();
			while (rs.next()) {

				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");

				// print the results
				user2.setNome(nome);
				user2.setCognome(cognome);
				
			}
			st.close();
			return user2;
			
		}else return null;

		
		
	}

	public Object stampaTuttoDao() throws SQLException {
		// TODO Auto-generated method stub
		setConn(getConnessione("admin","admin","test"));
		
		String query = "SELECT * FROM utenti"; // and password=? 
		Statement st = this.conn.prepareStatement(query);
		//st.setString(1, id);
		ResultSet rs = st.executeQuery(query);
		
		if(rs!=null) {
			ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
			//Utente userino = new Utente();
			
			
			while (rs.next()) {
				
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");

				// print the results
				Utente userino = new Utente();
				userino.setNome(nome);
				userino.setCognome(cognome);
				
				listaUtenti.add(userino);
			
			}
			st.close();
			return listaUtenti;
			
		}else return null;
	}


}
