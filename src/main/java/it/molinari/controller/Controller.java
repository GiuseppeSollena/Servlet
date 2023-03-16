package it.molinari.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.molinari.model.Utente;
import it.molinari.service.UtenteService;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		UtenteService utenteService = new UtenteService();
		String str = request.getServletPath();

		try {
			String id,nome,cognome;
			switch(str) {
			case "/deleteUtente":
				//response.getWriter().append("vuoi eliminare");
				id = request.getParameter("id");
				if(id != null) {
					utenteService.deleteUtente(id);
					Utente user = utenteService.estraiUtente(id);
					response.getWriter().append("hai cancellato utente con id "+id+": "+ user.getCognome() + " " + user.getNome());
				}else {
					response.getWriter().append("non hai inserito correttamnte");
				}
			break;
			case "/getUtente":
				//response.getWriter().append("vuoi leggere");
				id = request.getParameter("id");
				if(id != null) {
					Utente user = utenteService.estraiUtente(id);
					response.getWriter().append(user.getCognome() + " " + user.getNome());
				}else {
					response.getWriter().append("non hai inserito correttamnte");
				}
				
			break;
			case "/postUtente":
				//response.getWriter().append("vuoi inserire");
			
			    nome = request.getParameter("nome");
				cognome = request.getParameter("cognome");
				if(nome != null && cognome != null) {
					utenteService.postUtente(nome,cognome);
					response.getWriter().append("inserito nuovo docente");
					//Utente user = utenteService.estraiUtente(id);
					//response.getWriter().append("hai aggiunto utente con id "+id+": "+ user.getCognome() + " " + user.getNome());
					
				}else {
					response.getWriter().append("non hai inserito correttamnte");
				}
				
				
			break;
			case "/putUtente":
				//response.getWriter().append("vuoi editare");
				id = request.getParameter("id");
				nome = request.getParameter("nome");
				if(id != null) {
					utenteService.putUtente(id, nome);
					Utente user = utenteService.estraiUtente(id);
					response.getWriter().append("hai modicato utente con id "+id+": "+ user.getCognome() + " " + user.getNome());
					
				}else {
					response.getWriter().append("non hai inserito correttamnte");
				}
				
				
			break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			break;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//.append(request.getContextPath())
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
