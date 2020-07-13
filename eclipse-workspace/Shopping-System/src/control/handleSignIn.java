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
 * Servlet implementation class handleSignIn
 */
@WebServlet("/handleSignIn")
public class handleSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String pw=request.getParameter("password");
		SalesmanDao SD=new SalesmanDao();
		Salesman man=new Salesman(name,pw);
		Salesman staff=SD.signIn(man);
		if (staff==null)
		{
			//out.println("Your username or password is wrong, please enter the correct information");
			RequestDispatcher dis1=request.getRequestDispatcher("login.html");
			dis1.include(request, response);
		}
		else
		{
			RequestDispatcher dis2=request.getRequestDispatcher("salesmanChoice.html");
			dis2.forward(request, response);
		}
	}

}
