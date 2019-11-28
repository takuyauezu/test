package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testservlet
 */
public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
        //super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//やっていく内容を記述
		String a = request.getParameter("category");
		System.out.println(a);


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Test.jsp");
		rd.forward(request, response);
	}

}
