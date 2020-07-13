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
 * Servlet implementation class handleAddGood
 */
@WebServlet("/handleAddGood")
public class handleAddGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleAddGood() {
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
		String IDstr=request.getParameter("goodid");
		String namestr=request.getParameter("goodname");
		String pricestr=request.getParameter("goodprice");
		String numberstr=request.getParameter("goodnumber");
		int ID=Integer.parseInt(IDstr);
		double price=Double.parseDouble(pricestr);
		int number=Integer.parseInt(numberstr);
		Good good=new Good(ID,namestr,price,number);
		GoodsDao GD=new GoodsDao();
		Boolean ifsuccess=GD.addGood(good);
		PrintWriter out=response.getWriter();
		if (ifsuccess)
		{
			response.setContentType("text/html");
			out.println("<html><body><p>");
			out.println("The good "+namestr+" is added to the depot.<br>");
			out.println("ID="+ID+"<br>");
			out.println("name="+namestr+"<br>");
			out.println("price="+price+"<br>");
			out.println("number="+number+"<br>");
			out.println("</p></body></html>");
		}
		else {
			out.println("The good is not added to the depot.");
		}
		
	}

}
