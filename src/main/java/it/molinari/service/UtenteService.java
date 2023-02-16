package it.molinari.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public void putUtente(String id,String nome) throws SQLException{
		Utente utente = new Utente();
		
		Dao dao = new Dao();
		dao.modificaUtenteDao(id, nome);
	}
	

}
