<html>
  <head>
    <title>JP Shoes</title>
    <link rel="stylesheet" href="CSS/main.css">
    <link rel='stylesheet' type='text/css' href='CSS/products.css'>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
  <body>
    <div id="container">
      <div id="Navigation"> 
          <ul>
          <li><a href="index.html">Home</a></li>
          <li><a href="./products.jsp">Products</a></li>
          <li><a href='./checkout.jsp'>Checkout</a></li>
          <li class="active"><a href='./editorder.jsp'>Orders</a></li>
          <li><a href="about.html">About</a></li>
          <li><a href="contact.html">Contact</a></li>
        </ul>  
      </div>
      <center>
      	<h1><center>Edit Exisiting Order</center></h1>
		<table border='1' width="100%" margin="auto">
			<tr>
				<td width="50%">
					<h3><center>To DELETE an existing order please fill out the form below.</center></h3>
					<form name="toDeleteForm" onsubmit="deleteOrder()">
						Order ID: <input id="orderIdDelete" name="orderid"></input>
						<br><br>
						<input type="submit" value="Remove Order">
					</form>
					<p id = "msg">
				</td>
				<td width="50%">
					<h3><center>To UPDATE shipping information from a previous order, please fill out the form below and choose which item you would like to update.</center></h3>
					<form name="toEditForm" onsubmit="updateOrder()">
						Order ID: <input id="orderIdUpdate" name="orderid"></input>
						<br>
						<br>
						<select name="attribute" id="attribute">
						    <option value="customerFirstName">First Name</option>
						    <option value="customerLastName">Last Name</option>
						    <option value="phoneNumber">Phone Number</option>
						    <option value="email">Email</option>
						    <option value="shipAdd">Shipping Address</option>
						    <option value="shipMeth">Shipping Method</option>
						    <option value="cardNum">Card Number</option>
						    <option value="cardName">Card Name</option>
						    <option value="month">Month</option>
						    <option value="year">Year</option>
					  	</select>
					  	<input name="updateField" id="updateField" type="text">
					  	<br>
					  	<br>
					  	<input type="submit" value="Submit">
					  </form>
				</td>
			</tr>
		</table>
	</center>
    </div>

    <script>
    	function deleteOrder() {
    		var xhttp = new XMLHttpRequest();
	        xhttp.open("DELETE", "../jerseyrest/jpshoes/orders/" + document.getElementById("orderIdDelete").value, true);
	        xhttp.send();
	        alert("Order Successfully Deleted.");
    	}
    	
    	function updateOrder(){
    		var xhttp = new XMLHttpRequest();
	        xhttp.open("PUT", "../jerseyrest/jpshoes/orders/" + document.getElementById("orderIdUpdate").value + "/" + document.getElementById("attribute").value + "/" + document.getElementById("updateField").value, true);
	        xhttp.send();
	        alert("Order Successfully Updated.");
    	}
    	
    </script>
</body>

    <div class="footer">
      &copy; 2018 - JPShoes.Com, Inc
    </div>
</html>