package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SalesmanDao;
import entity.Salesman;

/**
 * Servlet implementation class HandleChangePassword
 */
@WebServlet("/HandleChangePassword")
public class HandleChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String oldpw=request.getParameter("oldpw");
		SalesmanDao SD=new SalesmanDao();
		
		Salesman man=new Salesman(name,oldpw);
		Salesman staff=SD.signIn(man);
		if (staff==null)
		{
			out.println("The username or password is incorrent, please try it again.");
			request.getRequestDispatcher("changePassword.html").include(request, response);
		}
		else
		{
			String newpw=request.getParameter("newpw");
			Boolean ifsuccess=SD.updateSalesmanPd(staff, newpw);
			if (ifsuccess)
			{
				out.println("The password is changed.");
			}
			else
			{
				out.println("Fail.");
			}
		}
	}

}
