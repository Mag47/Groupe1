package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Conges;

import model.TypeConges;
import model.Salarie;

@WebServlet("/conge")
public class CongesServlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Conges> listeConges = Context.getInstance().getDaoConges().findAll();
		
		request.setAttribute("listeConges", listeConges);	
		System.out.println(listeConges);
		this.getServletContext().getRequestDispatcher("/WEB-INF/salarie.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupere les parametres suivants : id_sal dateDebut dateFin id_type motif
	//reucp employe id_sal puis created new conge avec param+employe
		//save et rediriger la page pour afficher en DOge
		
		Integer id = Integer.parseInt(request.getParameter("id_sal"));
		TypeConges typeconge = TypeConges.valueOf(request.getParameter("id_type"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		String motif = request.getParameter("motif");

		 
		Salarie s = Context.getInstance().getDaoSalarie().findById(id);
		
		Conges conges=new Conges (dateDebut,dateFin,motif,typeconge,s);
	
		Context.getInstance().getDaoConges().save(conges);
				
		
		doGet(request,response);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(request.getParameter("id_conges"));
		Conges conges = Context.getInstance().getDaoConges().findById(id);
		Context.getInstance().getDaoConges().delete(conges);
	}
}
