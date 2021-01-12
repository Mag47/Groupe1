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
import model.Salarie;
import model.Service;
import model.TypeConges;


@WebServlet("/manage")
public class Manager extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conges> listeConges = Context.getInstance().getDaoConges().findAll();
		request.setAttribute("listeConges", listeConges);	
		request.setAttribute("typeConges", TypeConges.values() );
		
		List<Salarie> listsalarie = Context.getInstance().getDaoSalarie().findAll();
		request.setAttribute("listsalarie", listsalarie);	
		request.setAttribute("service", Service.values() );
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
