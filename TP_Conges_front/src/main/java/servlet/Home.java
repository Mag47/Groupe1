package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Salarie;
import model.Compte;
import model.Manager;

@WebServlet("/home")
public class Home extends HttpServlet {
	
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("typeCompte")=="manager")
		{
			response.sendRedirect("manage");
		}
		else if(request.getSession().getAttribute("typeCompte")=="salarie")
		{
			int idCompte=((Compte) request.getSession().getAttribute("compte")).getId();
			response.sendRedirect("sal");

		}
		else
		{
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String password = request.getParameter("password");
		Compte c = Context.getInstance().getDaoCompte().connect(mail, password);

		if(c instanceof Manager) 
		{
			request.getSession().setAttribute("compte", c);
			request.getSession().setAttribute("typeCompte", "manager");
			response.sendRedirect("manage");
		}
		else if(c instanceof Salarie) 
		{
			request.getSession().setAttribute("compte", c);
			request.getSession().setAttribute("typeCompte", "employe");
			response.sendRedirect("sal");
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			doGet(request,response);
		}
	}

}
