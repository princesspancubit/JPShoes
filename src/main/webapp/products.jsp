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
            <li class="active"><a href="./products.jsp">Products</a></li>
            <li><a href='./checkout.jsp'>Checkout</a></li>
            <li><a href='./editorder.jsp'>Orders</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="contact.html">Contact</a></li>
          </ul>  
      </div>
      <table id="demo"><br><br></table>
    </div>

    <div class="footer">
      &copy; 2018 - JPShoes.Com, Inc
    </div>


    <script type="text/javascript">
      function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
            loadTable(this.responseText);
          }
        }
        xhttp.open("GET", "jpshoes/products", true);
        xhttp.send();
      }

      function loadTable(responseText) {
        var productData = JSON.parse(responseText);
        var tableData = "";
        var rowCounter = 1;
        for(var index = 0; index < productData.length; index++) {
          if(rowCounter == 1) {
            tableData = tableData + "<tr>";
          }
          tableData = tableData + "<td><a href='./productDetails?productNumber=" + productData[index].productNumber + "'><img src='" + 
            productData[index].image + "'></a><label>" + 
            productData[index].name + "</label><label>$" + 
            productData[index].price.toFixed(2) + "</label><label>#" + 
            productData[index].productNumber + "<label></td>";

          if(rowCounter >= 4) {
            tableData = tableData + "</tr>";
            rowCounter = 1;
          } else {
              rowCounter = rowCounter + 1;
          }
        }
        document.getElementById("demo").innerHTML = tableData;
      }
      
      loadDoc();
    </script>
  </body>
</html>