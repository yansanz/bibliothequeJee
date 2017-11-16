package fr.afpa.jeelibrary.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.jeelibrary.dao.DaoImpl;
import fr.afpa.jeelibrary.model.Author;
import fr.afpa.jeelibrary.model.Book;
import fr.afpa.jeelibrary.model.Catalog;
import fr.afpa.jeelibrary.model.Copy;
import fr.afpa.jeelibrary.model.Subscriber;
import fr.afpa.jeelibrary.service.IService;
import fr.afpa.jeelibrary.service.Service;

public class AppTablBord  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6374645171296130824L;
	/**
	 * 
	 */
	IService service;
	public void init() throws ServletException {
		DaoImpl dao = new DaoImpl();
		service = new Service(dao);
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getPathInfo();
		if (action == null || action.equals("/")) {
			TablBord(request,response);
		}else if (action.equals("/rechercheBook")) {
			rechercheBook(request,response);
		}else if (action.equals("/rechercheSub")) {
			rechercheSub(request,response);
		}else if (action.equals("/info")) {
			info(request,response);
		}else if (action.equals("/modif")) {
			modif(request,response);
		}else if (action.equals("/modifSub")) {
			modifSub(request,response);
		}else if (action.equals("/supr")) {
			supression(request,response);
	}
	}
		private void supression(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			String isbn = request.getParameter("txtCibl5");
			ArrayList<Copy> livre = new ArrayList<Copy>();
			request.setAttribute("infoBul", "selectionner copie a supprimer");
			 livre = service.getCopy(isbn);
			 request.setAttribute("exemplaire", livre);
			 TablBord(request,response);
	}
		private void modifSub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			int id =  Integer.valueOf(request.getParameter("txtId")).intValue();
			String nom = request.getParameter("txtNom");
			String prenom = request.getParameter("txtPrenom");
			Subscriber s = new Subscriber( prenom,nom, id);
			service.modifEmprunteur(s);
			TablBord(request,response);
	}
		private void modif(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			if(!request.getParameter("txtCibl4").equals("")) {
			int id =  Integer.valueOf(request.getParameter("txtCibl4")).intValue();
			 Subscriber s = service.getOneEmprunteur(id);
			 System.out.println(s);
			 String lastName = s.getLastName();
			 String fisrtName = s.getFisrtName();
			 request.setAttribute("id", id);
			 request.setAttribute("lastName", lastName);
			 request.setAttribute("fisrtName", fisrtName);
			}else {
				String isbn = request.getParameter("txtCibl3");
				Book b =service.RechIsbn(isbn);
				String titre = b.getTitle();
				String subTitre = b.getSubtitle();
				ArrayList<Catalog> catalog = service.getCatalog();
				ArrayList<Author> author = service.ListAuthor();
				Author auteur = b.getAuthor();
				String genre = b.getGenre();
				String namAut = auteur.getLastName();
				String prenAut = auteur.getFisrtName();
				int agAut = auteur.getDateOfBirth();
				 request.setAttribute("isbn", isbn);
				 request.setAttribute("titre", titre);
				 request.setAttribute("subTitre", subTitre);
				 request.setAttribute("namAut", namAut);
				 request.setAttribute("prenAut", prenAut);
				 request.setAttribute("agAut", agAut);
				 request.setAttribute("catalog", catalog);
				 request.setAttribute("auteur", author);
				 request.setAttribute("genre", genre);
			}
			 getServletContext().getRequestDispatcher("/WEB-INF/views/tablBordUpgrade.jsp").forward(request, response);
		
	}
		private void info(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			String isbn = request.getParameter("txtCibl1");
			
			ArrayList<Copy> livre = new ArrayList<Copy>();
			if (!isbn.equals("")) {
		 livre = service.getCopy(isbn);
		 System.out.println("test sub1 "+isbn);
			}else {
				
				int id =  Integer.valueOf(request.getParameter("txtCibl2")).intValue();
				System.out.println("test sub2 "+id);
				livre = service.getCopyByBorrower(id);
				 Subscriber s = service.getOneEmprunteur(id);
				 String lastName = s.getLastName();
				 String fisrtName = s.getFisrtName();
				request.setAttribute("infoBul", fisrtName+" "+lastName);
			}request.setAttribute("exemplaire", livre);
			TablBord(request,response);
			
	}
		private void rechercheSub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Subscriber> emprunteur = new ArrayList<Subscriber>();
			String name = request.getParameter("txtNom");
			if (name==null) {
				emprunteur = service.getAllSub();
			}else {
				emprunteur = service.recherchNom(name);
			}
				request.setAttribute("emprunteur", emprunteur);
			
			TablBord(request, response);
		
	}
		private void rechercheBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Book> livre = new ArrayList<Book>();
			String name = request.getParameter("txtTitre");
			String genre  = request.getParameter("genre");
			
			
			if (name!=null) {
				if (!name.equals("")) {
				livre = service.RechTitreExact(name);
				request.setAttribute("livre", livre);
				}else if (request.getParameter("auteur")!=null ) {
					String chaine  = request.getParameter("auteur");
					String[] sousChaine = chaine.split(" ");
					String nomAuteur = sousChaine[1];
					livre = service.RechAuthor(nomAuteur);
					request.setAttribute("livre", livre);
					}
				else if (!genre.equals("") ) {
					livre = service.RechGenre(genre);
					request.setAttribute("livre", livre);
				}else {
					livre = service.RechTitre();
					request.setAttribute("livre", livre);
				}
				}
				
			TablBord(request, response);
		}
		
	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// on passe la main au get
			doGet(request, response);
		}


	private void TablBord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ArrayList<Author> auteur = new ArrayList<Author>();
		ArrayList<Catalog> catalog = new ArrayList<Catalog>();
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
		auteur = service.ListAuthor();
		catalog = service.getCatalog();
		request.setAttribute("auteur", auteur);
		request.setAttribute("catalog", catalog);
		 getServletContext().getRequestDispatcher("/WEB-INF/views/TablBord.jsp").forward(request, response);
		
	}
}
