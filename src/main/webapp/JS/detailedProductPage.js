function calculateTotal(itemName) {
	var basePrice;

	switch(itemName) {
		case "AdidasOriginalsNMD":
			basePrice = 130;
			break;
		case "AdidasOriginalsSuperstar":
			basePrice = 59.99;
			break;
		case "AsicsTigerGelLyte":
			basePrice = 170;
			break;
		case "NikeAirForce1":
			basePrice = 89.5;
			break;
		case "NikeAirHuarache":
			basePrice = 80;
			break;
		case "Nike97":
			basePrice = 165;
			break;
		case "NikeAirMaxPlus":
			basePrice = 169.99;
			break;
		case "NikeAirPresto":
			basePrice = 120;
			break;
		case "NikeAshinModern":
			basePrice = 74.5;
			break;
		case "PumaSuedeClassic":
			basePrice = 35;
			break;
		case "PumaSuedeVelvet":
			basePrice = 55.99;
			break;
		case "VansOldSkool":
			basePrice = 60;
			break;
	}

	var quantity = document.getElementById("quantity").value;
	document.getElementById("total").innerHTML = "<b>TOTAL: $" + (basePrice*quantity).toFixed(2) + "</b>";
}