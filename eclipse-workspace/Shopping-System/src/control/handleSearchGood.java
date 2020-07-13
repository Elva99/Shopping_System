package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import entity.Good;

/**
 * Servlet implementation class handleSearchGood
 */
@WebServlet("/handleSearchGood")
public class handleSearchGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleSearchGood() {
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
		String name=request.getParameter("goodname");
		//System.out.println(name);
		//return;
		
		GoodsDao GD=new GoodsDao();
		Good good=GD.displayGoodByName(name);
		
		
		if (good==null)
		{
			System.out.println("The good does not exist.");
			return;
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Good information</h3>");
		out.println("<p>"+"ID:"+good.getGid()+"</p>");
		out.println("<p>"+"name:"+good.getGname()+"</p>");
		out.println("<p>"+"price:"+good.getGprice()+"</p>");
		out.println("<p>"+"number:"+good.getGnum()+"</p>");
		out.println("</body></html>");
		out.close();
		
	}

}
