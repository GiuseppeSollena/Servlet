package it.molinari.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.molinari.model.Utente;
import it.molinari.service.UtenteService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //serve per serializzare l'oggetto?
	
	private final String user = "test";
	private final String pass = "test";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			UtenteService utenteService = new UtenteService();
			Utente result = new Utente();
			//Utente result2 = new Utente();
			result = utenteService.checkUtente(username, password);
			ArrayList<Utente> resultList = (ArrayList<Utente>) utenteService.stampaTutto();
			
			if(resultList != null) {
				 
				HttpSession oldSession = request.getSession(false); //recupero sessione
				if(oldSession != null) {
					oldSession.invalidate(); //invalido la sessione se esiste
				}
				HttpSession currentSession = request.getSession(); //creo la nuova sessione
//				currentSession.setAttribute("nome", result2.getNome() ); 
//				currentSession.setMaxInactiveInterval(5*60); //5 min
//				currentSession.setAttribute("cognome", result2.getCognome() ); 
//				currentSession.setMaxInactiveInterval(5*60); //5 min
				
				response.sendRedirect("success.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
