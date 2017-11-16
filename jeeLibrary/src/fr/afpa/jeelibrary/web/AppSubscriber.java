package fr.afpa.jeelibrary.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.jeelibrary.dao.DaoImpl;
import fr.afpa.jeelibrary.model.Copy;
import fr.afpa.jeelibrary.model.Subscriber;
import fr.afpa.jeelibrary.service.IService;
import fr.afpa.jeelibrary.service.Service;

@SuppressWarnings("serial")
public class AppSubscriber  extends HttpServlet {
	IService service;
	
	public void init() throws ServletException {
		DaoImpl dao = new DaoImpl();
		service = new Service(dao);
}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getPathInfo();
		if (action == null || action.equals("/")) {
			rechSub(request,response);
		}else if (action.equals("/modifySub")) {
			modifySub(request,response);
		}else if (action.equals("/deleteSub")) {
			deleteSub(request,response);
		}else if (action.equals("/infoSub")) {
			infoSub(request,response);
		}else if (action.equals("/addSub")) {
			addSub(request,response);
		}else if (action.equals("/formValiderSub")) {
			formValiderSub(request,response);
		}else if (action.equals("/formModifSub")) {
			formModifSub(request,response);
		}else if (action.equals("/restituer")) {
				restituer(request,response);
		}else if (action.equals("/Subscriber")) {
			subscriber(request,response);
		}else if (action.equals("/rechSubValid")) {
			rechSubValid(request,response);
		}
		}
	private void rechSubValid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ArrayList<Subscriber> emprunteur = new ArrayList<Subscriber>();
		
		String name = request.getParameter("txtNom");
				if (name.equals("")) {
					subscriber(request,response);
				}else {
					emprunteur = service.recherchNom(name);
					request.setAttribute("emprunteur", emprunteur);
					 getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/Subscriber.jsp").forward(request, response);
				}
	}

	private void rechSub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
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
		getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/rechSub.jsp").forward(request, response);
	}

	private void formModifSub(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("txtNom");
		String prenom = request.getParameter("txtPrenom");
		int id = Integer.valueOf(request.getParameter("txtId")).intValue();
		Subscriber s = new Subscriber( prenom,nom, id);
		service.modifEmprunteur(s);
		subscriber(request, response);
	}
	public void formValiderSub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("txtNom");
		String prenom = request.getParameter("txtPrenom");
		if(nom.equals("") || prenom.equals("")) {
			addSub(request,response);
		}else {
		int id = 0;
		Subscriber s = new Subscriber(nom,prenom,id);
		service.ajouterEmprunteur(s);
		subscriber(request,response);
		}
	}
	private void restituer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String chaine  = request.getParameter("book");
		String[] sousChaine = chaine.split(" ");
		int idCopy = Integer.valueOf(sousChaine[0]).intValue();
		int id = Integer.valueOf(request.getParameter("txtId")).intValue();
		System.out.println(idCopy+" test" + id);
		service.Restitue(idCopy, id);
		subscriber(request, response);
	}
	public void addSub(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
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
		 getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/addSub.jsp").forward(request, response);
	}

	public void infoSub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 int id = Integer.valueOf((String) request.getParameter("id")).intValue();
		 ArrayList<Copy> livre = service.getCopyByBorrower(id);
		 request.setAttribute("livre", livre);
		 request.setAttribute("id", id);
		 Subscriber s = service.getOneEmprunteur(id);
		 request.setAttribute("s", s);
		 getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/infoSub.jsp").forward(request, response);
	}

	public void deleteSub(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
			int id = Integer.valueOf((String) request.getParameter("id")).intValue();
			System.out.println("test");
			if (service.verifEmpruntAvanSuppression(id) == true){
				service.supprimEmprunteur(id);
			subscriber(request,response);
			}else {
				 Subscriber s = service.getOneEmprunteur(id);
				 String lastName = s.getLastName();
				 String fisrtName = s.getFisrtName();
				 request.setAttribute("lastName", lastName);
				 request.setAttribute("fisrtName", fisrtName);
				request.setAttribute("info", "a des emprunt a restituer avant suppression");
				subscriber(request,response);
			}
		}
	public void modifySub(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		 int id = Integer.valueOf((String) request.getParameter("id")).intValue();
		 Subscriber s = service.getOneEmprunteur(id);
		 System.out.println(s);
		 String lastName = s.getLastName();
		 String fisrtName = s.getFisrtName();
		 request.setAttribute("id", id);
		 request.setAttribute("lastName", lastName);
		 request.setAttribute("fisrtName", fisrtName);
		 getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/modifySub.jsp").forward(request, response);
	}
		public ArrayList<Copy> getCopyByBorrower(int idClient){
			ArrayList<Copy> livre = service.getCopyByBorrower(idClient);
			return livre;
		}
		

		public void subscriber(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
			ArrayList<Subscriber> emprunteur = new ArrayList<Subscriber>();
			emprunteur = service.getAllSub();
			request.setAttribute("emprunteur", emprunteur);
			 getServletContext().getRequestDispatcher("/WEB-INF/views/Subscriber/Subscriber.jsp").forward(request, response);
		
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// on passe la main au get
			doGet(request, response);
		}
}
