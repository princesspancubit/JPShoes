<%@ page import = "java.io.*,java.util.*" %>
<%
	if(session.getAttribute("currCart") == null){
		session.setAttribute("currCart", new HashMap());
	}
%>

<html>
<head>
	<title>JP Shoes</title>
	<link rel='stylesheet' type='text/css' href='CSS/main.css'>
	<link rel='stylesheet' type='text/css' href='CSS/checkout.css'>
	<meta charset='UTF-8'>
	<meta name='viewport' content='width=device-width, initial-scale=1.0'>
</head>
<body>

<div id='container'>
	<div id='Navigation'>
		<ul>
			<li><a href='index.html'>Home</a></li>
			<li><a href='./products.jsp'>Products</a></li>
			<li class='active'><a href='./checkout.jsp'>Checkout</a></li>
			<li><a href='./editorder.jsp'>Orders</a></li>
			<li><a href='about.html'>About</a></li>
			<li><a href='contact.html'>Contact</a></li>
		</ul>
	</div>

	<center><h2>Shopping Cart:</h2>
	<%= session.getAttribute("currCart") %>
	</center>
		
	<center>
	<h2>Order Now!</h2>
	<form action="../jerseyrest/jpshoes/orders" method="POST">
	    <label>First Name: <br></label><input type='text' name='customerFirstName'><br><br>
        <label>Last Name: <br></label><input type='text' name='customerLastName'><br><br>
        <label>Phone Number: <br></label><input type='tel' name='phoneNumber'><br><br>
        <label>Email: </label><br><input type='email' id='email' name='email'><br><br>
        <label>Shipping Address: <br></label><input type='text' id = 'address' name='address'><br><br>
        <label>Shipping Method: </label><br>
        <input type='radio' name='shipping' value='overnight' checked> Overnight<br>
        <input type='radio' name='shipping' value='twoday'> 2 Days Expedited<br>
        <input type='radio' name='shipping' value='fiveseven'> 5-7 Business Days<br><br>
        <label>Card Number: </label><br><input type='text' name='cardNum'><br><br>
        <label>Name on Card: </label><br><input type='text' name='cardName'><br><br>
        <label>Expiration Date: </label><br>
        <input type='number' name='month' min='1' max='12'> / <input type='number' name='year' min='2018'><br><br>
	    <input type="submit" value="Submit" />
	</form>
	</center>
	
</div>
<div class='footer'>&copy; 2018 - JPShoes.Com, Inc</div>
</body>
</html>
