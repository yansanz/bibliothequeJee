package fr.afpa.jeelibrary.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.jeelibrary.dao.DaoImpl;
import fr.afpa.jeelibrary.model.Book;
import fr.afpa.jeelibrary.model.Copy;
import fr.afpa.jeelibrary.model.Subscriber;
import fr.afpa.jeelibrary.service.IService;
import fr.afpa.jeelibrary.service.Service;

public class AppLibrary  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IService service;
	
	public void init() throws ServletException {
		DaoImpl dao = new DaoImpl();
		service = new Service(dao);
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getPathInfo();
		if (action == null || action.equals("/")) {
			library(request,response);
		}else if (action.equals("/formLibrairie")) {
			emprunter(request,response);
		}else if (action.equals("/validEmprunt")) {
			validEmprunt(request,response);
		}else if (action.equals("/Return")) {
			returnBook(request,response);
		}else if (action.equals("/ReturnValid")) {
			returnBookValid(request,response);
		}
	}
	private void returnBookValid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (request.getParameter("txtCopId").equals("")){
			 request.setAttribute("warning", "Choisir un emprunteur et un livre");
			 library(request,response);
		}else {
		int idClient =  Integer.valueOf(request.getParameter("txtIdSub")).intValue();
		int idCopy = Integer.valueOf(request.getParameter("txtCopId")).intValue();
		System.out.println(idCopy);
		System.out.println(idClient);
		service.Restitue(idCopy, idClient);
		library(request,response);
	}
	}
	private void validEmprunt(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("txtId")).intValue();
		String chaine2  = request.getParameter("book");
		String[] sousChaine2 = chaine2.split(" ");
		int idCopy = Integer.valueOf(sousChaine2[1]).intValue();
		String isbn = sousChaine2[2];
		service.Emprunte(isbn,idCopy, id);
		library(request, response);
	}
	private void emprunter(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
		String chaine  = request.getParameter("subscriber");
		String chaine2  = request.getParameter("book");
		if(chaine.equals("") || chaine2.equals("")) {
			 request.setAttribute("warning", "Choisir un emprunteur et un livre");
			 library(request, response);
		}else {
			 request.setAttribute("warning", "");
		String[] sousChaine = chaine.split(" ");
		int id = Integer.valueOf(sousChaine[0]).intValue();
		
		String[] sousChaine2 = chaine2.split(" ");
		String isbn = sousChaine2[0];
		if (service.getNbreEmprunt(id)== false) {
			popUpWarning(request,response);
		return;
		}else {
		ArrayList<Copy> livre = service.getCopy(isbn);
		request.setAttribute("livre", livre);
		Subscriber s = service.getOneEmprunteur(id);
		 String lastName = s.getLastName();
		 String fisrtName = s.getFisrtName();
		 request.setAttribute("warning", "");
		 request.setAttribute("return", id);
		 request.setAttribute("id", id);
	
		 request.setAttribute("txtIdSub", id);
		 request.setAttribute("lastName", lastName);
		 request.setAttribute("fisrtName", fisrtName);
		
		 getServletContext().getRequestDispatcher("/WEB-INF/views/Library/Emprunter.jsp").forward(request, response);
		}
		}
	}
	public void returnBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String chaine  = request.getParameter("subscriberReturn");
		String[] sousChaine = chaine.split(" ");
		int id = Integer.valueOf(sousChaine[0]).intValue();
		
		 ArrayList<Copy> exemplaire = service.getCopyByBorrower(id);
		 request.setAttribute("exemplaire", exemplaire);
		
		 request.setAttribute("id", id);
		 Subscriber s = service.getOneEmprunteur(id);
		 request.setAttribute("s", s);
		 String nom = s.getLastName();
		 String prenom = s.getFisrtName();
		 request.setAttribute("lastName", nom);
		 request.setAttribute("fisrtName", prenom);
		 library(request,response);
	}

	private void popUpWarning(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
		String chaine  = request.getParameter("subscriber");
		String[] sousChaine = chaine.split(" ");
		int id = Integer.valueOf(sousChaine[0]).intValue();
		Subscriber s = service.getOneEmprunteur(id);
		 String lastName = s.getLastName();
		 String fisrtName = s.getFisrtName();
		 request.setAttribute("warning", "a atteint 5 emprunt");
		 request.setAttribute("id", id);
		 request.setAttribute("lastName", lastName);
		 request.setAttribute("fisrtName", fisrtName);
		System.out.println("trop d emprunt Numero: "+id);
		library(request, response);
	}
	private void library(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		ArrayList<Book> livre = new ArrayList<Book>();
		ArrayList<Subscriber> sub = service.getAllSub();
		ArrayList<Book> exemplaire = service.RechTitre();
		String contact = request.getParameter("contact");
		String infLeg = request.getParameter("infLeg");
		String condUtil = request.getParameter("condUtil");
		if (contact!=null) {
			request.setAttribute("contact", "yansanz90@gmail.com");
		}
		if(infLeg !=null) {
			request.setAttribute("infoLegal", "loi n° 2004-575 du 21 juin 2004 , Article 6");
		}
		if(condUtil !=null) {
			request.setAttribute("condUtil", "Document à but pedagogique - AFPA");
		}
		System.out.println(exemplaire);
		for (int i = 0;i< exemplaire.size() ;i++) {
				if (service.dispoLivre(exemplaire.get(i).getIsbn())) {
				Book b =  service.RechIsbn(exemplaire.get(i).getIsbn());
				livre.add(b);
			}
		}
		request.setAttribute("livre", livre);
		request.setAttribute("sub", sub);
		 getServletContext().getRequestDispatcher("/WEB-INF/views/Library.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// on passe la main au get
		doGet(request, response);
	}
}
