import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
 
@WebServlet(name = "/productDetails")
public class detailedProductPageServlet extends HttpServlet {

private synchronized void addItemToViewingList(HttpServletRequest request) throws ServletException {
	HttpSession session = request.getSession(true);

	if(session.getAttribute("recentProductList") == null) {
		session.setAttribute("recentProductList", new ArrayList());
	}
	List<String> viewingList = (List<String>)session.getAttribute("recentProductList");
	if(viewingList.size() >= 5) {
		viewingList.remove(0);
	}
	viewingList.add(request.getParameter("productNumber"));
}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection con = null;
	Statement stmt = null; 
	ResultSet rs = null;

	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html><html>");
	out.println("<head>");
	out.println("<title>JP Shoes</title>");  
	out.println("<link rel='stylesheet' type='text/css' href='CSS/main.css'><link rel='stylesheet' type='text/css' href='CSS/detailedProductPage.css'><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>");          
	out.println("</head>");
	out.println("<body>");
	out.println ("<div id='container'>");
	out.println("<div id='Navigation'><ul><li><a href='index.html'>Home</a></li><li class='active'><a href='products.jsp'>Products</a></li><li><a href='./recent'>Recent</a></li><li><a href='checkout.jsp'>Checkout</a></li><li><a href='about.html'>About</a></li><li><a href='contact.html'>Contact</a></li></ul></div>");

	out.println("<table>");

	try {
		Class.forName ("org.gjt.mm.mysql.Driver");
		con = DriverManager.getConnection ("jdbc:mysql://matt-smith-v4.ics.uci.edu/inf124db030", "inf124db030", "e78a.xh!R8NH");
		stmt = con.createStatement();
		String productNumber = request.getParameter("productNumber");
		rs = stmt.executeQuery("SELECT * FROM products WHERE productNumber='"+productNumber+"' LIMIT 1"); 
		while(rs.next()) {		
			String productName = rs.getString("name");
			Float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			String description = rs.getString("description");
			String productImage = rs.getString("image");

			out.println("<table>");
			out.println("<tr><td><h2>"+productName+"</h2>");
			out.println("<img src='"+productImage+"'class='imgs'>");
			out.println("<h3 id='setProductPrice'>Price: $"+price+"</h3>");
			out.println("<p><b><i><center>Product #: "+productNumber+"</center></i></b></p>");
			out.println("<p>"+description+"</p>");	
			out.println("<p><br><form name='addToCart' method='post'>");
			out.println("<label>Quantity: </label><input type='number' id='quantity' name='quantity' min='1' value='1'><br>");
			out.println("<br><input type='submit' value='Add to Cart'><br></p></form</td>"); 

		}
		
		if(request.getAttribute("fromRecentPage") == null) {
			addItemToViewingList(request);
		} else {
			request.setAttribute("fromRecentPage", null);
		}

    } catch(Exception e) {
		out.println(e);
	} finally {
		try {
		  con.close(); 
		} catch(Exception e) {}
		try {
		  stmt.close(); 
		} catch(Exception e) {}
		try {
		  rs.close(); 
		} catch(Exception e) {}
	}
	out.println("</tr></table>");
	out.println("</div><div class='footer'>&copy; 2018 - JPShoes.Com, Inc</div>");
	out.println("</body>");
	out.println("</html>");
	
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession sess = request.getSession(true);
	PrintWriter out = response.getWriter();
	String productNumber = "Product Number: #" + request.getParameter("productNumber");
	Integer quantity = Integer.parseInt(request.getParameter("quantity"));

	if(sess.getAttribute("currCart") == null) {
		sess.setAttribute("currCart", new HashMap());
	}
	Map<String, Integer> cart = (Map<String, Integer>)sess.getAttribute("currCart");
	cart.put(productNumber, quantity);
	response.sendRedirect("checkout.jsp");
  }

}
