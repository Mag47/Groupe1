package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Conges;


@WebServlet("/conge")
public class CongesServlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Conges> listeConges = Context.getInstance().getDaoConges().findAll();
		
		request.setAttribute("listeConges", listeConges);	
		System.out.println(listeConges);
		this.getServletContext().getRequestDispatcher("/WEB-INF/salarie.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
