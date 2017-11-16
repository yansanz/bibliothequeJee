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


@SuppressWarnings("serial")
public class AppBook  extends HttpServlet {
	IService service;
	
	public void init() throws ServletException {
		DaoImpl dao = new DaoImpl();
		service = new Service(dao);
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getPathInfo();
		
		if (action == null || action.equals("/")) {
			rechBook(request,response);
		}else if (action.equals("/modify")) {
			modify(request,response);
		}else if (action.equals("/delete")) {
			delete(request,response);
		}else if(action.equals("/add")) {
			add(request,response);
		}else if(action.equals("/addBook")) {
			addBook(request,response);
		}else if(action.equals("/formValider")) {
			formValider(request,response);
		}else if(action.equals("/Book")) {
			book(request,response);
		}else if(action.equals("/rechBookValid")) {
			rechBookValid(request,response);
		}else if(action.equals("/CheckAuteur")) {
			affichAuteur(request,response);
		}else if (action.equals("/modifyInf")) {
			modifyInf(request,response);
		}
	}
		private void modifyInf(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Copy> exemplaire = new ArrayList<Copy>();
			String ISBN = request.getParameter("isbn");
			request.setAttribute("isbn",ISBN);
			exemplaire = service.getCopy(ISBN); 
			int idCopy = Integer.valueOf(request.getParameter("info")).intValue();
			
			Subscriber s = service.getSubExemplaire(idCopy);
			request.setAttribute("emprunteur", s);
			request.setAttribute("exemplaire", exemplaire);
			
			
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Book/modify.jsp").forward(request, response);
	}
		private void affichAuteur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Book> livre = new ArrayList<Book>();
			ArrayList<Catalog> catalog = new ArrayList<Catalog>();
			ArrayList<Author> auteur = new ArrayList<Author>();
			String chaine  = request.getParameter("zoneCibl");
			String[] sousChaine = chaine.split(" ");
			String nomAuteur = sousChaine[1];
			String prenomAuteur = sousChaine[0];
			Author a = service.existOrNo( nomAuteur, prenomAuteur);
			auteur = service.ListAuthor();
			catalog = service.getCatalog();
			request.setAttribute("auteurChoisi",a);
			request.setAttribute("auteur", auteur);
			request.setAttribute("catalog", catalog);
			request.setAttribute("auteurChecked", a);
			livre = service.RechAuthor(nomAuteur);
			request.setAttribute("livre", livre);
			request.setAttribute("auteurNotif", ": choisi , verifier la liste ci dessus avant de creer le livre puis VALIDER");
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Book/addBook.jsp").forward(request, response);
	}
		private void rechBookValid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Book> livre = new ArrayList<Book>();
			String name = request.getParameter("txtTitre");
			String genre  = request.getParameter("genre");
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
			if (name!=null) {
			if (!name.equals("")) {
			livre = service.RechTitreExact(name);
			request.setAttribute("livre", livre);
			}else if  (!request.getParameter("auteur").equals("") ) {
				String chaine  = request.getParameter("auteur");
				String[] sousChaine = chaine.split(" ");
				String nomAuteur = sousChaine[1];
				livre = service.RechAuthor(nomAuteur);
				request.setAttribute("livre", livre);
			}else if (!request.getParameter("genre").equals("") ) {
				livre = service.RechGenre(genre);
				request.setAttribute("livre", livre);
			}else {
				book(request,response);
			}
			}
			getServletContext().getRequestDispatcher("/WEB-INF/views/Book/rechBookValid.jsp").forward(request, response);
	}
		private void rechBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
			getServletContext().getRequestDispatcher("/WEB-INF/views/Book/rechBook.jsp").forward(request, response);
	}
		private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Catalog> catalog = new ArrayList<Catalog>();
			ArrayList<Author> auteur = new ArrayList<Author>();
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
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Book/addBook.jsp").forward(request, response);
	}
		public Author existOrNo(String nom,String prenom){
			return service.existOrNo(nom, prenom);
		}
		
		public void formValider(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			Author at ;
			String isbn = request.getParameter("txtIsbn");
			String titre = request.getParameter("txtTitre");
			String ssTitre = request.getParameter("txtSsTitre");
			String genre = request.getParameter("genre");
			if (isbn.equals("") || titre.equals("") || genre.equals("")) {
				 request.setAttribute("infoAdd", "Renseigner toute les zones avant de valider");
				 addBook(request,response);
			}else {
			System.out.println("test"+(String)request.getParameter("auteur"));
			int nbrCopy = Integer.valueOf((String)request.getParameter("txtNbreCopy")).intValue();
			if (request.getParameter("auteurChecked").equals("") ) {
			String prenom = request.getParameter("txtNom");
			String nom = request.getParameter("txtPrenom");
			int birth = Integer.valueOf((String)request.getParameter("txtAnnee")).intValue();
			 at = new Author(nom,prenom,birth);
			 Book b = new Book(isbn,titre, ssTitre,at, genre,nbrCopy);
			 service.ajouterLivre(b);
			}else {
				String chaine  = request.getParameter("auteurChecked");
				String[] sousChaine = chaine.split(" ");
				String nomAuteur = sousChaine[1];
				String prenomAuteur = sousChaine[0];
				existOrNo(nomAuteur, prenomAuteur);
				 at =  service.existOrNo(nomAuteur, prenomAuteur);
				 Book b = new Book(isbn,titre, ssTitre,at, genre,nbrCopy);
				 service.ajouterLivreAuteurExistant(b);
			}
				book(request,response);
			}
		}
		
		public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String isbn = request.getParameter("isbn");
		service.addCopy(isbn);
		book(request,response);
	}
		public void delete(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Copy> exemplaire = new ArrayList<Copy>();
			String ISBN = request.getParameter("isbn");
			request.setAttribute("isbn",ISBN);
			exemplaire = service.getCopy(ISBN); 
			request.setAttribute("exemplaire", exemplaire);
			int numCopy = Integer.valueOf((String) request.getParameter("numCopy")).intValue();
			if (service.dispoCopy(numCopy)) {
			service.modifCopy(numCopy);
		}else {
			request.setAttribute("infoDelete", "Veuillez restituer "
					+ "l exemplaire avant suppression");
		}
			modify(request,response);
	}
		public void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Copy> exemplaire = new ArrayList<Copy>();
			String ISBN = request.getParameter("isbn");
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
			request.setAttribute("isbn",ISBN);
			exemplaire = service.getCopy(ISBN); 
			request.setAttribute("exemplaire", exemplaire);
			
			
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Book/modify.jsp").forward(request, response);
	}
		public void book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Book> livre = new ArrayList<Book>();
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
			
			livre = service.RechTitre();
			request.setAttribute("livre", livre);
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Book/Book.jsp").forward(request, response);
	}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// on passe la main au get
			doGet(request, response);
		}
	}