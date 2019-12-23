let user;

(function start(){
    let input = document.getElementById("btn-in");
    input.setAttribute("checked","checked");
}

) ();

function login(){
	user = {
			login :	 document.getElementById("iLogin").value,
			password : document.getElementById("iPassword").value
			};
	post(JSON.stringify(user),"login");
}


function registration(){	
	user = {
			login :	 document.getElementById("login").value,
			eMail : document.getElementById("eMail").value,
			password : document.getElementById("password").value
			};
	post(JSON.stringify(user),"registration");
}

function post(json,value){
	var value;
	let page = '';
	var xhr = new XMLHttpRequest();
	xhr.open("POST", `http://localhost:8082/sdfgbnm/users/${value}`, false);
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
	xhr.onreadystatechange = function() {
	    if(xhr.readyState == 4 && xhr.status == 200) {
	    	console.log(xhr.response);
    		value = xhr.response;
	    	if(value.length > 1){
	    		document.location.assign(value);
	    	} else{	    		
		    	alert("check input data");
	    	}
	    }
	}
	xhr.send(json);
}