let columnNameArray = ["user","place count","start date", "finish date", "apartament class","price"];
let rowCount = 0;
var apartaments = 'http://localhost:8082/sdfgbnm/apartaments';
var places = 'http://localhost:8082/sdfgbnm/places';
var listAparataments = '';
var listPlaces = '';
var user;

(function() {	
	var users = 'http://localhost:8082/sdfgbnm/users/15';
	$.getJSON(users, (data) => {
		user = data;
		 });
	
})();

(function() {	
	$.getJSON(apartaments, (data) => {
		data.forEach((option) => {
			listAparataments += `<option>${option}</option>`;
		})
	 });
})();

(function() {	
	$.getJSON(places, (data) => {
			data.forEach((option) => {
				listPlaces += `<option>${option}</option>`;
			})
	 });
})();

(function tableBuild(){
    let value = '';
    for(let i = 0; i < columnNameArray.length; i++){
        value +=  `<th id = "element">${columnNameArray[i]}</th>`;
    }
    document.getElementById('table').innerHTML += `<tr id = "columns">${value}</tr>`;

})();

function addRowInTable(){
    let value = '';
    
    if(rowCount === 0){
	    value +=  `<th id = "element">${user.id}</th>`;
	    value += "<th id = 'element'><select id = 'listPlaces' class = 'select'>" + listPlaces + "</select></th>";  
    	value +=  `<th id = "element"><input id = "startDate" type="date" name="calendar"></th>`;
    	value +=  `<th id = "element"><input id = "finishDate" type="date" name="calendar"></th>`;
    	value += "<th id = 'element'><select id = 'apartament' class = 'select'>" + listAparataments + "</select></th>";  
    	document.getElementById('table').innerHTML += `<tr id = "raw ${rowCount}">${value}</tr>`;
    	rowCount++;
    }
}

function saveOrder(){
	let startDate = new Date(document.getElementById("startDate").value);
	let finishDate = new Date(document.getElementById("finishDate").value);
	var order;
	if(startDate <= finishDate){
		order = {
				user : user,
				startDate : document.getElementById("startDate").value,
				finishDate : document.getElementById("finishDate").value,
				apartamentClass : document.getElementById("apartament").value,
				desiredPlaceCount : document.getElementById("listPlaces").value,
				status : "waiting",
				cost : 0.0
				};
		post(JSON.stringify(order));
		rowCount = 0;
	}else{
		alert("fail in date");
	}
}

function post(json){
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8082/sdfgbnm/orders", true);
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
	xhr.send(json);
}
