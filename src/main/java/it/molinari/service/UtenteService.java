package it.molinari.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.molinari.dao.Dao;
import it.molinari.model.Utente;

public class UtenteService {
	
	public Utente getUtente() {
		Utente utente = new Utente();
		
		utente.setCognome("Sollena");
		utente.setNome("Beppe");
		
		return utente;
	}
	
	public Utente estraiUtente(String id) throws SQLException {

		Dao dao = new Dao();
		return dao.estraiUtenteDao(id);
		
	}
	
	public Utente checkUtente(String user,String pass) throws SQLException {
		Dao dao = new Dao();
		return dao.cercaUtenteDao(user,pass);
		
	}
	
	public void putUtente(String id,String nome) throws SQLException{
		
		Dao dao = new Dao();
		dao.modificaUtenteDao(id, nome);
	}

	public void deleteUtente(String id) throws SQLException {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		dao.deleteUtenteDao(id);
	}

	public void postUtente(String nome,String cognome) throws SQLException {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		dao.postUtenteDao(nome,cognome);
		
	}

	public Object stampaTutto() throws SQLException {
		// TODO Auto-generated method stub
		
		Dao dao = new Dao();
		return  dao.stampaTuttoDao();
	}
	

}
