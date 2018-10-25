function validation() {
	var name = document.getElementById('name_input').value;
	var mobileNumber = document.getElementById('mobile_input').value;
	var email = document.getElementById('email_input').value;
	var pincode = document.getElementById('pincode_input').value;
	var area = document.getElementById('select_tag_area').value;
	var state = document.getElementById('select_tag_state').value;


	if (name == "") {
		document.getElementById('name_span').innerHTML = " * Please fill the username field";
		return false;
	}
	else if ((name.length <= 2) || (name.length > 20)) {
		document.getElementById('name_span').innerHTML = " * Username lenght must be between 2 and 20";
		return false;
	}
	else if (!isNaN(name)) {
		document.getElementById('name_span').innerHTML = " * only characters are allowed";
		return false;
	}

	else if (mobileNumber == "") {
		document.getElementById('mobile_span').innerHTML = " * Please fill the Mobile Nnmber field";
		return false;
	}
	else if (mobileNumber.length != 10) {
		document.getElementById('mobile_span').innerHTML = "* Mobile length must be equal 10";
		return false;
	}
	else if (isNaN(mobileNumber)) {
		document.getElementById('mobile_span').innerHTML = "* Must write digits only not characters for valid mobile number";
		return false;
	}
	else if (email == "") {
		document.getElementById('email_span').innerHTML = "* Please fill the email id field";
		return false;
	}
	else if (email.indexOf('@') <= 0) {
		document.getElementById('email_span').innerHTML = "@ Invalid Position";
		return false;
	}

	else if ((email.charAt(email.length - 4) != '.')
			&& (email.charAt(email.length - 3) != '.')) {
		document.getElementById('email_span').innerHTML = ". Invalid Position";
		return false;
	}
	
	else if (pincode == "") {
		document.getElementById('pincode_span').innerHTML = "* Please fill the Mobile Nnmber field";
		return false;
	}
	else if (pincode.length != 6) {
		document.getElementById('pincode_span').innerHTML = "* Mobile length must be equal 10";
		return false;
	}
	else if (isNaN(pincode)) {
		document.getElementById('pincode_span').innerHTML = "* Must write digits only not characters for valid mobile number";
		return false;
	}
	else{
//		console.log(""+name);
//		console.log(""+mobileNumber);
//		console.log(""+area);
//		console.log(""+email);
//		console.log(""+state);
//		console.log(""+pincode);
		$.ajax({
			url : 'GetUserDataSevlet',
			type : 'POST',
			data : {
				name_input:name,
				mobile_input:mobileNumber,
				pincode_input:pincode,
				select_tag_area:area,
				email_input:email,
				select_tag_state:state
			},
			success : function(result) {
				alert(result);
				console.log(""+result);
			}
		});
	}	
	}

function funEmail() {

	var email = document.getElementById('email_input').value;

	if (email == "") {
		document.getElementById('email_span').innerHTML = "* Please fill the email id field";
	} else if (email.indexOf('@') <= 0) {
		document.getElementById('email_span').innerHTML = "@ Invalid Position";
	} else if ((email.charAt(email.length - 4) != '.')
			&& (email.charAt(email.length - 3) != '.')) {
		document.getElementById('email_span').innerHTML = ". Invalid Position";
	} else {
		document.getElementById('email_span').innerHTML = "";
	}

}

function funMobile() {
	var mobileNumber = document.getElementById("mobile_input").value;
	if (mobileNumber == "") {
		document.getElementById('mobile_span').innerHTML = " * Please fill the Mobile Nnmber field";
	} else if (mobileNumber.length != 10) {
		document.getElementById('mobile_span').innerHTML = "* Mobile length must be equal 10";
	} else if (isNaN(mobileNumber)) {
		document.getElementById('mobile_span').innerHTML = " *Must write digits only not characters for valid mobile number";
	} else {
		document.getElementById('mobile_span').innerHTML = "";
	}
}

function funName() {
	var name = document.getElementById("name_input").value;
	if (name == "") {
		document.getElementById('name_span').innerHTML = " * Please fill the username field";
	} else if ((name.length <= 2) || (name.length > 20)) {
		document.getElementById('name_span').innerHTML = " * Username lenght must be between 2 and 20";
	} else if (!isNaN(name)) {
		document.getElementById('name_span').innerHTML = " * only characters are allowed";
	} else {
		document.getElementById('name_span').innerHTML = "";
	}
}

function myfunction(x) {
	pincode = x;
	if (x.length != 6) {
		document.getElementById('pincode_span').innerHTML = "Please enter six digit valid pincode";

	} else {
		document.getElementById('pincode_span').innerHTML = "";
		var s = document.getElementById('pincode_input').value;
		var pincode;
		$.ajax({
			url : 'QueryAreaServlet',
			type : 'POST',
			data : {
				pincode_input : x,
			},
			success : function(result) {
				var dat = JSON.parse(result);
				var options = "";
				dat.forEach(function(element) {
					options = options + "<option>" + element + "</option>";
					console.log(options);
				});
				document.getElementById('select_tag_area').innerHTML = options;
			}
		});

		$.ajax({
			url : 'QueryStateServlet',
			type : 'POST',
			data : {
				pincode_input : x,
			},
			success : function(result) {
				var options = "";
				options = "<option>" + result + "</option>";
					document.getElementById('select_tag_state').innerHTML = options;
			}
		});
		
	}
}