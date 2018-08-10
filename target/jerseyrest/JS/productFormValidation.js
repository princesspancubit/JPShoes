
function validateForm() {
  var productForm = document.forms["productForm"];
  return validateFirstName(productForm["customerFirstName"].value) 
    && validateLastName(productForm["customerLastName"].value)
    && validatePhoneNumber(productForm["phoneNumber"].value)
    && validateEmail(productForm["email"].value)
    && validateAddress(productForm["address"].value)
    && validateProductNumber(productForm["productNumber"].value)
    && validateQuantity(productForm["quantity"].value)
    && validateCardNum(productForm["cardNum"].value)
    && validateCardName(productForm["cardName"].value)
    && validateMonth(productForm["month"].value)
    && validateYear(productForm["year"].value);
}

function onSubmit() {
  if(validateForm()) {
    var form = document.forms["productForm"];
    var email = form["email"].value;
    var sub = "Order Confirmation";
    var fname = "First Name: " + form["customerFirstName"].value + "\n"; 
    var lname = "Last Name: " + form["customerLastName"].value + "\n";
    var phone = "Phone Number: " + form["phoneNumber"].value + '\n';
    var email_format = "Email: " + email + '\n';
    var shipping = "Shipping Address: " + form["address"].value + '\n';
    var ship_method = "Shipping Method: " + form["shipping"].value + '\n';
    var prodNum = "Product Number: " + form["productNumber"].value + '\n';
    var quantity = "Quantity: " + form["quantity"].value + '\n';
    var cardnum = "Card Number: " + form["cardNum"].value + '\n';
    var cardname = "Card Name: " + form["cardName"].value + '\n';
    var exp = "Expiration Date: " + form["month"].value + "/" + form["year"].value + '\n';
    var body = fname+lname+phone+email_format+shipping+ship_method+prodNum+quantity+cardnum+cardname+exp;
    body = encodeURIComponent(body);
    var link = "mailto:"+email+"?cc=jpshoes@gmail.com"+"&subject="+sub+"&body="+body;
    location.href =link;
  }
return false;
}
  




function validateFirstName(customerFirstName) {
  if (customerFirstName == "") {
      alert("First name must be filled out.");
      return false;
  } else {
    var re = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
    if(!re.test(customerFirstName)){
      alert("Invalid first name.")
    }
  }
  return true;
}

function validateLastName(customerLastName) {
  if (customerLastName == "") {
      alert("Last name must be filled out.");
      return false;
  } else {
    var re = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
    if(!re.test(customerLastName)){
      alert("Invalid last name.")
    }
  }
  return true;
}

function validatePhoneNumber(phoneNumber) {
  if (phoneNumber == "") {
    alert("Phone number must be filled out.");
    return false;
  } else {
    var re = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
    if(!re.test(phoneNumber)) {
      alert("Invalid phone number.");
      return false;
    }
  }
  return true;
}

function validateAddress(address) {
  if (address == "") {
    alert("Address must be filled out.");
    return false;
  } 
  return true;
}

function validateProductNumber(productNumber) {
  if (productNumber == "") {
    alert("Product number must be filled out.");
    return false;
  } 
  return true;
}

function validateEmail(email) {
  if (email == "") {
    alert("Email must be filled out.");
    return false;
  } else {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!re.test(email)) {
      alert("Invalid email address.");
      return false;
    }
  }
  return true;
}

function validateQuantity(quantity) {
  if (quantity == "") {
    alert("Quantity must be filled out.");
    return false;
  } 
  return true;
}


//Visa: starts with 4 and has either 16 or 13 digits
//MasterCard: starts with numbers 51 through 55 or with  
//numbers 2221 through 2720. (16 digits as well)
//American Express: starts with 34 or 37 and has 15 digits
//Discover: starts with 6011 or 65 and has 16 digits
function validateCardNum(cardNum){
  if (cardNum == "") {
    alert("Card number must be filled out.");
    return false;
  } else {
    var re = /^(?:4[0-9]{12}(?:[0-9]{3})?|(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}|3[47][0-9]{13}|6(?:011|5[0-9]{2})[0-9]{12})$/;
    if(!re.test(cardNum)) {
      alert("Invalid Credit Card Number\nVisa: starts with the number 4 and has either 16 or 13 digits\nMasterCard: starts with numbers 51 through 55 or with numbers 2221 through 2720\nAmerican Express: starts with 34 or 37 and has 15 digits\nDiscover: starts with 6011 or 65 and has 16 digits\n(EX: 4444444444444444)");
      return false;
    }
  }
  return true;
}

function validateCardName(cardName) {
  if (cardName == "") {
    alert("Card name must be filled out.");
    return false;
  } else {
    var re = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
    if(!re.test(cardName)){
      alert("Invalid card name.")
    }
  }
  return true;
}

function validateMonth(month) {
  if (month == "") {
    alert("Card expiration month must be filled out.");
    return false;
  } else if(isNaN(month) || month < 1 || month > 12) {
    alert("Invalid card expiration month.")
    return false;
  }
  return true;
}

function validateYear(year) {
  if (year == "") {
    alert("Card expiration year must be filled out.");
    return false;
  } else if(isNaN(year)) {
    alert("Invalid card expiration month.")
    return false;
  }
  return true;
}