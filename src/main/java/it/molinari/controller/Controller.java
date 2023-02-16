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
		

		//Utente user = new Utente();
		//Utente user = utenteservice.getUtente();
		
		UtenteService utenteService = new UtenteService();
		
		
//		if(request.getQueryString() != null) {
//			
//			String split[] = request.getQueryString().split("=");
//			
//			try {
//				
//				Utente user = utenteService.estraiUtente(split[1]);
//				//response.getWriter().append("Served at: " + user.getCognome() + " " + user.getNome() );
//				response.getWriter().append(user.getCognome() + " " + user.getNome());
//				
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}else {
//			response.getWriter().append("non hai inserito alcun path corretto");
//		}
//		
		
		
		String str = request.getServletPath();
		//response.getWriter().append(str);
		
	
		try {
			String id;
			switch(str) {
			case "/deleteUtente":
				//response.getWriter().append("vuoi eliminare");
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
				response.getWriter().append("vuoi inserire");
			break;
			case "/putUtente":
				//response.getWriter().append("vuoi editare");
				id = request.getParameter("id");
				String nome = request.getParameter("nome");
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
