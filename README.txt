README File

Group members: Jacqueline Lee and Princess Pancubit

URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/index.html
Database: inf124db030

Website layout: /jerseyrest/src/main

/java/com/uci/rest
/db
	|-- /DatabaseConfig.java
	|	-- The configurations to assist in connecting to the database.
	|-- /DatabaseConnector.java
	|	-- The method that creates a connection to the database.
	|-- /DatabaseUtils.java
		-- This contains methods that allow us to query the database.
/model (Requirements 2 & 3)
	|-- /Order.java
		-- POJO for orders in the database
	|-- /Product.java
		-- POJO for products in the database
/service
	|-- /OrderService.java
	|	-- Contains the methods that are used to call the assign4orders database concerning orders.
	|-- /ProductService.java
		-- Contains the methods that are used to retrieve the products in the database.

/java/com/uci/rest
	|-- /OrderResource.java
		-- Description of method
			METHOD TYPE: POST
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders
			SAMPLE RESPONSE: "Order Added Successfully!<br>Please click the button below to continue shopping. <br><br><a href='../products.jsp'><button>Return to Products page.</button></a>"
				-> Success or Error message
		-- Description of method
			METHOD TYPE: POST
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders
			SAMPLE RESPONSE: "Order Added Successfully!<br>Please click the button below to continue shopping. <br><br><a href='../products.jsp'><button>Return to Products page.</button></a>"
				-> Success or Error message
		-- Description of method
			METHOD TYPE: UPDATE
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders/{id}/{attribute}/{updateField}
			SAMPLE RESPONSE: "Order Updated Successfully."
				-> Success or Error message
			SAMPLE REQUEST: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders/123/customerFirstName/John
		-- Description of method
			METHOD TYPE: DELETE
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders/{id}
			SAMPLE RESPONSE: "Order Deleted Successfully."
				-> Success or Error message
			SAMPLE REQUEST: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/orders/123

	|-- /ProductResource.java
		-- Description of method
			METHOD TYPE: GET
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/products
			SAMPLE RESPONSE: [{"name":"Adidas Original NMD","price":130.0,"quantity":10,"productNumber":"A3984716","description":"Blending heritage with innovation, the NMD R1 includes a fresh, running-inspired design that will propel you into crisp style and outstanding performance.<br><br>- Innovative Boost midsole energized every step so the more you give, the more you get.<br>- One-piece Primeknit upper provides incredible comfort and unique colors for popping looks.","image":"./resources/AdidasOriginalsNMD.png"}, {...}, ...]
				-> List of JSON objects
		-- Description of method
			METHOD TYPE: GET
			REQUEST URL: http://centaurus-7.ics.uci.edu:3714/assign4/jpshoes/products/{id}
			SAMPLE RESPONSE: {"name":"Adidas Original NMD","price":130.0,"quantity":10,"productNumber":"A3984716","description":"Blending heritage with innovation, the NMD R1 includes a fresh, running-inspired design that will propel you into crisp style and outstanding performance.<br><br>- Innovative Boost midsole energized every step so the more you give, the more you get.<br>- One-piece Primeknit upper provides incredible comfort and unique colors for popping looks.","image":"./resources/AdidasOriginalsNMD.png"}
				-> One JSON object
			SAMPLE REQUEST: http://centaurus-7.ics.uci.edu:3714/jerseyrest/jpshoes/products/A3984716
	|--> detailedProductPageServlet.java
		-- Contains the product details stored in the database according to specific product id
		-- Users are able to add the product to cart on the page
		-- Uses servlet "session" to store the products in a shopping cart upon clicking "Add to Cart" 

/resources
	|--> db.config.properties
		-- Contains database configurations (username, password, servername, etc.)

/webapp/WEB-INF
	|--> web.xml 
		-- Contains servlet definitions and mappings
/webapp/products.jsp
	-- Displays the product table with data retrieved by the REST call in a JSP page (Requirement 1)
/webapp/editorder.jsp
	-- Displays input fields for the user to either delete an order or update an existing order (Requirement 2/3)

/webapp/index.html
	-- Contains home page for the website (same as Assignment 1)
/webapp/about.html
	-- Contains overview of the business (same as Assignment 1)
/webapp/contact.html
	-- Contains a form to contact the business (same as Assignment 1)
/webapp/CSS
	-- Contains CSS files for the website
/webapp/resources
	-- Contains images of products presented on website (same as Assignment 1)

