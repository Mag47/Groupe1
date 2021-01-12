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

@WebServlet("/filterEmp")
public class FilterEmp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtre = request.getParameter("filterName");
		List<Conges> conges = Context.getInstance().getDaoConges().findAllFilter(filtre);

		for(Conges cp : conges) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+cp.getId()+"</td>");
			response.getWriter().println("<td>"+cp.getMotif()+"</td>");
			response.getWriter().println("<td>"+cp.getDateDebut()+"</td>");
			response.getWriter().println("<td>"+cp.getDateFin()+"</td>");
			response.getWriter().println("<td>"+cp.getSalarie().getId()+"-"+cp.getSalarie().getNom()+"</td>");
			response.getWriter().println("</tr>");
		}
		
	}

}
