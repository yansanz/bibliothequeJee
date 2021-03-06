package fr.afpa.jeelibrary.service;

import java.util.ArrayList;

import fr.afpa.jeelibrary.model.Author;
import fr.afpa.jeelibrary.model.Book;
import fr.afpa.jeelibrary.model.Catalog;
import fr.afpa.jeelibrary.model.Copy;
import fr.afpa.jeelibrary.model.Subscriber;


public interface IService {

	public ArrayList<Book> RechTitre();
	
	public void modifCopy(int numeroCopy);
	
	public  ArrayList<Copy> getCopy(String ISBN) ;
	
	public void addCopy(String ISBN);
	
	public ArrayList<Catalog> getCatalog();
	
	public ArrayList<Author> ListAuthor();
	
	public void ajouterLivre(Book b);
	
	public Boolean dispoCopy(int idCopy);
	
	public void ajouterLivreAuteurExistant(Book b);
	
	public Author existOrNo(String name,String surname);
	
	public ArrayList<Subscriber> getAllSub();
	
	public ArrayList<Copy> getCopyByBorrower(int idClient);
	
	public void supprimEmprunteur(int id);
	
	public Boolean verifEmpruntAvanSuppression(int idClient);
	
	public Boolean getNbreEmprunt(int idClient);
	
	public void ajouterEmprunteur(Subscriber s);
	
	public Subscriber getOneEmprunteur(int id) ;
	
	public Subscriber getSubExemplaire(int numeroCopy);
	
	public void modifEmprunteur(Subscriber s);
	
	public Book RechIsbn(String ISBN);
	
	public Boolean dispoLivre(String ISBN);
	
	public  void Emprunte( String numeroIsbn,int numeroCopy, int idClient);
	
	public void Restitue( int numeroCopy, int idClient);
	
	public ArrayList<Book> RechTitreExact(String name) ;
	
	public  ArrayList<Book> RechGenre(String genre) ;
	
	public ArrayList<Book> RechAuthor(String auteur);
	
	public ArrayList<Subscriber> recherchNom(String name) ;
	
	public  ArrayList<Copy> getAllCopy() ;
}
